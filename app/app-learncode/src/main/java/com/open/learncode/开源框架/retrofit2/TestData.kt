package com.open.learncode.开源框架.retrofit2

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ChaptersResponse(
    @SerializedName("data") val data: List<ChaptersData>? = null,
    @SerializedName("errorCode") val errorCode: Int? = null,
    @SerializedName("errorMsg") val errorMsg: String? = null
)

@Keep
data class ChaptersData(
    @SerializedName("children") val children: List<Any>? = null,
    @SerializedName("courseId") val courseId: Int? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("order") val order: Int? = null,
    @SerializedName("parentChapterId") val parentChapterId: Int? = null,
    @SerializedName("userControlSetTop") val userControlSetTop: Boolean? = null,
    @SerializedName("visible") val visible: Int? = null
)