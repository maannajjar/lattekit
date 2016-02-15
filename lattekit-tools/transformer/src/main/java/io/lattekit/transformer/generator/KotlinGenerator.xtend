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

    val static TOKENS_RE = Pattern.compile('''(class\s+([^\s]*)\s*(?:(:)\s+([^\n]*)\s*)\{|(?:override\s+fun|fun)\s+render\(\)+\s+=\s+"""((?:(?!""")[\S\s])*)"""|("""|'|")(?:(?=(\\?))\7[\S\s])*?\6|(\/\*)(?:(?=(\\?))\9[\S\s])*?\*\/|\/\/.*|[\S\s])''');

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

    def getFirstParams(Tag tag) {
        return '''"«tag.name»"'''
    }

    override String compile(Tag tag) '''
    «IF tag.parentTag == null»
    override fun renderImpl() : LatteView? {
        return «ENDIF» LatteView.createLayout(«getFirstParams(tag)», LatteView.props(«tag.props.map[compile].join(",")»),  { ->
            val myChildren = java.util.ArrayList<LatteView>();
            «FOR child : tag.childNodes»
                «IF child instanceof TextNode»«child.text»«ENDIF»
                «IF child instanceof Tag»
                    myChildren.add(«child.compile»);
                «ENDIF»
            «ENDFOR»
            myChildren;
        })
    «IF tag.parentTag == null»
    }
    «ENDIF»
    '''


    def static void main(String... args) {
        println(new KotlinGenerator().transform("com.diggreader", '''
class KotlinHomeFeedImpl : LatteView() {

    internal var items: List<Story> = ArrayList();
    internal var realm: Realm? = null;
    @Prop
    internal var refreshLayout: SwipeRefreshLayout? = null
    internal var isRefreshing = false;

    override fun onViewMounted() {
        realm = Realm.getInstance(this.activity)
        downloadFeed();
        displayFeed();
    }

    fun downloadFeed() {
        ApiManager.getApi().getNews("top")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response ->
                    log("Saving feed");
                    realm?.executeTransaction { realm?.copyToRealmOrUpdate(response.data.feed) }
                }
    }

    fun displayFeed() {
        realm?.where(Story::class.java)
                ?.findAllAsync()
                ?.asObservable()
                ?.subscribe { results ->
                    items = results;
                    onStateChanged();
                };
    }

    fun handleStoryClick(story: Story) {
        LatteView.createLayout("com.digg2.ui.ArticleView", mapOf("stories" to items, "currentStory" to story)).show(this);
    }

    fun doRefresh() {
        Handler().postDelayed({
            isRefreshing = false;
            onStateChanged()
        }, 3000)
    }


    fun render() = """
        <LinearLayout orientation="vertical" cls="container">
            <android.support.v4.widget.SwipeRefreshLayout ref="refreshLayout" refreshing={isRefreshing} onRefresh={{ doRefresh() }} size={SwipeRefreshLayout.LARGE}>
                <ListView data={items} cls="container" dividerHeight={0} onItemClick={{ s :Story -> handleStoryClick(s) }}>
                    <com.digg2.ui.MarqueeStoryCell when={{ item : Story, index: Int -> index == 0}} />
                    <com.digg2.ui.CompactStoryCell defaultView="true"  />
                </ListView>
            </android.support.v4.widget.SwipeRefreshLayout>
        </LinearLayout>
    """
}

        '''))
    }
}
