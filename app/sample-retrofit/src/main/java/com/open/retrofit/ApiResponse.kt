package com.open.retrofit

import com.google.gson.annotations.SerializedName

/**
 * 用来接收接口返回的数据
 */
data class ApiResponse<T>(
    @SerializedName(value = "code", alternate = ["errorCode"]) val code: Int = 0,
    @SerializedName(value = "message", alternate = ["errorMsg"]) val message: String = "",
    @SerializedName(value = "data", alternate = ["result"]) val data: T? = null
) {
    val isSuccessful: Boolean
        get() = (code == 200) || ("ok" == message)

    val requireData: T?
        get() = data
}

data class ArticleList(
    @SerializedName("curPage") val curPage: Int = 0, // 1
    @SerializedName("datas") val datas: List<Article> = listOf(),
    @SerializedName("offset") val offset: Int = 0, // 0
    @SerializedName("over") val over: Boolean = false, // false
    @SerializedName("pageCount") val pageCount: Int = 0, // 604
    @SerializedName("size") val size: Int = 0, // 20
    @SerializedName("total") val total: Int = 0 // 12073
)

data class Article(
    @SerializedName("apkLink") val apkLink: String = "",
    @SerializedName("audit") val audit: Int = 0, // 1
    @SerializedName("author") val author: String = "",
    @SerializedName("canEdit") val canEdit: Boolean = false, // false
    @SerializedName("chapterId") val chapterId: Int = 0, // 502
    @SerializedName("chapterName") val chapterName: String = "", // 自助
    @SerializedName("collect") val collect: Boolean = false, // false
    @SerializedName("courseId") val courseId: Int = 0, // 13
    @SerializedName("desc") val desc: String = "",
    @SerializedName("descMd") val descMd: String = "",
    @SerializedName("envelopePic") val envelopePic: String = "",
    @SerializedName("fresh") val fresh: Boolean = false, // true
    @SerializedName("host") val host: String = "",
    @SerializedName("id") val id: Int = 0, // 22095
    @SerializedName("link") val link: String = "", // https://blog.csdn.net/qq_28779083/article/details/123833645
    @SerializedName("niceDate") val niceDate: String = "", // 6小时前
    @SerializedName("niceShareDate") val niceShareDate: String = "", // 6小时前
    @SerializedName("origin") val origin: String = "",
    @SerializedName("prefix") val prefix: String = "",
    @SerializedName("projectLink") val projectLink: String = "",
    @SerializedName("publishTime") val publishTime: Long = 0, // 1648602085000
    @SerializedName("realSuperChapterId") val realSuperChapterId: Int = 0, // 493
    @SerializedName("selfVisible") val selfVisible: Int = 0, // 0
    @SerializedName("shareDate") val shareDate: Long = 0, // 1648602085000
    @SerializedName("shareUser") val shareUser: String = "", // mtjsoft
    @SerializedName("superChapterId") val superChapterId: Int = 0, // 494
    @SerializedName("superChapterName") val superChapterName: String = "", // 广场Tab
    @SerializedName("tags") val tags: List<Tag> = listOf(),
    @SerializedName("title") val title: String = "", // 开发AndroidStudio图片压缩插件TinyPngPlus
    @SerializedName("type") val type: Int = 0, // 0
    @SerializedName("userId") val userId: Int = 0, // 468
    @SerializedName("visible") val visible: Int = 0, // 1
    @SerializedName("zan") val zan: Int = 0 // 0
)

data class Tag(
    @SerializedName("name") val name: String = "", // 公众号
    @SerializedName("url") val url: String = "" // /wxarticle/list/408/1
)
