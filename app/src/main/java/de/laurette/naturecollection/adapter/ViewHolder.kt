package de.laurette.naturecollection.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import de.laurette.naturecollection.R

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    val plantImage =  view.rootView.findViewById(R.id.image_item) as ImageView

}
