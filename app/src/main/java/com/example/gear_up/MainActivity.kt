package com.example.gear_up

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUpButton = findViewById<ImageButton>(R.id.btn_signUp)
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgot_password_textView)

        forgotPasswordTextView.paintFlags = forgotPasswordTextView.paintFlags

        signUpButton.setOnClickListener(){
            val myIntent = Intent(this, signup_page::class.java)
            startActivity(myIntent)
        }

        setupActivityLink()
    }

//    ref link for text clickable
//    https://learntodroid.com/how-to-create-a-hyperlink-using-android-textview/
    fun setupActivityLink() {
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgot_password_textView)
        forgotPasswordTextView.setTextColor(Color.RED)
        forgotPasswordTextView.setOnClickListener {
            val myIntent = Intent(this, forgot_password::class.java)
            startActivity(myIntent)
        }
    }
}