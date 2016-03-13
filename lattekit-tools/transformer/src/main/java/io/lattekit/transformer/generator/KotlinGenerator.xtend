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

class KotlinGenerator extends BaseGenerator {

    val static TOKENS_RE = Pattern.compile('''(class\s+([^\s]*)\s*(?:(:)\s+([^\n]*)\s*)\{|lxml\(\s*"""((?:(?!""")[\S\s])*)"""\s*\)|("""|'|")(?:(?=(\\?))\7[\S\s])*?\6|(?:override\s*)?fun\s+([^{=]*)\s*(=|\{)\s*|(\/\*)(?:(?=(\\?))\9[\S\s])*?\*\/|\/\/.*|[\S\s])''');

    override getTokensPattern() {
        return TOKENS_RE
    }
    override extendsKeyword() { ":" }

    def String compile(Prop prop) { prop.compileProp }

    def dispatch String compileProp(Prop prop) ''' "«prop.name»",«compilePropStringValue(prop.value)» '''

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



    override String compile(Tag tag) '''
        io.lattekit.Latte.create(io.lattekit.Latte.lookupClass("«tag.name»"), io.lattekit.Latte.props(«tag.props.map[compile].join(",")»), io.lattekit.ui.view.ChildrenProc { it : LatteView ->
            «FOR child : tag.childNodes»
                «IF child instanceof TextNode»«child.text»«ENDIF»
                «IF child instanceof Tag»
                    it.addChild(«child.compile»);
                «ENDIF»
            «ENDFOR»
        })
    '''


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
