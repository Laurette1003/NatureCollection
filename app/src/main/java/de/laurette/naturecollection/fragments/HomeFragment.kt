package de.laurette.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import de.laurette.naturecollection.MainActivity
import de.laurette.naturecollection.PlantRepository.Singleton.plantList
import de.laurette.naturecollection.R
import de.laurette.naturecollection.adapter.PlantAdapter
import de.laurette.naturecollection.adapter.PlantItemDecoration

class HomeFragment(
        private val context : MainActivity
): Fragment() {
    override fun onCreateView(inflater: LayoutInflater,  container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)


        // recuperer le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context , plantList , R.layout.item_horizontal_plant)

        // recuperer le second recyclerview
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context , plantList , R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }

}
