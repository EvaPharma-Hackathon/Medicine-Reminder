package com.evapharma.medicinereminder.features.medicine_reminder.data.remote

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest

interface MedicineRemoteDataSource {

    suspend fun getMedicineList(): DataState<List<Medicine>>

    suspend fun updateMedicine(medicineUpdateRequest: MedicineUpdateRequest): DataState<Any>

    suspend fun updateStatus(medicineStatusUpdateRequest: MedicineStatusUpdateRequest): DataState<Any>

}