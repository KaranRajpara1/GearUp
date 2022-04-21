package com.example.gear_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import java.util.ArrayList

class AttemptQuiz : AppCompatActivity() {
    // variables for Attempt Quiz
    private lateinit var recyclerView: RecyclerView
    private lateinit var questionArrayList: ArrayList<QuizAttempt>
    private lateinit var myAdapter: AttemptQuizAdapter
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attempt_quiz)

        recyclerView = findViewById(R.id.recyclerview_attemptQuiz)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        questionArrayList = arrayListOf()
        myAdapter = AttemptQuizAdapter(questionArrayList)
        recyclerView.adapter = myAdapter

        EventChangeListener()
    }

    private fun EventChangeListener() {
        // fetch data from firestore
        db = FirebaseFirestore.getInstance()
        db.collection("SE_Quiz1").
        addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {
                if(error != null){
                    // got some error
                    Log.e("Firestore Error",error.message.toString())
                    return
                }
                for(dc: DocumentChange in value?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED){
                        questionArrayList.add(dc.document.toObject(QuizAttempt::class.java))
                    }
                }
                myAdapter.notifyDataSetChanged()
            }

        })

    }
}