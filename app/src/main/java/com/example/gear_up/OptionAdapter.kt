package com.example.gear_up

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class OptionAdapter(val context: Context, val question: Question) :
    RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {
    private var options: List<String> = listOf(question.optionA, question.optionB, question.optionC, question.optionD)

    inner class OptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var optionView = itemView.findViewById<TextView>(R.id.quiz_option)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.option_item, parent, false)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        holder.optionView.text = options[position]
        holder.itemView.setOnClickListener{
            // Toast.makeText(context, options[position], Toast.LENGTH_SHORT).show()
            // whenever user will click on any option, it will store that into question.userAnswer
            question.userAnswer = options[position]
            notifyDataSetChanged() // question object is modified so acccordingly change the randering
        }
        if(question.userAnswer == options[position]){
            // Toast.makeText(context, "SHOW RED BORDER", Toast.LENGTH_SHORT).show()
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg)
        }
        else{
            // Toast.makeText(context, "SHOW SIMPLE BORDER", Toast.LENGTH_SHORT).show()
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg)

        }
    }

    override fun getItemCount(): Int {
        return options.size
    }
}