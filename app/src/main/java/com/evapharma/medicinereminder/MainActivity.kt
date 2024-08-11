package com.evapharma.medicinereminder

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.evapharma.medicinereminder.core.BaseActivity
import com.evapharma.medicinereminder.databinding.ActivityMainBinding
import com.evapharma.medicinereminder.features.covid_cases.presentation.CovidCasesActions
import com.evapharma.medicinereminder.features.covid_cases.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onActivityCreated() {
        viewModel.executeAction(
            CovidCasesActions.GetCovidCases
        )
        handleCovidCasesViewState()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun handleCovidCasesViewState() {
        this.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.viewStates.collect { viewState ->
                    if (viewState.isLoading) {
                        showLoading()
                    }
                    if (viewState.data != null) {
                        hideLoading()
                        viewState.data.let {
                            binding.casesNo.text = it.data?.local_new_cases.toString()
                        }
                    } else {
                        hideLoading()
                    }
                }
            }
        }
    }

}