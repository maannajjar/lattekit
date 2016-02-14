package io.lattekit.css

import java.util.List
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class CssDefinition  {
    new(Matcher m,String source) {
        start = m.start
        end = m .end
    }
    int start;
    int end;
    String selector;
    List<CssProperty> childNodes = newArrayList()
}

@Accessors
class CssProperty  {
    new(Matcher m,String source) {
        start = m.start
        end = m .end
    }

    int start;
    int end;
    String text;
    String name;
    String value;
}

class CssParser {
    var TOKENS = Pattern.compile(
            // Group 1:captures selectors
            '''((?:(?:\.|#)?[^,> \n]+)(?:\s*[,> ]\s*(?:\.|#)?[^,> \n]+)*)\s+(?=\{)'''
            // Group 2: captures {
            +'''|(\{)'''
            // Group 3: captures property name
            // Group 4: captures property value
            +'''|\s*([^\n:]+):\s*([^\n;]+)(?:;|\s*\n\s*(?=\}))'''
            // Group 5: captures }
            +'''|(\})''')


    def acceptDefinition(Matcher m, String source) {
        if (m.group(1) == null || m.group(1).trim() == "") {
            throw new Exception("Expected CSS definition block. Found"+m.group)
        }

        var selector = m.group(1);
        var definition = new CssDefinition(m, source)
        definition.selector = selector;
        m.find()

        if (m.group(2) == null || m.group(2).trim() == "" ){
            throw new Exception("Expected {")
        }
        m.find()

        while (m.group(5) == null || m.group(5).trim() == "") {
            definition.childNodes += acceptProperty(m,source);
            m.find()
        }
        m.find()
        return definition;
    }

    def CssProperty acceptProperty(Matcher m, String source) {
        var property = new CssProperty(m, source);
        property.name = m.group(3)
        property.value = m.group(4)
        return property
    }

    def List<CssDefinition> parse(String source) {
        var matcher = TOKENS.matcher(source);
        var List<CssDefinition> results = newArrayList();
        matcher.find()
        while (!matcher.hitEnd) {
            results += acceptDefinition(matcher,source);
        }
        return results;
    }

    def compile(List<CssDefinition> tree) {

    }

    def static void main(String... args) {
        var test = new CssParser();
        var rs = test.parse('''
.module  {
    height: wrap_content;
    width: match_parent;
}
.container {
    width: match_parent;
    height: match_parent;
    transition: height 100ms 50ms, width 20ms 100ms;
}

.test {
    width: 200px;
    height: 200px;
    background-color: #eeeeee;
}
.story {
    height: wrap_content;
    width: match_parent;
    background-color:#00000000;
    ripple-color: #aaaaaa;
}
.story_title {
    font-family: "GraphikApp-Bold";
    font-style: bold;
    width: match_parent;
    height: wrap_content;
    background-color:#00000000;
}

.kicker {
    font-family: "GraphikApp-Bold";
    font-size: 12sp;
    font-style: bold;
    width: match_parent;
    height: wrap_content;
    text-color: #777777;
    background-color:#00000000;
}

.diggs {
    text-color:#9a9a9a;
    background-color:#00000000;
    font-family: "GraphikApp-Regular";
    font-style: normal;
    font-size: 11sp;
}



.story_full .img {
    width: match_parent;
    height: 230dp;
}
.story_full .text_wrapper {
    background-color:#00000000;
    padding-left: 15dp;
    padding-right: 15dp;
    height: wrap_content;
    width: match_parent;
    padding-bottom: 10dp;
    ripple-color: #000000;

}
.story_full .kicker {
    text-color:#eeeeee;
    margin-top: 5dp;
}
.story_full .story_title {
    text-color: #ffffff;
    font-size: 20sp;

}



.story_compact {
    padding-top: 15dp;
}
.story_compact .img {
    height: 80dp;
    width: 80dp;
    margin-left: 10dp;
    margin-right: 15dp;
}
.story_compact .story_border {
    background-color: #eeeeee;
    height:1dp;
    width: match_parent;
    margin-left: 15dp;
    margin-right: 15dp;

}
.story_compact .story_title {
    font-size: 18sp;

    margin-left: 15dp;
    margin-top: 3dp;
}
.story_compact .kicker {
    margin-left: 15dp;
}
.story_compact .diggs {
    margin-left: 15dp;
    margin-top: 3dp;
    padding-bottom: 15dp;
}


.collection_header {
    border-top: 1dp solid #000000;
    border-bottom: 1dp solid #000000;
    height: wrap_content;
    width: match_parent;
    padding-top: 5dp;
    padding-bottom: 5dp;
    padding-left: 15dp;
    padding-right: 15dp;

}
.header_text {
    font-family: "Roboto-Black";
    font-size: 14sp;
    font-style: bold;
}
.header_link_text {
    text-color: #0073e8;
    font-family: "Roboto-Black";
    font-size: 14sp;
    font-style: bold;

}
        ''')
        println(new CssCompiler().compile("com.digg2.style","main.css",rs));
    }

}