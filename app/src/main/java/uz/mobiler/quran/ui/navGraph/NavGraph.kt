package uz.mobiler.quran.ui.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.mobiler.quran.ui.bottomNavigation.bottomBar.BottomBarScreen
import uz.mobiler.quran.ui.pages.*
import uz.mobiler.quran.ui.screen.Screen

@Composable
fun NavGraph(navController:NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(
            route = Screen.Splash.route
        ){
            SplashScreen(navController = navController)
        }

        composable(
            route = Screen.Menu.route
        ){
            MenuScreen(navController)
        }









//        composable(
//            route = Screen.Home.route
//        ){
//            HomeScreen()
//        }
//
//        composable(
//            route = Screen.Quran.route
//        ){
//            QuranScreen()
//        }
//
//        composable(
//            route = Screen.Prayer.route
//        ){
//            PrayerScreen()
//        }
//
//        composable(
//            route = Screen.Settings.route
//        ){
//            SettingsScreen()
//        }

//        composable(BottomNavItem.Home.screen_route) {
//            HomeScreen()
//        }
//        composable(BottomNavItem.Quran.screen_route) {
//            QuranScreen()
//        }
//        composable(BottomNavItem.Prayer.screen_route) {
//            PrayerScreen()
//        }
//        composable(BottomNavItem.Settings.screen_route) {
//            SettingsScreen()
//        }
    }


}