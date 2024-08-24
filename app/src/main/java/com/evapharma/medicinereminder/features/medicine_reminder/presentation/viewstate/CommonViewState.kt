package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate

import com.evapharma.medicinereminder.core.ViewState

data class CommonViewState<T>(
    val isIdle: Boolean = true,
    val isEmpty: Boolean = false,
    val isSuccess : Boolean = false,
    val data: T? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null,
) : ViewState