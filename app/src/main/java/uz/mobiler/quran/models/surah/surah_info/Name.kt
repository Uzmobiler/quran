package uz.mobiler.quran.models.surah.surah_info

data class Name(
    val long: String,
    val short: String,
    val translation: Translation,
    val transliteration: Transliteration
)