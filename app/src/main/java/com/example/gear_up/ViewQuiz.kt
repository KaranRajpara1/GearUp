package com.example.gear_up

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects

class ViewQuiz : AppCompatActivity() {
    lateinit var adapter: QuizAdapter
//    private var quizList = mutableListOf<Quiz>()
    private var quizList: MutableList<Quiz> = mutableListOf<Quiz>()
    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_quiz)




        setUpFireStore()
        populateDummyData()
        setUpRecyclerView()

    }

    private fun setUpFireStore() {
        val bundle: Bundle?= intent.extras
        val subjectName = bundle!!.getString("subjectName")
        firestore = FirebaseFirestore.getInstance()
        Log.d("Subject name",subjectName.toString())
        val collectionRefernece = firestore.collection(subjectName.toString())
        Log.d("Collection refernece",collectionRefernece.toString())
        collectionRefernece.addSnapshotListener{  value,error ->
            if(value == null )
            {
                Toast.makeText(this,"NULL data",Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            else if(error != null)
            {
                Toast.makeText(this,"Error Fetching Data",Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            Log.d("Data",value.toObjects(Quiz::class.java).toString())
//            for (prop in Quiz::class.java) {
//                println("${prop.name} = ${prop.get(user)}")
//            }
            (value.toObjects(Quiz::class.java)).forEach {
                Log.d("Item ",it.toString())
                Log.d("title ","${it.title}")
//                var singleQuiz: MutableList<MutableMap<String, String>> = mutableListOf(mutableMapOf())
//                singleQuiz = it
                if(it.title != ""){
                    Log.d("Quiz","${it}")
//                    quizList.toMutableList().add(it)
                    quizList.add(it)
                }
            }
            quizList.clear()
            //quizList.addAll(value.toObjects(Quiz::class.java))
            adapter.notifyDataSetChanged() // to tell adapter that data has been changed so do the refresh
        }
    }

    private fun populateDummyData() {
        quizList.add(Quiz("12-10-2021","12-10-2021"))
        quizList.add(Quiz("13-10-2021","13-10-2021"))
        quizList.add(Quiz("14-10-2021","14-10-2021"))
        quizList.add(Quiz("15-10-2021","15-10-2021"))
        quizList.add(Quiz("16-10-2021","16-10-2021"))
    }

    private fun setUpRecyclerView() {
        val recyclerview = findViewById<RecyclerView>(R.id.quizRecyclerView)
        adapter = QuizAdapter(this,quizList)
        recyclerview.layoutManager = GridLayoutManager(this,2)
        recyclerview.adapter = adapter
    }
}