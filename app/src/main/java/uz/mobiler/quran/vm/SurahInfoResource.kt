package uz.mobiler.quran.vm

import uz.mobiler.quran.models.surah.SurahData
import uz.mobiler.quran.models.surah.surah_info.SurahInfoData

sealed class SurahInfoResource {
    object Loading : SurahInfoResource()
    data class Success(val surahInfoData: SurahInfoData?) : SurahInfoResource()
    data class Error(val message: String) : SurahInfoResource()
}