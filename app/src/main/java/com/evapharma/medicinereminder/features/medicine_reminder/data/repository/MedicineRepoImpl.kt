package com.evapharma.medicinereminder.features.medicine_reminder.data.repository

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSource
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repositry.MedicineRepo
import javax.inject.Inject

class MedicineRepoImpl @Inject constructor(
    private val medicineRemoteDataSource: MedicineRemoteDataSource
) : MedicineRepo {

    override suspend fun getMedicineList(): DataState<List<Medicine>> =
        medicineRemoteDataSource.getMedicineList()

    override suspend fun updateMedicine(medicineUpdateRequest: MedicineUpdateRequest): DataState<Void> =
        medicineRemoteDataSource.updateMedicine(medicineUpdateRequest)

    override suspend fun updateStatus(medicineStatusUpdateRequest: MedicineStatusUpdateRequest): DataState<Void> =
        medicineRemoteDataSource.updateStatus(medicineStatusUpdateRequest)
}
