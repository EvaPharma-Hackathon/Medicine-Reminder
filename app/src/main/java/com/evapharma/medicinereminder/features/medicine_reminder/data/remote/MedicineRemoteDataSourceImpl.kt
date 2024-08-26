package com.evapharma.medicinereminder.features.medicine_reminder.data.remote

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.models.getDataState
import com.evapharma.medicinereminder.core.models.handleException
import com.evapharma.medicinereminder.core.network.BaseURLFactory
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MedicineRemoteDataSourceImpl @Inject constructor(
) : MedicineRemoteDataSource {

    override suspend fun getMedicineList(): DataState<List<Medicine>> =
        withContext(Dispatchers.IO) {
            try {
                BaseURLFactory.retrofit.create(
                    MedicineApiService::class.java
                ).getMedicineList().getDataState()
            } catch (t: Throwable) {
                t.handleException()
            }
        }

    override suspend fun updateMedicine(medicineUpdateRequest: MedicineUpdateRequest): DataState<Any> =
        withContext(Dispatchers.IO) {
            try {
                BaseURLFactory.retrofit.create(
                    MedicineApiService::class.java
                ).setReminder(medicineUpdateRequest = medicineUpdateRequest).getDataState()
            } catch (t: Throwable) {
                t.handleException()
            }
        }

    override suspend fun updateStatus(medicineStatusUpdateRequest: MedicineStatusUpdateRequest): DataState<Any> =
        withContext(Dispatchers.IO) {
            try {
                BaseURLFactory.retrofit.create(
                    MedicineApiService::class.java
                ).updateStatus(request = medicineStatusUpdateRequest).getDataState()
            } catch (t: Throwable) {
                t.handleException()
            }
        }
}