package com.tragulon.plants.screens.di

import android.content.Context
import com.tragulon.plants.screens.database.AppDatabase
import com.tragulon.plants.screens.database.EditDao
import com.tragulon.plants.screens.database.FavouriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(context = appContext)
    }

    @Singleton
    @Provides
    fun provideFavouriteDao(appDatabase : AppDatabase): FavouriteDao {
        return appDatabase.favouriteDao()
    }

    @Singleton
    @Provides
    fun provideEditDao(appDatabase : AppDatabase): EditDao {
        return appDatabase.editDao()
    }
}