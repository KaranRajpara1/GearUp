package com.example.gear_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class forgot_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val smsBtn = findViewById<ImageButton>(R.id.SMSbutton)

        smsBtn.setOnClickListener() {
            val myIntent = Intent(this, recoverypage::class.java)
            startActivity(myIntent)
        }
    }
}