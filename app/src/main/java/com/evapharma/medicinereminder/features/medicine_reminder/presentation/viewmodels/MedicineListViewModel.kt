package com.evapharma.medicinereminder.features.medicine_reminder.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evapharma.medicinereminder.features.medicine_reminder.data.repository.MedicineRepository
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.states.MedicineListState
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents.MedicineListIntent
import kotlinx.coroutines.launch

class MedicineListViewModel(private val repository: MedicineRepository) : ViewModel() {

    private val _medicineListState = MutableLiveData<MedicineListState>()
    val medicineListState: LiveData<MedicineListState> get() = _medicineListState

    fun handleIntent(intent: MedicineListIntent) {
        when (intent) {
            is MedicineListIntent.LoadMedicineList -> {
                loadMedicineList()
            }
        }
    }

    private fun loadMedicineList() {
        viewModelScope.launch {
            try {
                _medicineListState.value = MedicineListState.Loading
                val medicineList = repository.getMedicineList()
                _medicineListState.value = MedicineListState.Success(medicineList)
            } catch (e: Exception) {
                _medicineListState.value = MedicineListState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}
