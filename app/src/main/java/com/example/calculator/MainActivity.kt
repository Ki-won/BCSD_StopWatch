package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val calculatorFragment = CalculatorFragment()
    private val listFragment = ListFragment()
    private val watchFragment = StopWatchFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottom_navigation_list_calu)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_list -> showFragment(listFragment)
                R.id.menu_Calculator -> showFragment(calculatorFragment)
                R.id.menu_Stopwatch -> showFragment(watchFragment)
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}