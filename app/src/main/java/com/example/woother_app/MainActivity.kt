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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}