package com.evapharma.medicinereminder.features.auth.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.evapharma.medicinereminder.core.BaseViewModel
import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest
import com.evapharma.medicinereminder.features.auth.domain.usecases.LoginUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate.CommonViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel() {

    private val _loginState = MutableStateFlow<CommonViewState<Any>>(CommonViewState())
    val loginState: StateFlow<CommonViewState<Any>> = _loginState


    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _loginState.value = CommonViewState(isLoading = true)
            // Simulate login process (you will replace this with actual login logic)
            try {
                // Perform login (e.g., make a network request)
                val response = loginUseCase(loginRequest)
                when (response) {
                    is DataState.Success -> {
                        _loginState.value = CommonViewState(isSuccess = true)
                    }

                    else -> {
                        _loginState.value = CommonViewState(error = Throwable("Login failed"))
                    }
                }

            } catch (e: Exception) {
                _loginState.value = CommonViewState(error = Throwable("Login failed"))
            }
        }
    }
}