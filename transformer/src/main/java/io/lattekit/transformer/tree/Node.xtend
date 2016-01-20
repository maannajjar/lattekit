package io.lattekit.transformer.tree

import io.lattekit.transformer.parser.Prop
import java.util.List
import java.util.regex.Matcher
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
public class Node {
	new(Matcher m){ 
	}
	new(Matcher m,String source) {
		start = m.start
		end = m .end
		text = source.substring(m.start,m.end)
	}
	int start;
	int end;
	String text;
	List<Node> childNodes = newArrayList()
}

@Accessors
public class TextNode extends Node {
	new(Matcher m,String source) {
		super(m,source)
	}	
	def concat(Matcher matcher) {
		this.text = this.text + matcher.group(7)
	}
}

@Accessors
public class Tag extends Node {
	
	Tag parentTag;
	String name;
	String attributesString
	int tagEnd
	int end;
	boolean selfClosed = false;
	List<Prop> props = #[];
	
	new(Matcher m,String source) {
		super(m,source)
	}	
}