package com.example.reverimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_touch : Button = findViewById(R.id.btn_Acess)

         btn_touch.setOnClickListener {

             val go = Intent(this,imcActivity2::class.java)
             startActivity(go)
         }

    }
}