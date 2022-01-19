package com.example.calculator

import android.view.View


interface RecyclerViewItemClickListener {
    fun onRecyclerViewItemClicked(view: View, position: Int) //이게 onlick
    fun onRecyclerViewItemLongClicked(view: View, position: Int)//이게 longonclick같은 녀석
}
