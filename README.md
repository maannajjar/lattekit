## What is LatteKit
It's a framework for building Android UI in Kotlin code by using the concept of virtual views and reactive data flow, the goal is to reduce boilerplate while retaining the same Android layout constructs.

### Quick Example

![Demo](http://i.imgur.com/g5vPDZF.gif)

```kotlin
package io.lattekit.helloworld
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import io.lattekit.annotation.Bind
import io.lattekit.plugin.css.declaration.css
import io.lattekit.render
import io.lattekit.view.LatteView

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
            <TextView text="What's your name?" class="question"/>
            <EditText id="@+id/myText" hint="Type your name here"
                onTextChanged=${{ notifyStateChanged() }} class="input"/>
            <TextView text=${"Hello ${myText?.text}"}
                visibility=${if (myText?.text?.toString() == "") View.GONE else View.VISIBLE} class="answer"/>
        </LinearLayout>
    """)

}
```

### Other Samples
![Sample](https://imgur.com/JsNje1L.gif)

For more samples, view the samples at [lattekit-samples](https://github.com/maannajjar/lattekit/tree/master/lattekit-samples) folder. But before view the sample, please read the core concept below to understand the sample better.

## How It Works

### 1- Virtual Views (LatteViews)
The core concept of LatteKit is to define virtual views. A virtual view is  subclass of LatteView that defines its own layout. The layout may contain native Android views and other virtual views. It can also receive properties passed to it from the rendering view. For example

```kotlin
open class MyApp : LatteView() {
    var currentUser : User? = null;
    override fun layout() = xml("""
        <LinearLayout padding="30dp" orientation="vertical">
            <views.UserDetailsView user=${currentUser} />
        </LinearLayout>
    """)
}

open class UserDetailsView : LatteView() {
    @Prop var user : User? = null;
    // Or @Prop("customPropertyName")

    override fun layout() = xml("""
        <LinearLayout orientation="horizontal" paddingTop="10dp" paddingBottom="10dp">
            <ImageView src=${user?.avatarUrl} layout_width="50dp" layout_height="50dp" />
            <TextView text=${user?.username} layout_gravity="center_vertical" layout_height="wrap_content"/>
        </LinearLayout>
    """)
}
```

Here, MyApp & UserDetailsView are virtual views. MyApp contains UserDetailsView which expects property *user*. When the native view tree is built, UserDetailsView will be replaced by the actual layout. Properties are automatically assigned to variables with *@Prop* annotation. In the above example, MyApp passed **currentUser** as **user** propertiy in UserDetailsView. 

### 2- Data Binding & Maintaining View States

You can use any variable you want in your layout code. Just use string interpolation to pass run-time properties. You can even use lambdas. This is called data binding, because the values of those properties are bound to the passed variable. Any variables used in the layout are considered *state variables*. If the some variable value has changed, you need to notify the view about that so it re-sync the layout with the current state. Virtual views react to state changes will propagate throughout the virtual view tree. In the previous example, if MyApp needs to change **currentUser** for any reason (for example due to API call). All it needs to do is call **notifyStateChanged()** after changing currentUser. This will update user property in UserDetailsView which will then update its layout. You can have as many nested virtual views and change as many variables. Calling **notifyStateChanged()** will always ensure that the layout tree reflects the correct state of the notified view.


### Binding Views
You can bind views in your layout code by using **@Bind** annotation. By default, the annotation will look for a view with the same id as the variable name. But you can specify the id in the annotation too:

```kotlin
@Bind var saveButton : Button? = null;
// Or
// @Bind("@id/saveButton")  saveButton : Button? = null;

override fun layout() = xml("""
	<Button id="@+id/saveButton" />
""")

```
You can also refernece those views inside your layout, as demonstrated in the first example.

### ListView/RecyclerView/ViewPager
Those views have special treatment inside the layout definition. LatteKit will create an adapter for you, all you have to do is provide the views it should render. You can basically think of it as a for loop that iterates through data set (it's not for loop though, it just implements an Adapter behind the scene). For example:

```kotlin

open class MyListView : LatteView() {
 	 var myData : List<Any> = listOf(...)
 	 
    override fun layout() = xml("""
        <ListView data=${myData} layout_width="match_parent" layout_height="match_parent">
			<views.AdItemView when=${{ it is AdData }} />        
			<views.FoodItemView when=${{ it is FoodData }} defaultView="true" />
        </ListView>
    """)
}
open class FoodItemView : LatteView() {
	@Prop("model") var foodDeatils: FoodData? = null;
   override fun layout() = xml("""<TextView text=${foodDeatils?.title} />""")
}
open class AdItemView : LatteView() {
	@Prop("model") var foodDeatils: FoodData? = null;
   override fun layout() = xml(""" .... """)
}
```
Here, the ListView will render myData dataset. The dataset contains two different kinds of objects: AdData and FoodData. Each needs to have different view (FoodItemView or AdItemView). The adapter will determine which template to use by calling the lambda specified via **when** property.  If none of the templates matche, it will fallback to the first template that has defaultView=true. It will then render the template and pass the property **model** which will contain the corrospending item in the myData.

The template will use **model** property passed by the adapter.

### Lifecycle

If you need to initialize your component, or need to initialize Android views outside the layout. You can override onViewCreated. Also, if you need to need to perform any action before the view is removed from the layout tree, you can override onViewWillDetach().

```kotlin
open class MyListView : LatteView() {
	var myData : List<Any> = emptyList();
	..
	..
	override fun onViewCreated() {
        ApiManager.getFeed()
			  .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {  response ->
                myData = response
                notifyStateChanged()
            }
	}
	override fun onViewWillDetach() {
		backgroundMusic?.stop();
	}
	
    override fun layout() = xml("""
        <ListView data=${myData} layout_width="match_parent" layout_height="match_parent" dividerHeight="0">
			<views.AdItemView when=${{ it is AdData }} />        
			<views.FoodItemView when=${{ it is FoodData }} defaultView="true" />
        </ListView>
    """)
}
```


### CSS Styling
There are two ways to use CSS styling. 1) Local CSS, which are CSS delcarations that are defined inside LatteView. Those declarations don't cascade down to other virtual views. or 2) Global css, which are defined in a separate css file. The css file should be just inside any java package. Here how to use them:

```kotlin
open class MyView : LatteView() {
    @Bind("@id/myText") var myText : EditText? = null;

    init {
    	 // Global CSS
    	css("my.package.com/myfile.css")
	    // Local CSS 
        css("""
            .myclass { padding: 20dp; }
		  """)
    }

    override fun layout() = xml("""
        <LinearLayout class="myclass">
        </LinearLayout>
    """)

}
```



CSS styling is not 100% complete, most used properties are already implemented. I'll keep adding more support in later releases. I'll expand this section later to explain what special cases of CSS properties. For the meaning time, you can view more css examples at [lattekit-samples](https://github.com/maannajjar/lattekit/tree/master/lattekit-samples)


## Getting Started

1- Add the gradle plugin class path to buildscript 

```
buildscript {
    dependencies {
        classpath 'io.lattekit.tools:gradle-plugin:0.9.3'
    }
}
```

2- Apply the plugin 

```kotlin
// The plugins must be in that order
apply plugin: 'com.android.application'
apply plugin: 'lattekit' 
apply plugin: 'kotlin-android'

```
3- Add runtime lib to dependency to build.gradle
```
    compile 'io.lattekit:lattekit-core:0.9.3'
```

4- Define your virtual views as explained above

**it's important that LatteView subclasses are declared open class**. Gradle plugin will throw an error if it sees layout code inside non-open (final) class.

5- To render LatteView within activity:

```kotlin
import io.lattekit.render 

class MyActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Note: props here are passed as map and not in xml
        render("<com.package.MyView />",props=mutableMapOf("title" to "MyApp"))
    }
}
```

6- If you just want the native View object, you can call buildView().

```kotlin
var virtualView = Latte.render("<com.package.MyView />",props=mutableMapOf("title" to "MyApp"));
var androidView = virtualView.buildView(myActivity,LayoutParams(..))
// You can later update props using:
virtualView.props.put("prop",value);
virtualView.notifyStateChanged();
```

7- To show LatteView as an activity form another LatteView

```kotlin
Latte.showActivity(this,"<com.package.UserProfile />", mutableMapOf("user" to user))
```

8- To show LatteView as a Dialog form another LatteView

```kotlin
Latte.showDialog(this,"<com.package.UserProfile />", mutableMapOf("user" to user))
```

License
--------

    The MIT License (MIT)

    Copyright (c) 2016 Maan Najjar
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.




