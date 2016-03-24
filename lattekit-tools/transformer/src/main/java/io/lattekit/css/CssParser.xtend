package io.lattekit.css

import java.util.List
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class CssDefinition  {
    new(String selector,String body) {
        this.selector = selector;
        this.body = body;
    }
    String selector;
    String body;
    List<CssProperty> childNodes = newArrayList()
}

@Accessors
class CssProperty  {
    String name;
    String value;
}

class CssParser {
    var BLOCKS_REGEX = Pattern.compile('''([^\{]+)\s*\{([^\}]+)\}''')
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


    def acceptDefinition(String selector, String body) {
        val definition = new CssDefinition(selector,body)
        definition.selector = selector;

        body.split("\r?\n").forEach [  line |
            var trimmedLine = line.trim();
            if (trimmedLine.endsWith(";")) {
                trimmedLine = trimmedLine.substring(0,trimmedLine.length-1)
            }
            var property = new CssProperty();
            var split = trimmedLine.split(":")
            if (split.length > 1) {
                property.name = split.get(0).trim();
                property.value = split.get(1).trim();
                definition.childNodes += property;
            }
        ]

        return definition;
    }


    def List<CssDefinition> parse(String source) {
        var blocksMatcher = BLOCKS_REGEX.matcher(source);
        var List<CssDefinition> results = newArrayList();
        while(blocksMatcher.find()) {
            results += acceptDefinition(blocksMatcher.group(1).trim(),blocksMatcher.group(2));
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
}
.toolbar {
    elevation: 2dp;
    width: match_parent;
    background-color: #ffffff;
}
.home_feed {
    background-color: #EBEBEB;
}

.message_module {
    font-size: 22sp;
    text-align:center;
    padding: 0 10dp;
    font-family: GraphikApp-Bold;
    background-color: #EBEBEB;
    height: 120dp;
    gravity: center;
    line-height: 26sp;
}
.section_header_wrapper {
    background-color: #EBEBEB;
    padding-top: 26dp;
}
.section_header_wrapper.section1 {
    padding-top:0dp;
}
.section_header {
    background-color: #FFFFFF;
    font-size: 13sp;
    font-weight: bold;
    font-family: GraphikApp-Semibold;
    padding: 15dp 10dp;
    border-bottom: 1dp solid #E6E6E6;
    color: #005be2;
    height: 44dp;
    gravity: center_vertical;
    padding-left: 16dp;
    padding-right: 16dp;

}

.left_nav {
    padding: 20dp;
    width: 240dp;
    height: match_parent;
    elevation: 10dp;
    background-color: #ffffff;
    color:#000000;
}

.img {
    margin-bottom:12dp;
    width: match_parent;
    margin-top: 16dp;
}
.img.image-no-image {
    display: none;
}
.img.image-large {
    margin-top: 0dp;
}
.img.image-video {
    margin-top: 0dp;
}
.img.image-medium {
    margin-top: 16dp;
    margin-left: 16dp;
    margin-right: 16dp;
}

.img.small {
    height: 80dp;
    width: 80dp;
    margin-top: 0dp;
    margin-right: 16dp;
    margin-bottom:0dp;
}


.story {
    height: wrap_content;
    width: match_parent;
    background-color: #ffffff;
    ripple-color: #aaaaaa;
}
.story:active {
    background-color: #aaaaaa;
}

.kicker {
    font-family: "GraphikApp-Bold";
    font-size: 10sp;
    font-style: bold;
    width: match_parent;
    height: wrap_content;
    color: #808080;
    margin-left: 16dp;
    margin-right: 16dp;
    margin-bottom: 4dp;
}
.kicker.image-no-image {
    margin-top: 16dp
}
.kicker.story-A,.kicker.story-C {
    display: none;
}

.title_container {
    margin-bottom: 6dp;
}
.title_container.image-no-image.story-A,.title_container.image-no-image.story-C {
    margin-top: 16dp;
}

.story_title {
    font-family: GraphikApp-Bold;
    width: match_parent;
    height: wrap_content;
    font-size: 19sp;
    margin-left: 16dp;
    margin-right: 16dp;
    color: #131313;
    line-height:24sp;
}
.story_title.image-no-image {
    font-size: 19sp;
    line-height:20sp;
}
.story_domain {
    font-family: GraphikApp-Regular;
    width: wrap_content;
    height: wrap_content;
    margin-left: 16dp;
    margin-right: 16dp;
    margin-bottom: 7dp;
    color: #808080;
    font-size:12sp;

}
.story_desc {
    font-family: GraphikApp-Regular;
    width: match_parent;
    height: wrap_content;
    font-size: 14sp;
    padding: 0dp 16dp;
    margin-bottom: 11dp;
    color: #444444;
    line-height:18sp;
}
.story_desc.story-A,.story_desc.story-B {
    display:none
}

.diggs {
    color:#9a9a9a;
    background-color:#00000000;
    font-family: "GraphikApp-Regular";
    font-style: normal;
    font-size: 11sp;
    margin-left: 15dp;
    margin-top: 3dp;
    padding-bottom: 15dp;

}

.story_border {
    background-color: #eeeeee;
    height:1dp;
    width: match_parent;
    margin-left: 15dp;
    margin-right: 15dp;
}
.action-img {
    width: wrap_content;
}
.heart {
    margin-left: 16dp;
    margin-right: 10dp;
    margin-bottom: 16dp;

}

.edition_footer {
    background-color: #005be2;
}
.footer_message {
    margin-top: 60dp;
    margin-bottom:60dp;
    width:wrap_content;
    height:wrap_content;
    color:#ffffff;
    line-height: 26sp;
    font-size: 22sp;
    text-align:center;
    padding: 0 10dp;
    font-family: "GraphikApp-Bold";

}
.footer_border {
    background-color:#ffffff;
    width: 72dp;
    height: 1dp;
    margin-bottom: 18dp;
}
.footer_question {
    font-size: 13sp;
    font-family: "GraphikApp-Regular";
    margin-bottom: 8dp;
    color: #ffffff;
    gravity: center;
    text-align:center;
    line-height: 15sp;
}
.footer_answers_wrapper {
    width: wrap_content;
    height: wrap_content;
    margin-bottom: 13dp;
}
.footer_answer_sad, .footer_answer_average {
    margin-right: 12dp;
}        ''')
        println(new CssCompiler().compile("com.digg2.style","main.css",rs));
    }

}