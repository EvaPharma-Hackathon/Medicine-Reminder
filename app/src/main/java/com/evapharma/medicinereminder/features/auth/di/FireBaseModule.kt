package com.evapharma.medicinereminder.features.auth.di

import com.evapharma.medicinereminder.features.auth.data.remote.MyFirebaseMessagingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FireBaseModule {

    @Provides
    @Singleton
    fun provideMyFirebaseMessagingService(): MyFirebaseMessagingService {
        return MyFirebaseMessagingService()
    }
}