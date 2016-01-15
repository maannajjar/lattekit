package io.lattekit.compiler2

import java.util.List
import java.util.Stack
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data

interface CodeExtractor {
	
	def void readSource(String source);
	def LayoutCode getNext()
}

class GenricCodeExtractor implements CodeExtractor {
	var pattern = Pattern.compile('''\$\(\/\*((?:(?!\*\/\))[\s\S])*)\*\/\)''')
	var Matcher matcher;
	override readSource(String source) {
		matcher = pattern.matcher(source)
	}
	
	override getNext() {
		if (matcher.find()) {
			var allCode =  matcher.group(0)
			return new LayoutCode(matcher,matcher.start(0),matcher.end(0),allCode,allCode.substring(4,allCode.length-3))
		}
		return null
	}
}
@Data class LayoutCode {
	Matcher matcher;
	int start
	int end
	String allCode
	String code
}

class XtendParser {
	
}

@Accessors
class Node {
	new(Matcher m,String code) {
		start = m.start
		end = m .end
		text = code.substring(m.start,m.end)
	}
	int start;
	int end;
	String text;
	List<Node> childNodes = newArrayList()
}

@Accessors
class TextNode extends Node {
	def concat(Matcher matcher) {
		this.text = this.text + matcher.group(7)
	}
}

@Accessors
class Tag extends Node {
	String name;
	String attributesString
	int tagEnd
	int end;
	boolean selfClosed = false;
}
class NaiveCompiler {
	var tagPattern = Pattern.compile('''<(\/?)((?:\w|\.)*)(\s*\w+=(?:([\[{"'])(?:(?=(\\?))\5.*)?(?:\4|}|])))?(\s*\/?)>|([\s\S])''')
	
	var Stack<Tag> stack = new Stack<Tag>()
	
	def Tag parse(String code,List<Replacement> replacements) {
		var m = tagPattern.matcher(code)
		var Tag lastTag = null
		while (m.find()) {
			if (m.group(7) != null && m.group(7) != "") {
				if (!stack.empty()) {
					var lastChild = (stack.peek().childNodes).last
					if (lastChild instanceof TextNode) {
						// Just concat with previous node
						lastChild.concat(m);
					} else {
						// Create new text node
						var TextNode textNode = new TextNode(m,code)
						stack.peek().childNodes += textNode
					}
				}
			} else if (m.group(1) == "/") {
//				System.out.println("Found closing tag "+m.group(2))
				if (stack.empty() ) {
//					System.out.println("ERROR: Unmatched closing tag. Not tags are open ")
				} else if ((stack.peek() as Tag).name != m.group(2)) {
//				 	System.out.println("ERROR: Unmatched closing tag.Found: "+ m.group(2)+" Expected: "+stack.peek().name)
				} else {
					lastTag = stack.pop()
				}
			} else {
//				System.out.println("Found tag "+m.group(2))
				var tag = new Tag(m, code)
				tag.start = m.start
				tag.attributesString = m.group(3);
				tag.tagEnd = m.end
				tag.name = m.group(2);
				if (!stack.empty()) {
					stack.peek().childNodes += tag
				}
				if (m.group(6) == "") {
					stack.push(tag)
				} else {
					tag.selfClosed = true;
					lastTag = tag
				}
			}
		}
		
		return lastTag
	}
	
	
	def dispatch String dumpTree(TextNode tree) '''«tree.text»'''
	def dispatch String dumpTree(Tag tree) '''
		«IF tree.selfClosed»- «tree.name»«ELSE»
		- «tree.name»
			«FOR child: tree.childNodes»
			«IF child instanceof TextNode»
«dumpTree(child)»
			«ELSE»
				«dumpTree(child)»
			«ENDIF»
			«ENDFOR»
		«ENDIF»
	'''
	def String compile(Tag tag) '''
		LatteView.createLayout("«tag.name»", LatteView.props(), new ChildrenProc() {
			public List<LatteView> apply(LatteView it) {
				List<LatteView> myChildren = new ArrayList<LatteView>();
				«FOR child:tag.childNodes»
					«IF child instanceof TextNode»«child.text»«ENDIF»
					«IF child instanceof Tag»
						myChildren.add(«child.compile»);
					«ENDIF»
					
				«ENDFOR»
			}
		})
	'''
	
	
	def String compile(String source) {
		val List<Replacement> replacements = newArrayList()
		var extractor = new GenricCodeExtractor();
		extractor.readSource(source)
		val sb = new StringBuffer();
		var LayoutCode next;
		while ((next = extractor.getNext()) != null) {
			var layouCode = parse(next.code,replacements)
			var compiledCode = compile(layouCode)
			next.matcher.appendReplacement(sb,compiledCode)
		}
		System.out.println(sb.toString)
		return ""//source;
	}
	
	def static void main(String[] args) {
		Tester.main(args)
	}
	
	
}

class Replacement {
	int start;
	int end;
	String replacement;
}

class Tester {
	var static testCase ='''
package com.digg2.ui

import android.util.Log
import com.digg2.api.ApiManager
import com.digg2.data.model.Story
import io.lattekit.Layout
import io.lattekit.ui.view.LatteView
import io.realm.Realm
import java.util.List
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by maan on 12/16/15.
 */
 
class HomeFeed extends LatteView {

    List<Story> items = newArrayList();
    var Realm realm;
	
    override onViewMounted() {
    	realm = Realm.getInstance(this.activity)
        downloadFeed();
        displayFeed();    	
    }
    
    def downloadFeed() {
        ApiManager.getApi().getNews("top")
	        .subscribeOn(Schedulers.newThread)
	        .observeOn(AndroidSchedulers.mainThread)
	        .subscribe[ response |
	        	realm.executeTransaction[ realm.copyToRealmOrUpdate(response.data.feed) ]
	        ]    	
    }
    
    def displayFeed() {
       realm.where(Story).findAllAsync().asObservable.subscribe[ results |
       		items = results;
       		Log.d("Digg","Got "+items.length +" Items ")
       		onStateChanged();
       ];
    }
	
	def void handleStoryClick(Story story) {
		new ArticleView(story).show(this);
	}
	
    @Layout(imports=#["com.digg2.ui"])
    override render() {
		return $(/*		<LinearLayout orientation="vertical" cls="container">
					<ListView data={items}  cls="container" dividerHeight={0} onItemClick=[ Story s | handleStoryClick(s) ]>
		                <MarqueeStoryCell when=[ Story item, Integer index | index == 0] />
		                <CompactStoryCell defaultView="true"  />
					</ListView>
				</LinearLayout>*/)
	}
	
}	
	'''
	
	def static void main(String[] args) {
		var compiler = new NaiveCompiler();
		System.out.println(compiler.compile(testCase));
	}	
}