# LatteKit Examples

This project will contain samples for using LatteKit. Currently, there's one small example called "People" app. Which shows a list of people. By clicking on a person, it will display his/her profile & friends.

## People App
![Screenshots](https://imgur.com/ZX0l0Aj.gif)

### Code Structure
All the code related to the app is in [src/main/java/io/lattekit/samples](https://github.com/maannajjar/lattekit/tree/master/lattekit-samples/app/src/main/java/io/lattekit/samples). The folder contains the following:

- **style** this folder contains css files used to style the views
- **model** contains the models used by the app. There's only one model used currently which is Person
- **view** contains the views. There are two files:
	- **PeopleDirectoryView.kt** this is the main view (the orange screen). It contains definition for *PeopleDirectoryView* and other subviews
	- **ProfileView.kt** This contains the definition for the. ProfileView (blue screen), also contains other related views such as the top card

- **MainActivity.kt** it contains the sample dataset used for the app, normally you would retrieve those from API or local database. It also initializes the main view (PeopleDirectoryView) and passed the sample dataset as a property called **directory**

### Notes:
- Notice how data flow from MainActivity throughout the app. The dataset is defined there and then it propagates as properties to all components. If for ever reason, the dataset changes. All you need to call is **notifyDataSetChanged()**
- Just like Android's Data Binding work. Properties assigned to native view in XML are actually translated to method calls. The gradle plugin will search for any corrosponding method. However, not all xml properties have setter method, or some methods expect different type of values. This example shows how you can deal with the situation. PeopleDirectoryView.kt uses CoordinatorLayout which has some attributes that are not recognized by the plugin. In this case, we set those attributes in **onViewCreated**. It's in Roadmap to define something similar to **@BindingMethod**, also the plugin will get better in translating tricky attributes.