package com.evapharma.medicinereminder.features.covid_cases.data.remote.model

data class CovidCasesResponse(
    val data: Data?,
    val message: String?,
    val success: Boolean?
)