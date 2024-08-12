package com.evapharma.medicinereminder.features.covid_cases.data.remote.data_source


import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.models.handleException
import com.evapharma.medicinereminder.core.models.handleResponse
import com.evapharma.medicinereminder.core.network.BaseURLFactory
import com.evapharma.medicinereminder.features.covid_cases.data.remote.model.CovidCasesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CovidRemoteDataSourceImpl @Inject constructor() : CovidCasesRemoteDataSource {

    override suspend fun getCovidCases(): DataState<CovidCasesResponse> {
        return withContext(Dispatchers.IO){
            try {

                BaseURLFactory.retrofit.create(
                    CovidCasesApiService::class.java
                ).getCovidCases().handleResponse()
            }catch (t: Throwable){
                t.handleException()
            }
        }
    }

}