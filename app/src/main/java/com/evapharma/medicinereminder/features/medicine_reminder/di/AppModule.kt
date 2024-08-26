package com.evapharma.medicinereminder.di

import com.evapharma.medicinereminder.features.medicine_reminder.data.repo.NotificationRepoImpl
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MyFirebaseMessagingService
import com.evapharma.medicinereminder.features.medicine_reminder.data.repo.MedicineRepoImpl
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineApiService
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSource
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.MedicineRemoteDataSourceImpl
import com.evapharma.medicinereminder.features.medicine_reminder.data.remote.NotificationApiService
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repo.MedicineRepo
import com.evapharma.medicinereminder.features.medicine_reminder.domain.repo.NotificationRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    // Medicine


    @Binds
    abstract fun bindMedicineRepository(medicineRepoImpl: MedicineRepoImpl): MedicineRepo

    @Binds
    abstract fun bindMedicineRemoteDataSource(medicineRemoteDataSourceImpl: MedicineRemoteDataSourceImpl): MedicineRemoteDataSource


    // Notification


    @Binds
    abstract fun bindNotificationRepository(notificationRepository: NotificationRepoImpl): NotificationRepo


}

@Module
@InstallIn(SingletonComponent::class)
object FireBaseModule {

    @Provides
    @Singleton
    fun provideMyFirebaseMessagingService(): MyFirebaseMessagingService {
        return MyFirebaseMessagingService()
    }
}
