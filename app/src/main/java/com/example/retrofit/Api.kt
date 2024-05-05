package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("photos")
    fun getPhotos(): Call<List<Photo>>

}