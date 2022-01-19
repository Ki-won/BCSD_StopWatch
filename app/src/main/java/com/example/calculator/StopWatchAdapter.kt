package com.example.calculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StopWatchAdapter : RecyclerView.Adapter<StopWatchViewHolder>() {

    private var watchItemClickListener: RecyclerViewItemClickListener? = null
    private val minitems = mutableListOf<StopWatchViewHolder>()
    private val secitems = mutableListOf<StopWatchViewHolder>()
    private val millitems = mutableListOf<StopWatchViewHolder>()
    private val times = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StopWatchViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.watch_item_main, parent, false)
        return StopWatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: StopWatchViewHolder, position: Int) {
        holder.min.text = minitems.toString()
        holder.sec.text = secitems.toString()
        holder.mile.text = millitems.toString()


        holder.watchContainer.setOnClickListener {
            watchItemClickListener?.onRecyclerViewItemClicked(
                holder.watchContainer,
                holder.adapterPosition
            )
           true
        }
    }

    fun setStopWatchViewClickListener(itemClickListener: StopWatchViewitemClickListener){
        this.watchItemClickListener = itemClickListener
    }


    override fun getItemCount(): Int {
        return millitems.size
    }
}