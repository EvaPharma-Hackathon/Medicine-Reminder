package com.evapharma.medicinereminder.features.medicine_reminder.di

import com.evapharma.medicinereminder.BuildConfig
import com.evapharma.medicinereminder.core.network.BaseURLFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkProvider {

    // provide Token /* TODO: should be removed later */
    @Singleton
    @Provides
    @Named("BEARER_TOKEN")
    fun provideToken() =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjEiLCJuYmYiOjE3MjQ1ODI3NjgsImV4cCI6MTcyNDU4NjM2OCwiaWF0IjoxNzI0NTgyNzY4fQ.uI8ii3029J-uHu3-KmiMcsy1dGfzwZR1BffJouZGh4k"
}


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(@Named("BEARER_TOKEN") bearerToken: String): Retrofit {
        return BaseURLFactory.provideRetrofitWithAuth(
            baseUrl = BuildConfig.BASE_URL,
            bearerToken = bearerToken
        )
    }

}