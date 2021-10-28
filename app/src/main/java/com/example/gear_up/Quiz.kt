package com.example.gear_up

data  class Quiz (
    var id: String = "",
    var title: String = "",
//    var questions: MutableMap<String,Question> = mutableMapOf()
//    var Questions: MutableMap<String,Question> = mutableMapOf()
    val Questions: Array<MutableMap<String, Question>> = arrayOf<MutableMap<String,Question>>() //explicit type declaration
        )
