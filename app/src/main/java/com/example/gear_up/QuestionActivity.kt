package com.example.gear_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        bindViews()
    }
    private fun  bindViews(){
        val question = Question(
            "1",
            "5",
            "Sample Question",
            "opt A",
            "opt B",
            "opt C",
            "opt D",
            "opt A"
        )
        val description = findViewById<TextView>(R.id.description)
        description.text = question.Question
        val optionAdapter = OptionAdapter(this, question)
        val optionList = findViewById<RecyclerView>(R.id.optionList)
        optionList.layoutManager = LinearLayoutManager(this)
        optionList.adapter = optionAdapter
        optionList.setHasFixedSize(true) // it can increase performace slightly


    }
}
