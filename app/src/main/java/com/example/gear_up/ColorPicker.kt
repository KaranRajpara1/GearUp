package com.example.gear_up

object ColorPicker{
    val colors = arrayOf("#25F8F8","#F00CE7","#25F8F8","#CCFF00","#CCFF00")
    var currentColorIndex = 0
    fun getColor(): String{
       currentColorIndex = (currentColorIndex+1)% colors.size
       return colors[currentColorIndex]
    }
}