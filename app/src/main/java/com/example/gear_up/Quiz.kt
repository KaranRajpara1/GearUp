package com.example.gear_up

data  class Quiz (
    var id: String = "",
    var title: String = "",
//    var questions: MutableMap<String,Question> = mutableMapOf()
//    var Questions: MutableMap<String,Question> = mutableMapOf()
     //var Questions: mutableListOf(<MutableMap<String, Question>>) = mutableListOf(<MutableMap<String,Question>>) //explicit type declaration
    //var Questions: MutableList<Map<String, String>> = mutableListOf(mapOf<String,String>())
    //var Questions: MutableList<MutableMap<String, String>> = mutableListOf(mutableMapOf())
    var paper: MutableList<MutableMap<String, String>> = mutableListOf(mutableMapOf())
        )
