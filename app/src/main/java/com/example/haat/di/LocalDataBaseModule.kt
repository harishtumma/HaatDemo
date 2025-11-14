package com.example.haat.di

import android.app.Application
import androidx.room.Room
import com.example.haat.data.local.AppDataBase
import com.example.haat.data.local.dao.CartDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class LocalDataBaseModule {

    @Provides
    fun provideDataBase(context: Application): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "notes_db"
        ).build()
    }

    @Provides
    fun provideCardDAO(appDataBase:AppDataBase): CartDAO{
        return appDataBase.cartDao()
    }
}

