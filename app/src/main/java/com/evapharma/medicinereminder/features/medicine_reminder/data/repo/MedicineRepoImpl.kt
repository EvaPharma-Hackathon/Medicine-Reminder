package com.evapharma.medicinereminder.features.medicine_reminder.data.repo

import com.evapharma.medicinereminder.core.models.DataState
import com.evapharma.medicinereminder.features.medicine_reminder.data.mock.MockDataManager
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineStatusUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Status
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSource
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repo.MedicineRepo
import javax.inject.Inject

class MedicineRepoImpl @Inject constructor(
    private val medicineRemoteDataSource: MedicineRemoteDataSource
) : MedicineRepo {



    override suspend fun getMedicineList(): DataState<List<Medicine>> =
        // medicineRemoteDataSource.getMedicineList()
        DataState.Success(MockDataManager.medicinesList)


    override suspend fun updateMedicine(medicineUpdateRequest: MedicineUpdateRequest): DataState<Any>
//        medicineRemoteDataSource.updateMedicine(medicineUpdateRequest)
    {
        if (MockDataManager.medicinesList.find { it.id == medicineUpdateRequest.medicationId } != null) {
            MockDataManager.medicinesList =
                MockDataManager.medicinesList.map {
                    if (it.id == medicineUpdateRequest.medicationId) it.copy(
                        status = Status.fromString(
                            medicineUpdateRequest.status
                        ),
                        durationFrom = medicineUpdateRequest.durationFrom,
                        durationTo = medicineUpdateRequest.durationTo,
                        time = medicineUpdateRequest.time
                    ) else it
                }
            return DataState.Success(Any())
        }
        return DataState.Error(reason = listOf("Medicine not found"), code = 0)
    }


    override suspend fun updateStatus(medicineStatusUpdateRequest: MedicineStatusUpdateRequest): DataState<Any>
//        medicineRemoteDataSource.updateStatus(medicineStatusUpdateRequest)
    {
        if (MockDataManager.medicinesList.find { it.id == medicineStatusUpdateRequest.medicationId } != null) {
            MockDataManager.medicinesList =
                MockDataManager.medicinesList.map {
                    if (it.id == medicineStatusUpdateRequest.medicationId) it.copy(
                        status = Status.fromString(
                            medicineStatusUpdateRequest.status
                        ),

                        ) else it
                }
            println("status changed")
            println("medicinesList: ${MockDataManager.medicinesList}")
            return DataState.Success(Any())
        }
        return DataState.Error(reason = listOf("Medicine not found"), code = 0)
    }

    override suspend fun getMedicineById(medicineId: Int): DataState<Medicine> =
        // medicineRemoteDataSource.getMedicineById(medicineId)
        DataState.Success(
            MockDataManager.medicinesList.find { it.id == medicineId } ?: MockDataManager.medicinesList[0]
        )
}
