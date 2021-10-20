package com.example.gear_up

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

// Ref link for fetching data from firestore and put it into recyclerview: https://youtu.be/Ly0xwWlUpVM
// Related files : Student_Subject.kt

// Ref link for Item Click Listener - RecyclerView : https://youtu.be/dB9JOsVx-yY

class Student_Subject_Adapter(private val subjectList: ArrayList<Student_Subject>): RecyclerView.Adapter<Student_Subject_Adapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClcik(positiion : Int)

    }

    fun setOnItemClickListener(listener : onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Student_Subject_Adapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_card_layout,parent,false)
        return MyViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: Student_Subject_Adapter.MyViewHolder, position: Int) {
        val subject : Student_Subject = subjectList[position]
        holder.subjectTitle.text = subject.C_Name
        holder.subjectCode.text = subject.C_Code
        // Here if any field value is ither than string, for example long then convert it into string
        // for example: if C_Code is long then holder.subjectCode.text = subject.C_Code.toString()

    }

    override fun getItemCount(): Int {
        return  subjectList.size
    }

    public class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val subjectTitle : TextView = itemView.findViewById(R.id.item_title)
        val subjectCode : TextView = itemView.findViewById(R.id.item_detail)

        // this is a constructor in kotlin for this iner class
        init {
            itemView.setOnClickListener {
                listener.onItemClcik(adapterPosition)

            }
        }
    }
}