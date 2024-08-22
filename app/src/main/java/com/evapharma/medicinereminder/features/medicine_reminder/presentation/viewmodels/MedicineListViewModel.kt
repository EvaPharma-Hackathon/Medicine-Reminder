import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evapharma.medicinereminder.core.BaseViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.GetMedicineListUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineStatusUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents.MedicineListIntent
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.states.MedicineListState
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

class MedicineListViewModel
    @Inject constructor(
    private val getMedicineListUseCase: GetMedicineListUseCase,
    private val updateMedicineStatusUseCase: UpdateMedicineStatusUseCase
) : BaseViewModel() {

    private val _medicineListState = MutableLiveData<MedicineListState>()
    val medicineListState: LiveData<MedicineListState> = _medicineListState

    fun handleIntent(intent: MedicineListIntent) {
        when (intent) {
            is MedicineListIntent.LoadMedicineList -> loadMedicineList()
            is MedicineListIntent.UpdateMedicineStatus -> updateMedicineStatus(
                intent.id,
                intent.newStatus
            )
        }
    }

    private fun updateMedicineStatus(id: Int, newStatus: status) {
        updateMedicineStatusUseCase.invoke(id, newStatus)
    }


    private fun loadMedicineList() {
        _medicineListState.value = MedicineListState.Loading
        viewModelScope.launch {
            try {
                val medicines = getMedicineListUseCase.invoke()
                if (medicines != null) {
                    _medicineListState.value = MedicineListState.Success(medicines)
                } else {
                    _medicineListState.value = MedicineListState.Error("Failed to load medicines")
                }
            } catch (e: Exception) {
                _medicineListState.value = MedicineListState.Error(e.message ?: "Unknown error")
            }
        }
    }

}


