package io.lattekit.samples

/**
 * Created by maan on 4/11/16.
 */

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.facebook.stetho.Stetho
import io.lattekit.render
import io.lattekit.samples.model.Person

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}

var peopleList = listOf(
    Person("Maan", "Najjar", "Android Developer", "https://avatars3.githubusercontent.com/u/2287702?v=3&s=460"),
    Person("John","Smith","Software Engineer","http://pickaface.net/avatar/myspacedixson5247bbe83039a.png", "http://cdn.banquenationale.ca/cdnbnc/2013/06/ruisseau.jpg"),
    Person("Sara","Smith","Computer Scientist", "http://a1.phobos.apple.com/us/r1000/020/Purple/11/01/cc/mzi.uwflagpf.png","http://www.natureasia.com/common/img/splash/thailand.jpg"),
    Person("John","Appleseed","iOS Developer", "http://pickaface.net/avatar/Opi51c7dccf270e0.png","http://science-all.com/images/lakes/lakes-03.jpg"),
    Person("Nick","Milano","CEO", "https://www.shreehotelsparkandfly.com/admin/assets/img/profiles/avatar.jpg"),
    Person("Alex","Salavatore","Designer", "http://bootdey.com/img/Content/avatar/avatar5.png"),
    Person("Sean","Shaun","Writer", "https://gooyaabitemplates.com/wp-content/uploads/userpro/1182/5696a28b21085.png"),
    Person("Jane","Doe","Unknown", "http://bootdey.com/img/Content/avatar/avatar1.png")
)


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make everyone friends with everyone else
        peopleList.forEach { person ->
            person.friends = peopleList.filter { it != person }
        }

        render("<io.lattekit.samples.view.PeopleDirectoryView />", mutableMapOf("directory" to peopleList ))
    }
}






