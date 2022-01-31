package uz.mobiler.quran.models.surah.surah_info

data class Data(
    val name: Name,
    val number: Int,
    val numberOfVerses: Int,
    val preBismillah: Any,
    val revelation: Revelation,
    val sequence: Int,
    val tafsir: Tafsir,
    val verses: List<Verse>
)