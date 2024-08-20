import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evapharma.medicinereminder.core.BaseViewModel
import com.evapharma.medicinereminder.features.medicine_reminder.data.model.status
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.GetMedicineListUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineStatusUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.domain.usecases.UpdateMedicineUseCase
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.intents.MedicineListIntent
import com.evapharma.medicinereminder.features.medicine_reminder.presentation.states.MedicineListState

class MedicineListViewModel(
    private val getMedicineListUseCase: GetMedicineListUseCase,
    private val updateMedicineUseCase: UpdateMedicineUseCase,
    private val updateMedicineStatusUseCase: UpdateMedicineStatusUseCase
) : BaseViewModel() {

    private val _medicineListState = MutableLiveData<MedicineListState>()
    val medicineListState: LiveData<MedicineListState> = _medicineListState

    fun handleIntent(intent: MedicineListIntent) {
        when (intent) {
            is MedicineListIntent.LoadMedicineList -> loadMedicineList()
            is MedicineListIntent.UpdateMedicine -> updateMedicine(
                intent.updateMedicine.id,
                intent.updateMedicine.newstatus ,
                intent.updateMedicine.time,
                intent.updateMedicine.durationFrom,
                intent.updateMedicine.durationTo
            )
            is MedicineListIntent.UpdateMedicineStatus -> updateMedicineStatus(
                intent.id,
                intent.newStatus
            )
        }
    }

    private fun updateMedicineStatus(id: Int, newStatus: status) {
        updateMedicineStatusUseCase.invoke(id, newStatus)
    }

    private fun updateMedicine(
        medicineId: Int,
        newStatus: status,
        time: String?,
        durationFrom: String?,
        durationTo: String?
    ) {
        updateMedicineUseCase.invoke(
            medicineId = medicineId,
            newStatus = newStatus,
            time = time,
            durationFrom = durationFrom,
            durationTo = durationTo
        )
    }

    private fun loadMedicineList() {
        _medicineListState.value = MedicineListState.Loading
        try {
            val medicines = getMedicineListUseCase.invoke()
            _medicineListState.value = MedicineListState.Success(medicines)
        } catch (e: Exception) {
            _medicineListState.value = MedicineListState.Error(e.message ?: "Unknown error")
        }
    }
}
