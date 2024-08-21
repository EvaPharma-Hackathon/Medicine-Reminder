package com.evapharma.medicinereminder.presentation
import androidx.lifecycle.viewModelScope
import com.evapharma.medicinereminder.core.BaseViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.GetNotificationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotificationViewModel @Inject constructor(
    private val getNotificationUseCase: GetNotificationUseCase
) : BaseViewModel() {

    private val _tokenState = MutableStateFlow<String?>(null)
    val tokenState: StateFlow<String?> = _tokenState

    init {
        fetchToken()
    }

    private fun fetchToken() {
        viewModelScope.launch {
            getNotificationUseCase.invoke().collect { token ->
                _tokenState.value = token
            }
        }
    }
}
