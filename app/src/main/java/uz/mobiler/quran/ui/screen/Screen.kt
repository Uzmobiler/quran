package uz.mobiler.quran.ui.screen

sealed class Screen(var route:String) {
    object Splash:Screen(route = "splash_screen")
    object Menu:Screen(route = "menu_screen")
    object Home:Screen(route = "home_screen")
    object Quran:Screen(route = "quran_screen")
    object Prayer:Screen(route = "prayer_screen")
    object Settings:Screen(route = "settings_screen")
}