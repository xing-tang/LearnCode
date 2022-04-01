package com.open.retrofit

import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * ApiService
 *
 * @Description: xxx
 * @Author: xing.tang
 */
interface ApiService {
    @GET("/article/list/{page}/json")
    fun getArticleList1(@Path("page") page: Int): Call<String>

    @GET("/article/list/{page}/json")
    fun getArticleList2(@Path("page") page: Int): Call<ApiResponse<ArticleList>>

    @GET("/article/list/{page}/json")
    fun getArticleList3(@Path("page") page: Int): Flowable<ApiResponse<ArticleList>>

    @GET("/article/list/{page}/json")
    suspend fun getArticleList4(@Path("page") page: Int): ApiResponse<ArticleList>
}