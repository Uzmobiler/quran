package uz.mobiler.quran.ui.screen

sealed class Screen(var route:String) {
    object Splash:Screen("splash_screen")
    object Home:Screen("home_screen")
}