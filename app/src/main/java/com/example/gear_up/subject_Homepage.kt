package com.example.gear_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.ArrayList

class subject_Homepage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_homepage)

        val textview_subjectName: TextView = findViewById(R.id.subjectHome_Subjectname)
        val bundle: Bundle?= intent.extras
        val subjectName = bundle!!.getString("subjectName")
        //val subjectCode = bundle!!.getString("subjectCode")

        textview_subjectName.text = subjectName
        // Image is also included in this tutorial
        // https://www.youtube.com/watch?v=EoJX7h7lGxM

        val btn_viewQuiz = findViewById<ImageButton>(R.id.subjectHome_ViewQuiz)
        btn_viewQuiz.setOnClickListener(){



//            val myIntent = Intent(this, ViewQuiz::class.java)
//            myIntent.putExtra("subjectName",subjectName)
//            startActivity(myIntent)
//
//            finish()

            val myIntent = Intent(this, AttemptQuiz::class.java)
            //myIntent.putExtra("subjectName",subjectName)
            startActivity(myIntent)

            finish()
        }
    }
}