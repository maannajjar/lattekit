## What is LatteKit
It's a gradle plugin + library that allows you to create a virtual Android views *component and manage Android Views in your Kotlin code  without having to create XML files

### Example

![Demo](http://i.imgur.com/g5vPDZF.gif)

```kotlin
package io.lattekit.helloworld

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        render("<io.lattekit.helloworld.MyApp />")
    }
}

open class MyApp : LatteView() {
    @Bind("@id/myText") var myText : EditText? = null;

    init {
        css("""
            .question { font-size: 20sp; font-weight: bold;  }
            .input { font-size: 14sp; margin-top:8dp;  width: match_parent; }
            .answer { font-size: 20sp; font-weight: bold; margin-top: 10dp; color: #00AADE; }
        """)
    }

    override fun layout() = xml("""
        <LinearLayout padding="30dp" orientation="vertical">
            <TextView class="question" text="What's your name?" />
            <EditText class="input" id="@+id/myText" hint="Type your name here"
                onTextChanged=${{ notifyStateChanged() }}/>
            <TextView class="answer" text=${"Hello ${myText?.text}"}
                visibility=${if (myText?.text?.toString() == "") View.GONE else View.VISIBLE} />
        </LinearLayout>
    """)

}
```


