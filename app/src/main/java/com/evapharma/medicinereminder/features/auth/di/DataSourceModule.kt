package com.evapharma.medicinereminder.features.auth.di

import android.content.Context
import com.evapharma.medicinereminder.features.auth.data.local.AuthLocalDataSource
import com.evapharma.medicinereminder.features.auth.data.local.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(@ApplicationContext context: Context): AuthLocalDataSource {
        return AuthLocalDataSourceImpl(context)
    }
}