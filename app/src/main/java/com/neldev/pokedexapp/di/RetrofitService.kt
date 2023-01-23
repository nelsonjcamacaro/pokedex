package com.neldev.pokedexapp.di

import android.content.Context
import kotlinx.coroutines.withContext
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import kotlin.coroutines.coroutineContext

class RetrofitService {
    companion object {
        val instance: Retrofit
            get() {
                val httpClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()

                return Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build()
            }
    }
}
