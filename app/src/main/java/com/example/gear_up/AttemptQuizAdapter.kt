package com.example.gear_up

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class AttemptQuizAdapter(private var questionList: ArrayList<QuizAttempt>) : RecyclerView.Adapter<AttemptQuizAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AttemptQuizAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_attemptquiz,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AttemptQuizAdapter.MyViewHolder, position: Int) {
        val myquestion : QuizAttempt = questionList[position]
        holder.quesion.text = myquestion.Question
        holder.optionA.text = myquestion.OptionA
        holder.optionB.text = myquestion.OptionB
        holder.optionC.text = myquestion.OptionC
        holder.optionD.text = myquestion.OptionD

    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    public class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val quesion : TextView =  itemView.findViewById(R.id.question_attemptQuiz)
        val optionA : TextView =  itemView.findViewById(R.id.optionA_attemptQuiz)
        val optionB : TextView =  itemView.findViewById(R.id.optionB_attemptQuiz)
        val optionC : TextView =  itemView.findViewById(R.id.optionC_attemptQuiz)
        val optionD : TextView =  itemView.findViewById(R.id.optionD_attemptQuiz)

    }
}