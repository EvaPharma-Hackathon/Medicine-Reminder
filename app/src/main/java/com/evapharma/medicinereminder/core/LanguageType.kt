package com.evapharma.medicinereminder.core

import androidx.annotation.StringDef
import com.evapharma.medicinereminder.core.LanguageType.Companion.ARABIC
import com.evapharma.medicinereminder.core.LanguageType.Companion.ENGLISH


@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
@StringDef(ENGLISH, ARABIC)
annotation class LanguageType {

    companion object {
        const val ENGLISH = "en"
        const val ARABIC = "ar"
    }
}