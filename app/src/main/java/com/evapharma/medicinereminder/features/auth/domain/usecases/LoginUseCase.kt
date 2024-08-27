package com.evapharma.medicinereminder.features.auth.domain.usecases

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest
import com.evapharma.medicinereminder.features.auth.domain.repo.AuthRepo
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepo) {

    suspend operator fun invoke(loginRequest: LoginRequest): DataState<String> =
        repository.login(loginRequest = loginRequest)
}
