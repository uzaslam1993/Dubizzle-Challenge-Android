package com.example.dubizzlechallengeandroid.common

data class AppException(val code: Int, val msg: String) : Exception(msg)