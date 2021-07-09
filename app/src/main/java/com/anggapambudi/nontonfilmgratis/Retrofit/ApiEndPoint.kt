package com.anggapambudi.nontonfilmgratis.Retrofit

import com.anggapambudi.nontonfilmgratis.response.ItemFilmResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndPoint {

    @GET("newupload")
    fun getNewUpload(): Call<ItemFilmResponse>

    @GET("search?")
    fun getSearch(
        @Query("query") searchFilm: String
    ): Call<ItemFilmResponse>

    @GET("{filter}")
    fun getFilmFilter(
        @Path("filter") filter: String
    ): Call<ItemFilmResponse>

    @GET("year?")
    fun getSearchTahun(
            @Query("year") searchTahun: String
    ): Call<ItemFilmResponse>

    @GET("country?")
    fun getSearchNegara(
            @Query("country") searchNegara: String
    ): Call<ItemFilmResponse>

    @GET("genre?")
    fun getSearchGenre(
            @Query("genre") searchGenre: String
    ): Call<ItemFilmResponse>

}