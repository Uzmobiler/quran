package uz.mobiler.quran.vm

import uz.mobiler.quran.models.surah.SurahData

sealed class SurahResource {
    object Loading : SurahResource()
    data class Success(val surahData: SurahData?) : SurahResource()
    data class Error(val message: String) : SurahResource()
}