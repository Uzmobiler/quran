package uz.mobiler.quran.ui.pages

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.mobiler.quran.R
import uz.mobiler.quran.vm.SurahViewModel

@Composable
fun MenuScreen(navController: NavHostController) {
    val myViewModel = hiltViewModel<SurahViewModel>()

    Scaffold(bottomBar = { MyBottomNavigation(navController = navController) }) {
        navController.navigate(BottomNavItem.Home.screen_route)

        //
    }
}
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Quran.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Quran.screen_route) {
            QuranScreen()
        }
        composable(BottomNavItem.Prayer.screen_route) {
            PrayerScreen()
        }
        composable(BottomNavItem.Settings.screen_route) {
            SettingsScreen()
        }
    }
}
sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_baseline_home_24,"home_screen")
    object Quran: BottomNavItem("My Network",R.drawable.ic_baseline_home_24,"quran_screen")
    object Prayer: BottomNavItem("Post",R.drawable.ic_baseline_home_24,"prayer_screen")
    object Settings: BottomNavItem("Notification",R.drawable.ic_baseline_home_24,"settings_screen")
}

@Composable
fun MyBottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Quran,
        BottomNavItem.Prayer,
        BottomNavItem.Settings
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreView() {
    MenuScreen(rememberNavController())
}