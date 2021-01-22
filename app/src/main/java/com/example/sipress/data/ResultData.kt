package com.example.sipress.data

data class ResultData<T>(
    val isSuccess:Boolean,
    val data:T?,
    val message:String?
)