package com.example.calculator

import android.view.View

interface StopWatchViewitemClickListener : RecyclerViewItemClickListener {
    fun onStartBtnClicked(view: View, position: String)
    fun onpuaseBtnClicked(view: View, position: String)
    fun onstopBtnClicked(view: View, position: String)
}