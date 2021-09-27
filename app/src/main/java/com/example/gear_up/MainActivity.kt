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
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    // Firebase
//    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUpButton = findViewById<ImageButton>(R.id.btn_signUp)
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgot_password_textView)
        val loginButton = findViewById<ImageButton>(R.id.btn_login)
        forgotPasswordTextView.paintFlags = forgotPasswordTextView.paintFlags

        signUpButton.setOnClickListener(){
            val myIntent = Intent(this, signup_page::class.java)
            startActivity(myIntent)
//            added animation
//                    ref link : https://www.youtube.com/watch?v=0s6x3Sn4eYo
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
        }

        loginButton.setOnClickListener(){
            val myIntent = Intent(this, activity_student::class.java)
            startActivity(myIntent)
        }

        // Initialize Firebase Auth
//        auth = Firebase.auth

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        //val txtUserid = findViewById<EditText>(R.id.login_userid)
        //val txtpassword = findViewById<EditText>(R.id.login_password)

        // setting text on text field
        // txtUserid.text = "User ID :: $userId"
        // txtpassword.text = "Email ID :: $emailId"

        // for logout (ref link: https://www.youtube.com/watch?v=8I5gCLaS25w  see from 25:07)
//        btn_logout.setOnClickListener { it:View!
//                // Logout from app
//            FirebaseAuth.getInstance().signOut()
//            // and then give intetnt to main activity
//            finish()
//
//        }


        setupActivityLink()


    }





    //    ref link for text clickable
//    https://learntodroid.com/how-to-create-a-hyperlink-using-android-textview/
    fun setupActivityLink() {
        val forgotPasswordTextView = findViewById<TextView>(R.id.forgot_password_textView)
        forgotPasswordTextView.setTextColor(getResources().getColor(R.color.textedit))
        forgotPasswordTextView.setOnClickListener {
            val myIntent = Intent(this, forgot_password::class.java)
            startActivity(myIntent)
        }
    }
}