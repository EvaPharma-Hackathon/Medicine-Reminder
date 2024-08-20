package com.evapharma.medicinereminder.features.medicine_reminder.data.source.remote

import com.evapharma.medicinereminder.features.medicine_reminder.data.model.Medicine
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.MedicineUpdateRequest
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface MedicineApiService {

    @GET("medicines")
    suspend fun getMedicineList(): Response<List<Medicine>>

    @PUT("medicines/{id}")
    suspend fun updateMedicine(
        @Path("id") medicineId: Int,
        @Body newStatus: MedicineUpdateRequest
    ): Response<Medicine>

    @PUT("medicines/{id}")
    suspend fun updateStatus(
        @Path("id") medicineId: Int,
        @Body request: status
    ): Response<Medicine>
}

