package com.example.haat.network.di

import com.example.haat.network.AuthInterceptor
import com.example.haat.network.apiservice.BuisnessService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    val BASE_URL ="https://user-new-app-staging.internal.haat.delivery"
     @Provides
    fun retrofitBuilderProvider(okHttpClient: OkHttpClient): Retrofit.Builder{
       var res= Retrofit.Builder()
           .baseUrl(BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .client(okHttpClient)
        return res
    }

    @Provides
    fun okhttpProvide(authenticator: AuthInterceptor): OkHttpClient
    {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY  // Options: NONE, BASIC, HEADERS, BODY
        }

        return OkHttpClient().newBuilder()
            .addInterceptor(authenticator)
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Provides
    fun ProvidesRetrofit(builder:Retrofit.Builder): Retrofit
    {
        return builder.build()
    }

    @Provides
    fun getNetworkService(retrofit: Retrofit)=retrofit.create(BuisnessService::class.java)

}