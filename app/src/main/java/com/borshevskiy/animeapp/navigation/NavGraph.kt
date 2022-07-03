package com.borshevskiy.animeapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.borshevskiy.animeapp.presentation.screens.home.HomeScreen
import com.borshevskiy.animeapp.presentation.screens.splash.SplashScreen
import com.borshevskiy.animeapp.presentation.screens.welcome.WelcomeScreen
import com.borshevskiy.animeapp.util.Constants.DETAILS_ARGUMENT_KEY
import com.google.accompanist.pager.ExperimentalPagerApi

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Welcome: Screen("welcome_screen")
    object Home: Screen("home_screen")
    object Details: Screen("details_screen/{heroId}") {
        fun passHeroId(heroId: Int): String {
            return "details_screen/$heroId"
        }
    }
    object Search: Screen("search_screen")
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Details.route,
        arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
            type = NavType.IntType
        })) {

        }
        composable(route = Screen.Search.route) {

        }
    }

}