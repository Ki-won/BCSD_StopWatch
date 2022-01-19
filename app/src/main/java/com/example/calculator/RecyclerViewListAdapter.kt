package com.example.calculator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewListAdapter : RecyclerView.Adapter<RecyclerViewListViewHolder>() {

    private val items = mutableListOf<RecyclerViewListViewHolder>()


    private var itemClickListener: RecyclerViewItemClickListener? = null
    private val costomDig : GetTextDlg? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        return RecyclerViewListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewListViewHolder, position: Int) {
        holder.listText.text = items.toString()

        holder.listContainer.setOnClickListener {
            itemClickListener?.onRecyclerViewItemClicked(
                holder.listContainer,
                holder.adapterPosition
            )
        }
        holder.listContainer.setOnLongClickListener {
            itemClickListener?.onRecyclerViewItemLongClicked(
                holder.listContainer,
                holder.adapterPosition
            )
            true
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setRecyclerViewClickListener(itemClickListener: RecyclerViewItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun deleteListItem(position: Int) {
        items.removeAt(position)
        notifyDataSetChanged()
    }

    fun addListItem(position: Int, string: String){
        notifyItemChanged(position, string)
    }

}





