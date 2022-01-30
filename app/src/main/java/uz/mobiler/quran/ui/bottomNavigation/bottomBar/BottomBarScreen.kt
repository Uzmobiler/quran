package uz.mobiler.quran.ui.bottomNavigation.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import uz.mobiler.quran.R


sealed class BottomBarScreen(
    var route:String,
    var title:String,
    var icon:Int
){

   object Home:BottomBarScreen(
       route = "home",
       title = "Home",
       icon = R.drawable.ic_books
   )
    object Quran:BottomBarScreen(
        route = "quran",
        title = "Quran",
        icon = R.drawable.ic_quran
    )
    object Prayer:BottomBarScreen(
        route = "prayer",
        title = "Prayer",
        icon = R.drawable.ic_prayer
    )
    object Settings:BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = R.drawable.ic_settings
    )
}