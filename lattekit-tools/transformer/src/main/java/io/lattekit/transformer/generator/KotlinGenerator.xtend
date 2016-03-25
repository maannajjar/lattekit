package io.lattekit.transformer.generator

import io.lattekit.transformer.parser.CodeProp
import io.lattekit.transformer.parser.CodeStatement
import io.lattekit.transformer.parser.DictProp
import io.lattekit.transformer.parser.LambdaProp
import io.lattekit.transformer.parser.Prop
import io.lattekit.transformer.tree.Tag
import io.lattekit.transformer.tree.TextNode
import java.util.List
import java.util.regex.Pattern
import io.lattekit.Reflection

class KotlinGenerator extends BaseGenerator {

    val static TOKENS_RE = Pattern.compile('''(class\s+([^\s]*)\s*(?:(:)\s+([^\n]*)\s*)\{|lxml\(\s*"""((?:(?!""")[\S\s])*)"""\s*\)|("""|'|")(?:(?=(\\?))\7[\S\s])*?\6|(?:override\s*)?fun\s+([^{=]*)\s*(=|\{)\s*|(\/\*)(?:(?=(\\?))\9[\S\s])*?\*\/|\/\/.*|[\S\s])''');

    override getTokensPattern() {
        return TOKENS_RE
    }
    override extendsKeyword() { ":" }

    def String compile(Prop prop) { prop.compileProp }

    def dispatch String compileProp(Prop prop) ''' "«prop.name»",«compilePropStringValue(prop.value)» '''
    def dispatch String compilePropOption(Prop prop) ''' "«prop.name»" to «IF prop.modifier == "@"»io.lattekit.PropOption.WAIT_LAYOUT«ELSE»0«ENDIF» '''

    def dispatch String compileProp(CodeProp prop) ''' "«prop.name»",«prop.value» '''

    def dispatch String compileProp(DictProp prop) ''' "«prop.name»",«prop.value» '''

    def dispatch String compileProp(LambdaProp prop) ''' "«prop.name»", [ «prop.paramList.join(",")» |
            «prop.statements.compileStatements»
        ]'''

    def compileStatements(List<CodeStatement> statements) '''
    «FOR i : 0..<statements.length»
        «statements.get(i).text»
    «ENDFOR»
    '''


    def String getTypeName(Class type, boolean addOptional) {
        if (type.name == "java.lang.CharSequence") {
            return "String"+(if (addOptional) "?" else "")
        } else if (type.isPrimitive) {
            return type.name.substring(0,1).toUpperCase() + type.name.substring(1)
        } else {
            return type.name.replaceAll("\\$",".")+(if (addOptional) "?" else "")
        }
    }
    def String compileProp(Prop prop, Class clz) {
        var field = if (prop.name.startsWith("@")) {
            prop.name.substring(1)
        } else prop.name;

        val setter = "set" + field.substring(0, 1).toUpperCase() + field.substring(1)
        var methods = Reflection.findMethods(clz, setter);
        val isFn = if (methods.empty) {
            methods = Reflection.findMethods(clz, setter+"Listener");
            true
        } else { false }
        if (methods.empty || setter == "setOnClick" || setter == "setOnTouch") {
            return "";
        }
        return '''if (propKey == "«prop.name»") {;
        '''
            + methods.map['''
            if (propValue is «IF isFn»Function<*>«ELSE»«getTypeName(it.parameters.get(0).type,true)»«ENDIF») {
                «IF isFn»
                    var listener = io.lattekit.Latte.createLambdaProxyInstance(«getTypeName(it.parameters.get(0).type,false)»::class.java, propValue as Object) as «getTypeName(it.parameters.get(0).type,true)»
                    view.«setter»«IF isFn»Listener«ENDIF»(listener);
                «ELSE»
                    view.«setter»(propValue as «getTypeName(it.parameters.get(0).type,true)»);
                «ENDIF»
                acceptedProps.add("«prop.name»");
            }
        '''].join("else ") +" }"
    }
    def String compileNative(Tag tag, Class clz) {
        '''io.lattekit.Latte.createNative(«clz.name»::class.java, io.lattekit.Latte.props(«tag.props.map[compile].join(",")»),mapOf(«tag.props.map[compilePropOption].join(",")»), { viewWrapper, props ->
            var view = viewWrapper.androidView as «clz.name»;
            var acceptedProps = mutableListOf<String>();
            props.forEach {
                var propKey = it.key;
                var propValue = it.value;
                «FOR prop : tag.props»
                    «compileProp(prop, clz)»
                «ENDFOR»
            }
            acceptedProps
        }, { it : LatteView ->
                «FOR child : tag.childNodes»
                    «IF child instanceof TextNode»«child.text»«ENDIF»
                    «IF child instanceof Tag»
                        it.addChild(«child.compile»);
                    «ENDIF»
                «ENDFOR»
            })
        '''
    }

    override String compile(Tag tag) {
        var clz = Reflection.lookupClass(tag.name)
        if (clz != null) {
            return compileNative(tag, clz)
        }
        '''io.lattekit.Latte.create(io.lattekit.Latte.lookupClass("«tag.name»"), io.lattekit.Latte.props(«tag.props.map[compile].join(",")»), mapOf(«tag.props.map[compilePropOption].join(",")»),{ it : LatteView ->
            «FOR child : tag.childNodes»
                «IF child instanceof TextNode»«child.text»«ENDIF»
                «IF child instanceof Tag»
                    it.addChild(«child.compile»);
                «ENDIF»
            «ENDFOR»
        })
        '''
    }


    def static void main(String... args) {
        println(new KotlinGenerator().transform("com.diggreader", '''


class ArticleView : LatteView() {

    @Prop var stories : List<Any?>?  = null;
    @Prop var selectedStory : Int? = null;
    @Prop var story : Story? = null;
    @Prop var edition : DiggEdition? = null;

    var pager : ViewPager? = null;

    init {
        css("com.digg2.style/main.css")
    }

    override fun layout() = lxml("""
        <com.digg2.ui.SingleArticleView defaultView=${true} model=${story} edition=${edition} />
    """)
}

class SingleArticleView : LatteView() {
    @Prop("model") var story : Story ? = null;
    @Prop var edition : DiggEdition? = null;
    var webView : WebView? = null;
    var progressBar : ProgressBar? = null;
    var currentProgress : Int? = 0;
    init {
        css {
            block(".progress") {
                width("match_parent")
                height("5dp")
                backgroundColor("#ffffff")
                marginTop("-2dp")
            }
        }
    }

    override fun onViewMounted() {
        super.onViewMounted()

        Analytics.logEvent("Read Story", mapOf("content_id" to this.story?.contentId!!, "edition_id" to this.edition?.editionId!!))

        webView?.getSettings()?.javaScriptEnabled = true;
        webView?.loadUrl(this.story?.content?.url)
        webView?.setWebViewClient(object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return false;
            }
        })
        webView?.setWebChromeClient(object: WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                currentProgress = newProgress;
                progressBar?.setProgress(currentProgress!!);
            }
        })
    }

    override fun layout() = lxml("""
        <LinearLayout orientation="vertical">
            <ProgressBar ref="progressBar" style="@android:attr/progressBarStyleHorizontal"  max={100} progress=${currentProgress} cls="progress" alignParentTop={true}/>
            <WebView ref="webView" cls="article_view" layout_width="match_parent" layout_height="match_parent"/>
        </LinearLayout>
    """)
}




        '''))
    }
}
