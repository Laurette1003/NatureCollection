@file:Suppress("unused", "unused", "unused")

package de.laurette.naturecollection

//cette classe permttra de liste et de donner toutes les caracteristiques de la plantes
class PlantModel (
    val name: String = "Tulipe",
    val description: String = "Petite description",
    val imageUrl : String ? = "", //http://graven.yt/plante.jpg
    var liked: Boolean = false
        )