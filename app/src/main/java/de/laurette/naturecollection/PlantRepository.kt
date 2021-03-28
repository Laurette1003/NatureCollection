package de.laurette.naturecollection

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import de.laurette.naturecollection.PlantRepository.Singleton.databaseRef
import de.laurette.naturecollection.PlantRepository.Singleton.plantList

class PlantRepository {


    object  Singleton {
        // se connecter á la reference "plants"
        val databaseRef = FirebaseDatabase.getInstance().getReference("plants")

        // creer une liste qui va contenir nos plantes
        val plantList = arrayListOf<PlantModel>()
    }

    fun updateData() {
        //absorber les données depuis la databaseRef -> liste de plantes

        databaseRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // retirer  les anciennes plantes
                    plantList.clear()
                     //"recolter la liste"
                    for (ds in snapshot.children) {
                        // construire un objet plante
                        val plant = ds.getValue(PlantModel::class.java)

                        // verifier que la plante á notre liste
                        if (plant != null) {
                            // ajouter une plante á notre liste
                            plantList.add(plant)
                        }
                    }
                    // actionner le callback
                    //callback()
                }

                override fun onCancelled(error : DatabaseError?) {
                    //("dans le cas ou lelement na pas ete trouvé")
                }

            })
        }
    }

