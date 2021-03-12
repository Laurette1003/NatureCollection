package de.laurette.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.laurette.naturecollection.GlideApp
import de.laurette.naturecollection.MainActivity
import de.laurette.naturecollection.PlantModel
import de.laurette.naturecollection.R


//cette classe sera donnee a notre recyclerview pour pouvoir adapter pour chaque plante son equivalent en image
class PlantAdapter(
        private val context: MainActivity,
        private val plantList: List<PlantModel>,
        private val layoutId: Int,

        ) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {
            // elle permettra de porter la vue , une sorte de boite pour ranger touts les composants a controller

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

       val plantImage : ImageView = view.findViewById(R.id.image_item)
        val plantName : TextView? = view.findViewById(R.id.name_item)
        val plantDescription : TextView? = view.findViewById(R.id.description_item)
        val starIcon: ImageView? = view.findViewById(R.id.star_icon)

    }

        // nous permet dinjecter un composant
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =  LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

            return ViewHolder(view)
        }

    // permettra de mettre a jour chaque modele avec la plante en question

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val currentPlant =  plantList[position]  //setImageResource(plantList[position])

            // recuperer les informations de la plante
            // utiliser glide pour recuperer l'image á partir de son lien et venir laajouter a notre composant

            GlideApp.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)


            holder.plantName?.text = currentPlant.name

            holder.plantDescription?.text = currentPlant.description

            if(currentPlant.liked){
                holder.starIcon?.setImageResource(R.drawable.ic_star_full)
            }
            else{
                holder.starIcon?.setImageResource(R.drawable.ic_unstar)
            }



        }


        // permettra de renvoyer combien d'items on affichera dynamiquement
        override fun getItemCount(): Int = plantList.size

}

