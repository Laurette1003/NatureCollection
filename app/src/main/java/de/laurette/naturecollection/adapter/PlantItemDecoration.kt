package de.laurette.naturecollection.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

// cette classe nous permet de definir la largeur et la hauteur individuel de chaque plante.
class PlantItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets( outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.bottom = 20
    }
}