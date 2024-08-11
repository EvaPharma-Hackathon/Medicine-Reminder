package com.evaph.se7etak.emr.vital.data

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.covid_cases.data.remote.model.CovidCasesResponse

interface CovidCasesRemoteDataSource {
    suspend fun getCovidCases(): DataState<CovidCasesResponse>
}
