package com.example.woother_app

import android.os.Bundle
import android.os.*
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
// api
import org.json.JSONObject
// 입력 스트림 / html / url 연결 / api /
import java.io.BufferedReader
// 입력
import java.io.InputStream
import java.io.InputStreamReader
// api 연결설정
import java.net.HttpURLConnection
// url 읽기
import java.net.URL

import java.util.concurrent.ExecutionException


import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class MainActivity : AppCompatActivity() {

    private lateinit var cityName: TextView
    private lateinit var search: Button
    private lateinit var show: TextView
    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        cityName = findViewById(R.id.cityName)
        search = findViewById(R.id.search)
        show = findViewById(R.id.weather)

        val temp = arrayOf("")

        search.setOnClickListener {
            Toast.makeText(this@MainActivity, "Button Clicked! ", Toast.LENGTH_SHORT).show()
            val city = cityName.text.toString()
            try {
                if (city.isNotEmpty()) {
                    url = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid={API_KEY}"
                } else {
                    Toast.makeText(this@MainActivity, "Enter City", Toast.LENGTH_SHORT).show()
                }
                val task = GetWeather()
                temp[0] = task.execute(url).get()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}