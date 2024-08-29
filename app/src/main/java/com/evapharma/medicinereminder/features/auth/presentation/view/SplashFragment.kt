package com.evapharma.medicinereminder.features.auth.presentation.view

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.evapharma.medicinereminder.MainActivity
import com.evapharma.medicinereminder.core.BaseFragment
import com.evapharma.medicinereminder.databinding.FragmentSplashBinding
import com.evapharma.medicinereminder.features.auth.data.model.LoginRequest
import com.evapharma.medicinereminder.features.auth.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, AuthViewModel>() {
    override fun initBinding(): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initViewModel() {
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
    }

    override fun onFragmentCreated() {

        (activity as? MainActivity)?.setTryAgainListener {
            // Trigger login process
            viewModel.login(
                LoginRequest(
                    deviceToken = "deviceToken",
                    os = "android",
                    phoneNumber = "123"
                )
            )
        }


        // Trigger login process
        viewModel.login(
            LoginRequest(
                deviceToken = "deviceToken",
                os = "android",
                phoneNumber = "123"
            )
        )


        // Observe login state
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loginState.collectLatest { state ->
                if (state.isSuccess) {
                    val action =
                        SplashFragmentDirections.actionSplashFragmentToMedicineListFragment()
                    findNavController().navigate(action)
                } else if (state.isLoading) {
                    (activity as? MainActivity)?.showLoadingSpinner()

                } else {
                    (activity as? MainActivity)?.showErrorView()
                }

            }
        }

    }


}
