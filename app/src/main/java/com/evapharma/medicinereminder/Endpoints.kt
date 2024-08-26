package com.evapharma.medicinereminder

object Endpoints {

    //Covid Cases End Points
    const val GET_COVID_CASES = "api/get-current-statistical"

    // Auth End Points
    const val LOGIN = "/api/Auth/Login"

    // Medicine Reminder End Points
    const val MEDICINE_LIST = "/api/medications"
    const val SET_REMINDER = "/api/medications/SetReminder"
    const val UPDATE_STATUS = "/api/medications/UpdateStatus"
    const val MEDICINE = "/api/medications/{id}"


}