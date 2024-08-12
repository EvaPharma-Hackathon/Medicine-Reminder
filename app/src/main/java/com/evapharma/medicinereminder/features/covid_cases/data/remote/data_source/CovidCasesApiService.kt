package com.evapharma.medicinereminder.features.covid_cases.data.remote.data_source

import com.evapharma.medicinereminder.Endpoints
import com.evapharma.medicinereminder.core.models.BaseResponse
import com.evapharma.medicinereminder.features.covid_cases.data.remote.model.CovidCasesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CovidCasesApiService {

    @GET(Endpoints.GET_COVID_CASES)
    @JvmSuppressWildcards
    suspend fun getCovidCases(): Response<BaseResponse<CovidCasesResponse>>


}