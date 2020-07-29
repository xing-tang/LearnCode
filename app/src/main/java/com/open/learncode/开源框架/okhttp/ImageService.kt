package com.open.learncode.开源框架.okhttp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ImageService {

    @GET("j")
    fun getImageResponse(@Query("q") q: String, @Query("sn") sn: Int, @Query("pn") pn: Int): Call<ImageResponse>

}