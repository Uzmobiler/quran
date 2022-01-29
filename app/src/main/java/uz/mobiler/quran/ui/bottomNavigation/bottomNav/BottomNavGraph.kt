package uz.mobiler.quran.ui.bottomNavigation.bottomNav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.mobiler.quran.ui.bottomNavigation.bottomBar.BottomBarScreen
import uz.mobiler.quran.ui.pages.*

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Quran.route){
            QuranScreen()
        }
        composable(route = BottomBarScreen.Prayer.route){
            PrayerScreen()
        }
        composable(route = BottomBarScreen.Settings.route){
            SettingsScreen()
        }
    }
}