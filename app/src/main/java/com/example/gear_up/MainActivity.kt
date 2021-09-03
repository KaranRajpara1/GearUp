package com.example.gear_up

import android.content.Intent
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
//        val forgotPasswordTextView = findViewById<TextView>(R.id.forgot_password)
//        forgotPasswordTextView.setOnClickListener {
//            val myIntent = Intent(this, forgot_password::class.java)
//            startActivity(myIntent)
////            forgot_password.movementMethod = LinkMovementMethod.getInstance();
//        }
        val signUpButton = findViewById<ImageButton>(R.id.btn_signUp)

        signUpButton.setOnClickListener(){
            val myIntent = Intent(this, signup_page::class.java)
            startActivity(myIntent)
        }
//        forgotPasswordTextView.setOnClickListener {
//            val myIntent = Intent(this, forgot_password::class.java)
//            startActivity(myIntent)
//        }

//        textSpan()

    }
//    private fun textSpan()
//    {
//        val spannableString = SpannableString("Forgot Password ?")
//        val forgotPasswordTextView = findViewById<TextView>(R.id.forgot_password)
//        val clickableSpan = object : ClickableSpan(){
//            override fun onClick(widget: View) {
//                val myIntent = Intent(this@MainActivity, forgot_password::class.java)
//                startActivity(myIntent)
//            }
//
//            override fun updateDrawState(ds: TextPaint) {
//                super.updateDrawState(ds)
//
//            }
//        }
//        spannableString.setSpan(clickableSpan,0,17,Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
//        forgotPasswordTextView.text = spannableString
//        forgotPasswordTextView.movementMethod = LinkMovementMethod.getInstance()
//    }
}