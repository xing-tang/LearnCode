package com.open.learncode.开源框架.okhttp3

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ImageResponse(
        @SerializedName("adstar") val adstar: Int? = null,
        @SerializedName("boxresult") val boxresult: Any? = null,
        @SerializedName("ceg") val ceg: Boolean? = null,
        @SerializedName("cn") val cn: Int? = null,
        @SerializedName("cuben") val cuben: Int? = null,
        @SerializedName("end") val end: Boolean? = null,
        @SerializedName("gn") val gn: Int? = null,
        @SerializedName("kn") val kn: Int? = null,
        @SerializedName("lastindex") val lastindex: Int? = null,
        @SerializedName("list") val imageList: ArrayList<Image>? = null,
        @SerializedName("pc") val pc: Int? = null,
        @SerializedName("prevsn") val prevsn: Int? = null,
        @SerializedName("ps") val ps: Int? = null,
        @SerializedName("ran") val ran: Int? = null,
        @SerializedName("ras") val ras: Int? = null,
        @SerializedName("sid") val sid: String? = null,
        @SerializedName("total") val total: Int? = null,
        @SerializedName("wordguess") val wordguess: Any? = null
)

@Keep
data class Image(
    @SerializedName("color") val color: Int? = null,
    @SerializedName("comm_purl") val commPurl: String? = null,
    @SerializedName("downurl") val downurl: Boolean? = null,
    @SerializedName("downurl_true") val downurlTrue: String? = null,
    @SerializedName("dsptime") val dsptime: String? = null,
    @SerializedName("dspurl") val dspurl: String? = null,
    @SerializedName("fixedSize") val fixedSize: Boolean? = null,
    @SerializedName("fnum") val fnum: String? = null,
    @SerializedName("grpcnt") val grpcnt: String? = null,
    @SerializedName("grpmd5") val grpmd5: Boolean? = null,
    @SerializedName("height") val height: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("img") val img: String? = null,
    @SerializedName("imgkey") val imgkey: String? = null,
    @SerializedName("imgsize") val imgsize: String? = null,
    @SerializedName("imgtype") val imgtype: String? = null,
    @SerializedName("index") val index: Int? = null,
    @SerializedName("key") val key: String? = null,
    @SerializedName("link") val link: String? = null,
    @SerializedName("litetitle") val litetitle: String? = null,
    @SerializedName("qqface_down_url") val qqfaceDownUrl: Boolean? = null,
    @SerializedName("source") val source: Int? = null,
    @SerializedName("src") val src: String? = null,
    @SerializedName("thumb") val thumb: String? = null,
    @SerializedName("_thumb") val _thumb: String? = null,
    @SerializedName("thumb_bak") val thumbBak: String? = null,
    @SerializedName("_thumb_bak") val _thumb_bak: String? = null,
    @SerializedName("thumbHeight") val thumbHeight: Int? = null,
    @SerializedName("thumbWidth") val thumbWidth: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("type") val type: Int? = null,
    @SerializedName("width") val width: String? = null
)