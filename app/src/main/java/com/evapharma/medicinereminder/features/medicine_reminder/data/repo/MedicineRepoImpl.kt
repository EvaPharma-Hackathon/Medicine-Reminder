package com.evapharma.medicinereminder.features.medicine_reminder.data.repo

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.core.utils.Constants
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSource
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repo.MedicineRepo
import javax.inject.Inject

class MedicineRepoImpl @Inject constructor(
    private val medicineRemoteDataSource: MedicineRemoteDataSource
) : MedicineRepo {


    override suspend fun getMedicineList(): DataState<List<Medicine>> =
        medicineRemoteDataSource.getMedicineList()


    override suspend fun updateMedicine(medicineUpdateRequest: MedicineUpdateRequest): DataState<Any> =
        medicineRemoteDataSource.updateMedicine(medicineUpdateRequest)


    override suspend fun updateStatus(medicineStatusUpdateRequest: MedicineStatusUpdateRequest): DataState<Any> =
        medicineRemoteDataSource.updateStatus(medicineStatusUpdateRequest)


    override suspend fun getMedicineById(medicineId: Int): DataState<Medicine> {
        //TODO: should have an api endpoint for this
        // alternative solution get full list of medicines then filter by id

        val medicinesListResponse = medicineRemoteDataSource.getMedicineList()

        if (medicinesListResponse is DataState.Success) {
            val filteredList = medicinesListResponse.data.filter { it.id == medicineId }
            if (filteredList.isNotEmpty()) {
                return DataState.Success(filteredList[0])
            } else {
                return DataState.Error(
                    reason = listOf("Medicine not found"),
                    code = Constants.LOCAL_ERROR_CODE
                )
            }
        } else {
            return DataState.Error(
                reason = listOf("Medicine not found"),
                code = Constants.LOCAL_ERROR_CODE
            )
        }

    }

}
