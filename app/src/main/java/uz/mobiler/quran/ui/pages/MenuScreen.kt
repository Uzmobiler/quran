package uz.mobiler.quran.ui.pages

import androidx.compose.foundation.layout.RowScope
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
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.mobiler.quran.R
import uz.mobiler.quran.ui.bottomNavigation.bottomBar.BottomBarScreen
import uz.mobiler.quran.ui.bottomNavigation.bottomNav.BottomNavGraph
import uz.mobiler.quran.ui.theme.BottomItemSelectedColor
import uz.mobiler.quran.ui.theme.TextColorGren
import uz.mobiler.quran.vm.SurahViewModel

@Composable
fun MenuScreen(navController: NavHostController) {

    var navControllerMy   = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navControllerMy)}
    ) {
        BottomNavGraph(navController = navControllerMy)
    }
}


@Composable
fun BottomBar(navController: NavHostController){
    var screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Quran,
        BottomBarScreen.Prayer,
        BottomBarScreen.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination
    BottomNavigation {
        screens.forEach {
            AddItem(screen = it, currentDestination = destination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen:BottomBarScreen,
    currentDestination:NavDestination?,
    navController: NavHostController){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription ="Navigation Icon" )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        }==true,
        unselectedContentColor = TextColorGren,
        selectedContentColor = BottomItemSelectedColor,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
@Composable
@Preview(showBackground = true)
fun HomeScreenPreView() {
    MenuScreen(rememberNavController())
}