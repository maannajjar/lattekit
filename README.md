## What is LatteKit
It's a gradle plugin + library that allows you to create virtual Android views components and manage Android Views in your Kotlin code  without having to create XML files

### Quick Example

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
            <TextView text="What's your name?" />
            <EditText id="@+id/myText" hint="Type your name here"
                onTextChanged=${{ notifyStateChanged() }}/>
            <TextView text=${"Hello ${myText?.text}"}
                visibility=${if (myText?.text?.toString() == "") View.GONE else View.VISIBLE} />
        </LinearLayout>
    """)

}
```


## How It Works

### 1- Virtual LatteViews
The core concept of LatteKit is to define virtual views. A virtual view is  subclass of LatteView that encapsulate its own layout. It can also take properties passed to it from other virtual views in their layout. For example

```kotlin
open class MyApp : LatteView() {
    var currentUser : User? = null;
    override fun layout() = xml("""
        <LinearLayout padding="30dp" orientation="vertical">
            <views.UserDetailsView username=${currentUser} />
        </LinearLayout>
    """)
}

open class UserDetailsView : LatteView() {
    @Prop var user : User? = null;
    // Or @Prop("propertyName")

    override fun layout() = xml("""
        <LinearLayout orientation="horizontal" paddingTop="10dp" paddingBottom="10dp">
            <ImageView src=${user?.avatarUrl} layout_width="50dp" layout_height="50dp" />
            <TextView text=${user?.username} layout_gravity="center_vertical" layout_height="wrap_content"/>
        </LinearLayout>
    """)
}
```

Here UserDetailsView has its own layout and expects property *user*. Properties are automatically assigned to variables with *@Prop* annotation. In the above example, MyApp assigned user property to **currentUser** in UserDetailsView. 

### 2- Maintaining View States

Virtual views react to state changes which propagate down the virtual view tree. In the previous example, if MyApp needs to change **currentUser** for any reason (for example due to API call). All it needs to do is call **notifyStateChanged()** after changing currentUser. This will update user property in UserDetailsView which will then update its layout. You can have as many nested virtual views and change as many variables. Calling **notifyStateChanged()** will always ensure that the layout tree reflects the correct state from the perspecitve of the notified view.


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
Those views have special treatment inside the layout definition. LatteKit will create an adapter that will give you flexibility to define the views. You can basically think of them as a for loop that iterate through data set (it's not though, it just implements an Adapter behind the scene). For example:

```kotlin

open class MyListView : LatteView() {
 	 var myData : List<Any> = listOf(...)
 	 
    override fun layout() = xml("""
        <android.support.v7.widget.RecyclerView data=${myData} layout_width="match_parent" layout_height="match_parent">
			<views.AdItemView when=${{ it is AdData }} />        
			<views.FoodItemView when=${{ it is FoodData }} defaultView="true" />
        </android.support.v7.widget.RecyclerView>
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
Here, the recycler view will render myData dataset. The dataset contains two different kinds of objects. Either AdData or FoodData, each has their own template view (FoodItem or AdItem). The adapter will determine which template to use by calling the lambda specified via **when** property.  If none of the template matches, it will fallback to the first template that has defaultView=true. It will then render the template and pass the property **model** which will contain the corrospending item in the myData.

Notice how templates use *model* property to render the layout, this is passed by the Adapter

### Lifecycle

If you need to initialize your component, or need to initialize Android views outside the layout. You can override onViewCreated.

```kotlin
open class MyListView : LatteView() {
	var myData : List<Any> = emptyList();
	override fun onViewCreated() {
        ApiManager.getFeed()
			  .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {  response ->
                myData = response
                notifyStateChanged()
            }
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
TBD

## Getting Started

1- Add the gradle plugin class path to buildscript 

```
buildscript {
    dependencies {
        classpath 'io.lattekit.tools:gradle-plugin:0.9.1'
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
    compile 'io.lattekit:lattekit-core:0.9.1'
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
virtualView(myActivity,LayoutParams)
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