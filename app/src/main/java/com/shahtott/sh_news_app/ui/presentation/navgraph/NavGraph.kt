package com.shahtott.sh_news_app.ui.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.shahtott.sh_news_app.ui.presentation.home.HomeScreen
import com.shahtott.sh_news_app.ui.presentation.onboarding.OnBoardingScreen

@Composable
fun NavGraph(startDestination: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Routes.AppStartingNavigation.route,
            startDestination = Routes.onBoardingScreen.route
        ) {
            composable(route = Routes.onBoardingScreen.route) {
                OnBoardingScreen()
            }
        }

        navigation(
            route = Routes.MainNavigation.route,
            startDestination = Routes.NewsNavigation.route
        ) {
            composable(route = Routes.NewsNavigation.route) {
                HomeScreen(navController)
            }
            composable(route = Routes.DetailsScreen.route) {
                //         Det(navController)
                Text(text = "Details")
            }
        }
    }
}