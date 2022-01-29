package uz.mobiler.quran.models.surah

data class Name(
    val long: String,
    val short: String,
    val translation: Translation,
    val transliteration: Transliteration
)