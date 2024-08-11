package com.evapharma.medicinereminder.features.covid_cases.domain.use_cases

import com.evapharma.medicinereminder.features.covid_cases.domain.repo_contract.CovidRepo
import javax.inject.Inject

class GetCovidCasesUseCase @Inject constructor(private val covidRepo: CovidRepo) {

    suspend operator fun invoke() = covidRepo.getCovidCases()
}