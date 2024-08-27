package com.evapharma.medicinereminder

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.evapharma.medicinereminder.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private var emptyView: LinearLayout? = null
    private var navHostFragment: FragmentContainerView? = null
    private var loadingSpinnerView: ProgressBar? = null




    // Declare the launcher at the top
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
        } else {
            // Inform user that your app will not show notifications.
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emptyView = binding.emptyState.root
        navHostFragment = binding.navHostFragment
        loadingSpinnerView = binding.loadingSpinner

        // Check and request notification permission for Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermission()
        }
    }

    // Function to request notification permission
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestNotificationPermission() {
        if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    fun showLoadingSpinner() {
        emptyView?.visibility = View.GONE
        navHostFragment?.visibility = View.GONE
        loadingSpinnerView?.visibility = View.VISIBLE
    }

    fun showEmptyView(text: String = getString(R.string.no_medicines_found)) {
        binding.emptyState.titleText.text = text
        emptyView?.visibility = View.VISIBLE
        navHostFragment?.visibility = View.GONE
        loadingSpinnerView?.visibility = View.GONE
    }

    fun showMainContent() {
        emptyView?.visibility = View.GONE
        navHostFragment?.visibility = View.VISIBLE
        loadingSpinnerView?.visibility = View.GONE
    }

    fun setTryAgainListener(listener: () -> Unit) {
        binding.emptyState.btnText.setOnClickListener {
            listener()
        }
    }





}