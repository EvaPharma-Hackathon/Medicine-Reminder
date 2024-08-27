package com.evapharma.medicinereminder.features.auth.di

import com.evapharma.medicinereminder.features.auth.data.remote.AuthRemoteDataSource
import com.evapharma.medicinereminder.features.auth.data.remote.AuthRemoteDataSourceImpl
import com.evapharma.medicinereminder.features.auth.data.repo.AuthRepoImpl
import com.evapharma.medicinereminder.features.auth.domain.repo.AuthRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindAuthRepository(authRepoImpl: AuthRepoImpl): AuthRepo

    @Binds
    abstract fun bindAuthRemoteDataSource(authRemoteDataSourceImpl: AuthRemoteDataSourceImpl): AuthRemoteDataSource

}

