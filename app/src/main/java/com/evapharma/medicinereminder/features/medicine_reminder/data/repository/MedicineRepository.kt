package com.evapharma.medicinereminder.features.medicine_reminder.data.repository

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status
import com.evapharma.medicinereminder.features.medicine_reminder.data.source.remote.MedicineApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MedicineRepository @Inject constructor(
    private val apiService: MedicineApiService
) {

    fun getMedicineList(): Flow<List<Medicine>> = flow {
        val response = apiService.getMedicineList()
        if (response.isSuccessful) {
            response.body()?.let { emit(it) }
        } else {
        }
    }

    fun updateMedicine(medicineId: Int, newStatus: status, time: String?, durationFrom: String?, durationTo: String?): Flow<Response<Medicine>> = flow {
        val request = MedicineUpdateRequest(
            id = medicineId ,
            newstatus = newStatus,
            time = time,
            durationFrom = durationFrom,
            durationTo = durationTo
        )
        val response = apiService.updateMedicine(medicineId, request)
        emit(response)
    }
    fun updateStatus(medicineId: Int, newStatus: status): Flow<Response<Medicine>> = flow {
        val response = apiService.updateStatus(medicineId, newStatus)
        emit(response)
    }
}
