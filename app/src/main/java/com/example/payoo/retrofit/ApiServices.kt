package com.example.payoo.retrofit


import com.example.payoo.response.UserResponse
import retrofit2.Call
import retrofit2.http.*
interface ApiServices {
    @GET("/user")
    fun getUserProfile(@Path("userId") userId: String): Call<UserResponse>

}