package com.evapharma.medicinereminder.features.covid_cases.domain.repo_contract

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.covid_cases.data.remote.model.CovidCasesResponse

interface CovidRepo {

    suspend fun getCovidCases():DataState<CovidCasesResponse>
}