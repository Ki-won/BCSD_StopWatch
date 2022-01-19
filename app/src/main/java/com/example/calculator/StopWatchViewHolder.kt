package com.example.calculator

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class StopWatchViewHolder(watchlist: View) : RecyclerView.ViewHolder(watchlist) {
    var min: TextView = watchlist.findViewById(R.id.stop_watch_min)
    var sec: TextView = watchlist.findViewById(R.id.stop_watch_sec)
    var mile: TextView = watchlist.findViewById(R.id.stop_watch_mile)

    var watchContainer: ConstraintLayout = watchlist.findViewById(R.id.stop_watch_container)
}