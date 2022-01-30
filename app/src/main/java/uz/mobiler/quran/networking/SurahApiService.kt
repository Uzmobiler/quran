package uz.mobiler.quran.networking

import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import uz.mobiler.quran.models.surah.SurahData
import javax.inject.Singleton

@Singleton
interface SurahApiService {
    @GET("surah")
    suspend fun surah(): Response<SurahData>

}