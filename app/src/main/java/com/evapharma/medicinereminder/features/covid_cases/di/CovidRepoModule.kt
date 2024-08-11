package com.evapharma.medicinereminder.features.covid_cases.di

import com.evaph.se7etak.emr.vital.data.CovidCasesRemoteDataSource
import com.evaph.se7etak.emr.vital.data.CovidRemoteDataSourceImpl
import com.evapharma.medicinereminder.features.covid_cases.data.repo.CovidRepoImpl
import com.evapharma.medicinereminder.features.covid_cases.domain.repo_contract.CovidRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class CovidRepoModule {

    @Binds
    abstract fun bindCovidRemoteDataSourceImpl(
        covidRemoteDataSourceImpl: CovidRemoteDataSourceImpl
    ): CovidCasesRemoteDataSource

    @Binds
    abstract fun bindCovidRepoImpl(covidRepoImpl: CovidRepoImpl): CovidRepo
}