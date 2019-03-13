package com.example.forecastcoroutine.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.forecastcoroutine.R
import com.example.forecastcoroutine.data.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val apiService = ApiService()

        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(applicationContext, "Enter", Toast.LENGTH_SHORT).show()
            val currentWeatherResponse = apiService.getCurrentWeather("London").await()
            textView.text = currentWeatherResponse.current.tempC.toString()
            Toast.makeText(applicationContext, "Exit", Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener { Toast.makeText(applicationContext, "Click", Toast.LENGTH_SHORT).show() }
    }


}
