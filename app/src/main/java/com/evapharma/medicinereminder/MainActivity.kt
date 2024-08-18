package com.evapharma.medicinereminder

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.evapharma.medicinereminder.core.BaseActivity
import com.evapharma.medicinereminder.databinding.ActivityMainBinding
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesActions
import com.evapharma.medicinereminder.features.covid_cases.presentation.viewmodels.MainViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.MedicineListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
      //  viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onActivityCreated() {

    /*    binding.retrieveCasesBtn.setOnClickListener {
            Log.e("TAG", "onClick: ")
            viewModel.executeAction(
                CovidCasesActions.GetCovidCases
            )
        }*/

    }



}