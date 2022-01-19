package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class StopWatchFragment : Fragment() {
    private lateinit var stopwatchadapter: StopWatchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stop_watch, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stopwatchadapter = StopWatchAdapter()
        val pausebtn : ImageView = view.findViewById(R.id.fab_start)
        var time = 0
        var watchrunning = false
        var timerTask: Timer? =null
        var index  = 0


        stopwatchadapter.setStopWatchViewClickListener(object :StopWatchViewitemClickListener){

        }

        fun main() = runBlocking {
            val job = CoroutineScope(
                Dispatchers.Default
            ).launch {

            }

            suspend fun startWatch() {
            pausebtn.setImageResource(R.drawable.ic_baseline_pause_24)
                kotlin.concurrent.timer(period = 10){
                time++
                val min = time / 6000
                val sec = time / 100
                val mill = time % 100

                }
            }

            suspend fun pauseWatch() {
                pausebtn.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                timerTask?.cancel()
            }

            suspend fun stopWatch() {
                timerTask?.cancel()

                time = 0
                pausebtn.setImageResource(R.drawable.ic_baseline_play_arrow_24)

            }

        }

    }
}
