package com.evapharma.medicinereminder.core

import com.evapharma.medicinereminder.core.network.NetworkManager
import javax.inject.Inject

open class BaseRepo {

    @Inject
    lateinit var networkManager: NetworkManager
}