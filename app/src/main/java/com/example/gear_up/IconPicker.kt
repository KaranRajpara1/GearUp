package com.example.gear_up

object IconPicker{
    val icons = arrayOf(R.drawable.androidimage,R.drawable.androidimage,R.drawable.androidimage,R.drawable.androidimage,R.drawable.androidimage)
    var currentIconIndex = 0
    fun getIcon(): Int{
        currentIconIndex = (currentIconIndex+1)% icons.size
        return icons[currentIconIndex]
    }
}