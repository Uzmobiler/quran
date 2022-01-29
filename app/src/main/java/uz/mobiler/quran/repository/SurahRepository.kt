package uz.mobiler.quran.repository

import kotlinx.coroutines.flow.flow
import uz.mobiler.quran.networking.SurahApiService
import javax.inject.Inject

class SurahRepository @Inject constructor(private val surahApiService: SurahApiService) {

    suspend fun surah() = flow { emit(surahApiService.surah()) }
}