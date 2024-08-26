package com.evapharma.medicinereminder

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emptyView = binding.emptyState.root
        navHostFragment = binding.navHostFragment
        loadingSpinnerView = binding.loadingSpinner
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