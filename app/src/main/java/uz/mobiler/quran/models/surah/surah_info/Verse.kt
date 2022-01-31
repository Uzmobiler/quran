package uz.mobiler.quran.models.surah.surah_info

data class Verse(
    val audio: Audio,
    val meta: Meta,
    val number: Number,
    val tafsir: TafsirX,
    val text: Text,
    val translation: TranslationX
)