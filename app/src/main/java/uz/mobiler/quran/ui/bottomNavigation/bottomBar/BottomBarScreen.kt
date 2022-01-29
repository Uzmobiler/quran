package uz.mobiler.quran.ui.bottomNavigation.bottomBar

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarScreen(
    var route:String,
    var title:String,
    var icon:ImageVector
){
   object Home:BottomBarScreen(
       route = "home",
       title = "Home",
       icon = Icons.Default.Home
   )
    object Quran:BottomBarScreen(
        route = "quran",
        title = "Quran",
        icon = Icons.Default.Home
    )
    object Prayer:BottomBarScreen(
        route = "prayer",
        title = "Prayer",
        icon = Icons.Default.Home
    )
    object Settings:BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Home
    )
}