package com.evapharma.medicinereminder.di

import com.evapharma.medicinereminder.features.medicine_reminder.data.repo.MedicineRepoImpl
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSource
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSourceImpl
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repo.MedicineRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    // Medicine


    @Binds
    abstract fun bindMedicineRepository(medicineRepoImpl: MedicineRepoImpl): MedicineRepo

    @Binds
    abstract fun bindMedicineRemoteDataSource(medicineRemoteDataSourceImpl: MedicineRemoteDataSourceImpl): MedicineRemoteDataSource


}

