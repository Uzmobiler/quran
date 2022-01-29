package uz.mobiler.quran.models.surah

data class Data(
    val name: Name,
    val number: Int,
    val numberOfVerses: Int,
    val revelation: Revelation,
    val sequence: Int,
    val tafsir: Tafsir
)