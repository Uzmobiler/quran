package uz.mobiler.quran.ui.screen

sealed class Screen(var route:String) {
    object Splash:Screen(route = "splash_screen")
    object Home:Screen(route = "home_screen")
}