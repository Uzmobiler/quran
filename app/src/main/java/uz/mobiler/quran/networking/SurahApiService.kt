package uz.mobiler.quran.networking

import retrofit2.Response
import retrofit2.http.GET
import uz.mobiler.quran.models.surah.SurahData

interface SurahApiService {

    @GET("surah")
    suspend fun surah(): Response<SurahData>
}