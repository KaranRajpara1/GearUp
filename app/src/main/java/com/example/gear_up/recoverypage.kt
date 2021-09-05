package com.example.gear_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class recoverypage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recoverypage)

        val nextBtn = findViewById<ImageButton>(R.id.next)

        nextBtn.setOnClickListener() {
            val myIntent = Intent(this, change_password::class.java)
            startActivity(myIntent)
        }
    }
}