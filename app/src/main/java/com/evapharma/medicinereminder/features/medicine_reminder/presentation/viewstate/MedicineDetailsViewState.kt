package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewstate

import com.evapharma.medicinereminder.core.ViewState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine

typealias MedicineViewState = CommonViewState<Medicine>

typealias MedicineUpdateViewState = CommonViewState<Any>

data class MedicineDetailsViewState(
    val medicationViewState: MedicineViewState? = null,
    val medicineUpdateViewState: MedicineUpdateViewState? = null
) : ViewState



