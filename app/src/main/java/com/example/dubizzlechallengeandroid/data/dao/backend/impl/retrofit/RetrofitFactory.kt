package com.example.dubizzlechallengeandroid.data.dao.backend.impl.retrofit


import com.example.dubizzlechallengeandroid.BuildConfig
import com.example.dubizzlechallengeandroid.common.Constants
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {


    private fun getDefaultRetrofit(baseUrl: String): Retrofit {
        val clientBuilder = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        }

        clientBuilder.addInterceptor(logging)

        val client = clientBuilder.build()

        val builder = Retrofit.Builder()
            .client(client)
            .baseUrl("$baseUrl/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        return builder.build()
    }

    fun getDefaultRetrofit(): Retrofit {
        return getDefaultRetrofit(Constants.BASE_URL)
    }

}