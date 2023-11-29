package com.shahtott.sh_news_app.ui.presentation.navgraph

sealed class Routes(
    val route: String
) {
    object onBoardingScreen : Routes(route = "onBoardingScreen")
    object HomeScreen : Routes(route = "homeScreen")
    object SearchScreen : Routes(route = "searchScreen")
    object DetailsScreen : Routes(route = "detailsScreen")
    object AppStartingNavigation : Routes(route = "appStartingNavigation")
    object NewsNavigation : Routes(route = "newsNavigation")
    object NewsNavigationScreen : Routes(route = "newsNavigationScreen")
}
