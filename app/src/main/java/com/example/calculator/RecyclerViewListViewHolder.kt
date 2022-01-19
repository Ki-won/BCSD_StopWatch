package com.example.calculator

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var listText: TextView = itemView.findViewById(R.id.list_text_view)
    val listImage: ImageView = itemView.findViewById(R.id.list_image_view)

    var listContainer: ConstraintLayout = itemView.findViewById(R.id.list_container)
}


