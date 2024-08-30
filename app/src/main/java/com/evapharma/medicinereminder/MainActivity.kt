package com.evapharma.medicinereminder

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import com.evapharma.medicinereminder.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private var emptyView: LinearLayout? = null
    private var navHostFragment: FragmentContainerView? = null
    private var loadingSpinnerView: ProgressBar? = null
    private var errorView: View? = null


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
        errorView = binding.errorState.root

        // Check and request notification permission for Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermission()
        }


        // Retrieve the id from the Intent
        val id = intent?.getIntExtra("medicationId", -1) ?: -1

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Create a bundle with the id
        val bundle = Bundle().apply {
            putInt("medicationId", id)
        }

        // Set the nav graph with the bundle, ensuring that the SplashFragment gets the id
        navController.setGraph(R.navigation.nav_graph, bundle)


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
        loadingSpinnerView?.visibility = View.VISIBLE
        errorView?.visibility = View.GONE
        emptyView?.visibility = View.GONE
        navHostFragment?.visibility = View.GONE
    }

    fun showEmptyView(text: String = getString(R.string.no_medicines_found)) {
        binding.emptyState.titleText.text = text

        emptyView?.visibility = View.VISIBLE
        errorView?.visibility = View.GONE
        navHostFragment?.visibility = View.GONE
        loadingSpinnerView?.visibility = View.GONE
    }

    fun showMainContent() {
        navHostFragment?.visibility = View.VISIBLE
        errorView?.visibility = View.GONE
        emptyView?.visibility = View.GONE
        loadingSpinnerView?.visibility = View.GONE
    }

    fun showErrorView(
        title: String = getString(R.string.warning),
        content: String = getString(R.string.warning_desc)
    ) {
        binding.errorState.txtTitle.text = title
        binding.errorState.txtdesc.text = content

        errorView?.visibility = View.VISIBLE
        emptyView?.visibility = View.GONE
        navHostFragment?.visibility = View.GONE
        loadingSpinnerView?.visibility = View.GONE
    }

    fun setTryAgainListener(listener: () -> Unit) {
        binding.emptyState.btnText.setOnClickListener {
            listener()
        }

        binding.errorState.btnOK.setOnClickListener {
            listener()
        }
    }


}