package com.anggapambudi.nontonfilmgratis.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL = "https://api-lk21.herokuapp.com/"

    val instance: ApiEndPoint by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(ApiEndPoint::class.java)
    }

}