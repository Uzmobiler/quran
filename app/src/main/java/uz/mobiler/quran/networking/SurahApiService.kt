package uz.mobiler.quran.networking

import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import uz.mobiler.quran.models.surah.SurahData
import uz.mobiler.quran.models.surah.surah_info.SurahInfoData
import javax.inject.Singleton

@Singleton
interface SurahApiService {
    @GET("surah")
    suspend fun surah(): Response<SurahData>

    @GET("surah/{id}")
    suspend fun surahInfo(@Path("id") id: Int): Response<SurahInfoData>


}