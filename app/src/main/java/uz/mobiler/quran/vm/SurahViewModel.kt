package uz.mobiler.quran.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.mobiler.quran.models.surah.SurahData
import uz.mobiler.quran.repository.SurahRepository
import uz.mobiler.quran.utils.NetworkHelper
import javax.inject.Inject

@HiltViewModel
class SurahViewModel @Inject constructor(
    private val surahRepository: SurahRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    fun getSurah(): StateFlow<SurahResource> {
        val stateFlow = MutableStateFlow<SurahResource>(SurahResource.Loading)
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                surahRepository.surah()
                    .collect {
                        if (it.isSuccessful) {
                            stateFlow.emit(SurahResource.Success(it.body()))
                        } else {
                            stateFlow.emit(SurahResource.Error("Error"))
                        }
                    }
            } else {
                stateFlow.emit(SurahResource.Error("Internet not connection"))
            }
        }
        return stateFlow
    }

    fun getSurahInfo(id: Int): StateFlow<SurahInfoResource> {
        val stateFlow = MutableStateFlow<SurahInfoResource>(SurahInfoResource.Loading)
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                surahRepository.surahInfo(id)
                    .collect {
                        if (it.isSuccessful) {
                            stateFlow.emit(SurahInfoResource.Success(it.body()))
                        } else {
                            stateFlow.emit(SurahInfoResource.Error("Error"))
                        }
                    }
            } else {
                stateFlow.emit(SurahInfoResource.Error("Internet not connection"))
            }
        }
        return stateFlow
    }

}