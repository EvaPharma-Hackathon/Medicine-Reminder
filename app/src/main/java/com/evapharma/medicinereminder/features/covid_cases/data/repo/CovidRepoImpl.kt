package com.evapharma.medicinereminder.features.covid_cases.data.repo

import com.evaph.se7etak.emr.vital.data.CovidRemoteDataSourceImpl
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.covid_cases.data.remote.model.CovidCasesResponse
import com.evapharma.medicinereminder.features.covid_cases.domain.repo_contract.CovidRepo
import javax.inject.Inject

class CovidRepoImpl @Inject constructor(private val covidRemoteDataSourceImpl: CovidRemoteDataSourceImpl):CovidRepo{
    override suspend fun getCovidCases(): DataState<CovidCasesResponse> {
        return covidRemoteDataSourceImpl.getCovidCases()
    }


}