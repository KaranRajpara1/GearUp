package com.example.gear_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class signup_page : AppCompatActivity() {
    //private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val loginButton = findViewById<ImageButton>(R.id.btn_login)
        loginButton.setOnClickListener(){
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
            overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }


        // Initialize Firebase Auth
        //auth = Firebase.auth


        // Firebase register tutorial link: https://www.youtube.com/watch?v=8I5gCLaS25w
        val signUpBtn = findViewById<ImageButton>(R.id.btn_signUp)
        val emailTxt = findViewById<EditText>(R.id.txt_email)
        val passwordTxt = findViewById<EditText>(R.id.txt_password)
        signUpBtn.setOnClickListener {
            when{
                TextUtils.isEmpty(emailTxt.text.toString().trim{ it <= ' ' }) -> {
                    Toast.makeText(
                        this@signup_page,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(passwordTxt.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@signup_page,
                        "Please enter password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = emailTxt.text.toString().trim { it <= ' ' }
                    val password: String = passwordTxt.text.toString().trim { it <= ' ' }

                    // Create an instance and create a register a user with email and password
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->

                            // if the registration is successfully done
                                if(task.isSuccessful){

                                    //  Firebase regiterwed user
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@signup_page,
                                        "You are registered successfully.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    val intent =
                                        Intent(this@signup_page, MainActivity::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id",firebaseUser.uid)
                                    intent.putExtra("email_id",email)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    // If the registering is not successful then show error message
                                    Toast.makeText(
                                        this@signup_page,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                }
            }


        }

//        signUpBtn.setOnClickListener {
//            signUpUser()
//        }

    }

//    private fun signUpUser()
//    {
//        val emailTxt = findViewById<EditText>(R.id.txt_email)
//        val passwordTxt = findViewById<EditText>(R.id.txt_password)
//        if(emailTxt.text.toString().isEmpty()){
//            emailTxt.error = "Please enter email"
//            emailTxt.requestFocus()
//            return
//        }
//        if(!Patterns.EMAIL_ADDRESS.matcher(emailTxt.text.toString()).matches()){
//            emailTxt.error = "Please enter valid email"
//            emailTxt.requestFocus()
//            return
//        }
//        if(passwordTxt.text.toString().isEmpty()){
//            emailTxt.error = "Please enter password"
//            emailTxt.requestFocus()
//            return
//        }
//        auth.createUserWithEmailAndPassword(emailTxt.text.toString(), passwordTxt.text.toString())
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    //Log.d(TAG, "createUserWithEmail:success")
//                    val user = auth.currentUser
//                    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                    Toast.makeText(baseContext, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show()
//                    updateUI(null)
//                }
//            }
//    }
//
//    private fun updateUI(user: FirebaseUser?) {
//
//    }
//
//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser != null){
//            reload();
//        }
//    }
//
//    private fun reload() {
//        TODO("Not yet implemented")
//    }

    override fun finish() {
//        this method is for back button
//                whenever we are on signup page and we press back button this transition will be applied
        super.finish()
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right)
    }
}