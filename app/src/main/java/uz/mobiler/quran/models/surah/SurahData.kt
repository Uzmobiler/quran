package uz.mobiler.quran.models.surah

data class SurahData(
    val code: Int,
    val `data`: List<Data>,
    val message: String,
    val status: String
)