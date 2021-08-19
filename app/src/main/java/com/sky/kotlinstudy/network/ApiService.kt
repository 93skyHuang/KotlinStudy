package com.sky.kotlinstudy.network

import com.sky.kotlinstudy.model.*
import com.sky.kotlinstudy.model.bean.BaseResponse
import retrofit2.Call
import retrofit2.http.*

/**
 *created skyHuang
 * data 2020/8/11
 *
 **/
interface ApiService {

    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): BaseResponse<ArticleList>

    @GET("/banner/json")
    suspend fun getHomeBanner(): BaseResponse<List<Banner>>
    @GET("/tree/json")
    suspend fun getSystemType(): BaseResponse<List<SystemParent>>

    @GET("/article/list/{page}/json")
    suspend fun getSystemTypeDetail(@Path("page") page: Int, @Query("cid") cid: Int): BaseResponse<ArticleList>

    @GET("/navi/json")
    suspend fun getNavigation(): BaseResponse<List<Navigation>>

    @GET("/project/tree/json")
    suspend fun getProjectType(): BaseResponse<List<SystemParent>>

    @GET("/wxarticle/chapters/json")
    suspend fun getBlogType(): BaseResponse<List<SystemParent>>

    @GET("/wxarticle/list/{id}/{page}/json")
    fun getBlogArticle(@Path("id") id: Int, @Path("page") page: Int): BaseResponse<ArticleList>

    @GET("/project/list/{page}/json")
    suspend fun getProjectTypeDetail(@Path("page") page: Int, @Query("cid") cid: Int): BaseResponse<ArticleList>

    @GET("/article/listproject/{page}/json")
    suspend fun getLastedProject(@Path("page") page: Int): BaseResponse<ArticleList>

    @GET("/friend/json")
    suspend fun getWebsites(): BaseResponse<List<Hot>>

    @GET("/hotkey/json")
    suspend fun getHot(): BaseResponse<List<Hot>>

    @FormUrlEncoded
    @POST("/article/query/{page}/json")
    suspend fun searchHot(@Path("page") page: Int, @Field("k") key: String): BaseResponse<ArticleList>

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): BaseResponse<User>

    @GET("/user/logout/json")
    suspend fun logOut(): BaseResponse<Any>

    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(@Field("username") userName: String, @Field("password") passWord: String, @Field("repassword") rePassWord: String): BaseResponse<User>

    @GET("/lg/collect/list/{page}/json")
    suspend fun getCollectArticles(@Path("page") page: Int): BaseResponse<ArticleList>

    @POST("/lg/collect/{id}/json")
    suspend fun collectArticle(@Path("id") id: Int): BaseResponse<ArticleList>

    @POST("/lg/uncollect_originId/{id}/json")
    suspend fun cancelCollectArticle(@Path("id") id: Int): BaseResponse<ArticleList>

    @GET("/user_article/list/{page}/json")
    suspend fun getSquareArticleList(@Path("page") page: Int): BaseResponse<ArticleList>

    @FormUrlEncoded
    @POST("/lg/user_article/add/json")
    suspend fun shareArticle(@Field("title") title: String, @Field("link") url: String): BaseResponse<String>

}