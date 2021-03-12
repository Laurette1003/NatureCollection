package de.laurette.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import de.laurette.naturecollection.MainActivity
import de.laurette.naturecollection.PlantModel
import de.laurette.naturecollection.R
import de.laurette.naturecollection.adapter.PlantAdapter
import de.laurette.naturecollection.adapter.PlantItemDecoration

class HomeFragment(
        private val context : MainActivity
): Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?)
            : View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        val plantList = arrayListOf<PlantModel>()

        plantList.add(PlantModel(
                "pissenlit",
                "jaune soleil",
                "https://cdn.pixabay.com/photo/2014/05/01/17/51/dandelion-335662_960_720.jpg",
                liked = false

        ))

        plantList.add(PlantModel(
                "Rose",
                "Ca pique un peu",
                "https://cdn.pixabay.com/photo/2018/05/16/22/27/rose-3407234__340.jpg",
                false
        ))

        plantList.add(PlantModel(
                "cactus",
                "ca pique beaucoup",
                "https://cdn.pixabay.com/photo/2014/07/05/02/51/cactus-384500__340.jpg",
                false
        ))

        plantList.add(PlantModel(
                "Tulipe",
                "c'est beau",
                "https://cdn.pixabay.com/photo/2017/03/13/21/19/tulip-2141216__340.jpg",
                true
        ))

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context , plantList , R.layout.item_horizontal_plant)

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context , plantList , R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }

}
