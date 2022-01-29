package uz.mobiler.quran.ui.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.mobiler.quran.ui.pages.HomeScreen
import uz.mobiler.quran.ui.pages.SplashScreen
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
            route = Screen.Home.route
        ){
            HomeScreen()
        }
    }
}