package com.open.learncode.开源框架.retrofit2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

public interface TestApi {

    @GET("/wxarticle/chapters/json")
    fun getChapters(): Call<ChaptersResponse>
}