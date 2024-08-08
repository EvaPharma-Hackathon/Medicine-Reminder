package com.evapharma.medicinereminder.core.dialogs

import android.content.Context
import com.evapharma.medicinereminder.core.BaseDialog
import com.evapharma.medicinereminder.databinding.DialogSessionExpiredBinding

class SessionExpiredDialog(context: Context, private val onGoToLogin: (() -> Unit)) :
    BaseDialog<DialogSessionExpiredBinding>(context) {

    override fun initBinding(): DialogSessionExpiredBinding {
        return DialogSessionExpiredBinding.inflate(layoutInflater)
    }

    override fun onDialogCreated() {
        initUI()
    }

    private fun initUI() {
        binding.btnTakeMeToLogin.setOnClickListener {
            onGoToLogin.invoke()
            dismiss()
        }

        binding.btnContinueAsGuest.setOnClickListener {
            dismiss()
        }
    }

}