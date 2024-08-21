package com.limitlesscare.medsulto.features.cme.di

import com.evapharma.medicinereminder.core.network.BaseURLFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit

import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        BaseURLFactory.resetBaseURL("https://medicinereminder.evapharma.com/")
        return BaseURLFactory.retrofit
    }

}