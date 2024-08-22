package com.evapharma.medicinereminder.features.medicine_reminder.data.remote

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.models.getDataStateV2
import com.evapharma.medicinereminder.core.utils.Constants
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import javax.inject.Inject

class MedicineRemoteDataSourceImpl @Inject constructor(
    private val medicineApi: MedicineApiService
) : MedicineRemoteDataSource {

    override suspend fun getMedicineList(): DataState<List<Medicine>> =
        try {
            medicineApi.getMedicineList().getDataStateV2()
        } catch (exception: Exception) {
            DataState.Error(
                code = Constants.LOCAL_ERROR_CODE,
                reason = listOf(exception.message.toString())
            )
        }

    override suspend fun updateMedicine(medicineUpdateRequest: MedicineUpdateRequest): DataState<Void> =
        try {
            medicineApi.setReminder(medicineUpdateRequest).getDataStateV2()
        } catch (exception: Exception) {
            DataState.Error(
                code = Constants.LOCAL_ERROR_CODE,
                reason = listOf(exception.message.toString())
            )
        }

    override suspend fun updateStatus(medicineStatusUpdateRequest: MedicineStatusUpdateRequest): DataState<Void> =
        try {
            medicineApi.updateStatus(medicineStatusUpdateRequest).getDataStateV2()
        } catch (exception: Exception) {
            DataState.Error(
                code = Constants.LOCAL_ERROR_CODE,
                reason = listOf(exception.message.toString())
            )
        }
}