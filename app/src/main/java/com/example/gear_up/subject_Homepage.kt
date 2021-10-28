package com.example.gear_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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
    }
}