package com.evapharma.medicinereminder.features.covid_cases.data.repo

import android.util.Log
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.covid_cases.data.remote.data_source.CovidCasesRemoteDataSource
import com.evapharma.medicinereminder.features.covid_cases.data.remote.data_source.CovidRemoteDataSourceImpl
import com.evapharma.medicinereminder.features.covid_cases.data.remote.model.CovidCasesResponse
import com.evapharma.medicinereminder.features.covid_cases.domain.repo_contract.CovidRepo
import javax.inject.Inject

class CovidRepoImpl @Inject constructor(private val covidRemoteDataSourceImpl: CovidCasesRemoteDataSource):CovidRepo{
    override suspend fun getCovidCases(): DataState<CovidCasesResponse> {
        val response = covidRemoteDataSourceImpl.getCovidCases()
        Log.d("TAG", "getCovidCases: $response")
        return response
    }


}