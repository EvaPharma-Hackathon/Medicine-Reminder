package com.evapharma.medicinereminder.features.covid_cases.presentation.viewmodels

import com.evapharma.medicinereminder.core.MVIBaseViewModel
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.covid_cases.domain.use_cases.GetCovidCasesUseCase
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesActions
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesResults
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getCovidCasesUseCase: GetCovidCasesUseCase) :
    MVIBaseViewModel<CovidCasesActions, CovidCasesResults, CovidCasesViewState>() {

    private val _covidCasesStateFlow: MutableStateFlow<CovidCasesViewState> =
        MutableStateFlow(CovidCasesViewState(isIdle = true))


    override val defaultViewState: CovidCasesViewState
        get() = CovidCasesViewState(isIdle = true)

    override fun handleAction(action: CovidCasesActions): Flow<CovidCasesResults> {
        return flow {
            when (action) {
                is CovidCasesActions.GetCovidCases -> {
                    handleActionOfGetCovidCases(this, action)

                }
            }

        }
    }

    private suspend fun handleActionOfGetCovidCases(
        flowCollector: FlowCollector<CovidCasesResults>,
        action: CovidCasesActions.GetCovidCases
    ) {
//        val oldCovidCases = _covidCasesStateFlow.value.data
        when(val response = getCovidCasesUseCase()){

            is DataState.Success -> {
                val viewState = CovidCasesViewState(data = response.data)
                _covidCasesStateFlow.value = viewState
                flowCollector.emit(
                    CovidCasesResults.GetCovidCases(viewState = viewState)
                )
            }

            is DataState.Loading -> {
                val viewState = CovidCasesViewState(isLoading = true)
                _covidCasesStateFlow.value = viewState
                flowCollector.emit(
                    CovidCasesResults.GetCovidCases(viewState = viewState)
                )
            }

            is DataState.ErrorV2 -> response.exception?.let { exception -> emitException(exception) }

            else -> {}
        }


    }


}