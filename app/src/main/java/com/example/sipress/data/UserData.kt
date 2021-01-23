package com.example.sipress.data

import com.google.gson.annotations.SerializedName

data class UserData(
        val batch:String,
        @SerializedName("class")
        val mClass:String,
        val dayOfBirth:String,
        val email:String,
        val name:String,
        val password:String,
        val nis:Long
)