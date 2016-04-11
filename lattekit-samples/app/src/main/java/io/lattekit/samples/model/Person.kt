package io.lattekit.samples.model

/**
 * Created by maan on 4/11/16.
 */

data class Person(
    var firstName : String,
    var lastName : String,
    var job : String,
    var imageUrl : String,
    var coverImageUrl: String = "http://www.quiiky.com/public/fotogallerypacchetti/962/manhattan%20night.jpg",
    var friends : List<Person> = emptyList()
)

