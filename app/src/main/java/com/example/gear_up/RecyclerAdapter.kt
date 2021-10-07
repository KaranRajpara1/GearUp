package com.example.gear_up

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

//Ref link : https://www.youtube.com/watch?v=UCddGYMQJCo

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("HCD","IWT","DBMS","CN","OT","LA","ISBCP","CA")
    private var details = arrayOf("01CT0506","01CT0504","01CT0502","01CT0503", "01CT0501","01CT0509","01CT0505","01CT0510")
    private var images = arrayOf(R.drawable.androidimage,R.drawable.androidimage,R.drawable.androidimage,R.drawable.androidimage,
            R.drawable.androidimage,R.drawable.androidimage,R.drawable.androidimage,R.drawable.androidimage)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.student_card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }
    }

}