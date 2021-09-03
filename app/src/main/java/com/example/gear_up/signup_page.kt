package com.example.gear_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class signup_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val loginButton = findViewById<ImageButton>(R.id.btn_login)
        loginButton.setOnClickListener(){
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }
    }

    override fun finish() {
//        this method is for back button
//                whenever we are on signup page and we press back button this transition will be applied
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }
}