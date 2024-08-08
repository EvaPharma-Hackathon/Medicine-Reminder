package com.evapharma.medicinereminder.core.dialogs

import android.content.Context
import com.evapharma.medicinereminder.core.BaseDialog
import com.evapharma.medicinereminder.databinding.ErrorDialogLayoutBinding

class ErrorDialog(context: Context) : BaseDialog<ErrorDialogLayoutBinding>(context) {
    override fun initBinding(): ErrorDialogLayoutBinding {
        return ErrorDialogLayoutBinding.inflate(layoutInflater)
    }

    override fun onDialogCreated() {
        binding.btnOK.setOnClickListener {
            dismiss()
        }
    }
}