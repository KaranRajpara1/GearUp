package com.example.gear_up

// Here in the constructor pass all those parameters which we want to fetch from firestore
// Also make sure that Field name and datatype of field name exactly matches with fire store
// (i.e. C_Name and C_Code are same field name in firestore faculty collection. And datatype is also string in firestore)
data class Student_Subject(var C_name: String ?= null, var C_Code: String ?= null)

