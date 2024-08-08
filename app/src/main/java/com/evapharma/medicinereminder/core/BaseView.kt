package com.evapharma.medicinereminder.core

import com.evapharma.medicinereminder.core.models.ErrorResponse

interface BaseView {

    fun onError(error: ErrorResponse?)

    fun showLoading()

    fun hideLoading()

    fun showSuccessMsg(msg: String)

    fun showErrorMsg(msg: String)
}