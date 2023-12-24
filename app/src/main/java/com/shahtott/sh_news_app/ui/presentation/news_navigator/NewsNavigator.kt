package com.shahtott.sh_news_app.ui.presentation.news_navigator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.shahtott.sh_news_app.R
import com.shahtott.sh_news_app.domain.model.Article
import com.shahtott.sh_news_app.ui.presentation.bookmark.BookmarkScreen
import com.shahtott.sh_news_app.ui.presentation.common.BottomNavigationItem
import com.shahtott.sh_news_app.ui.presentation.common.NewsBottomNavigation
import com.shahtott.sh_news_app.ui.presentation.details.DetailsScreen
import com.shahtott.sh_news_app.ui.presentation.home.HomeScreen
import com.shahtott.sh_news_app.ui.presentation.navgraph.Routes
import com.shahtott.sh_news_app.ui.presentation.search.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(R.drawable.ic_home, "Home"),
            BottomNavigationItem(R.drawable.ic_search, "Search"),
            BottomNavigationItem(R.drawable.ic_bookmark, "Bookmark"),
        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    selectedItem = remember(key1 = backStackState) {
        when (backStackState?.destination?.route) {
            Routes.HomeScreen.route -> 0
            Routes.SearchScreen.route -> 1
            Routes.BookmarkScreen.route -> 2
            else -> 0
        }
    }

    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Routes.HomeScreen.route
                || backStackState?.destination?.route == Routes.SearchScreen.route
                || backStackState?.destination?.route == Routes.BookmarkScreen.route
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            //Decide to recompose the bottom bar or not.
            if (isBottomBarVisible) {
                NewsBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { position ->
                        when (position) {
                            0 -> navigateToTap(navController, Routes.HomeScreen.route)
                            1 -> navigateToTap(navController, Routes.SearchScreen.route)
                            2 -> navigateToTap(navController, Routes.BookmarkScreen.route)
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            modifier = Modifier.padding(bottom = bottomPadding),
            navController = navController,
            startDestination = Routes.HomeScreen.route
        ) {
            composable(route = Routes.HomeScreen.route) {
                HomeScreen({ navigateToTap(navController, it) }, {
                    navigateToDetails(navController, it)
                })
            }
            composable(route = Routes.SearchScreen.route) {
                SearchScreen({
                    navigateToDetails(navController, it)
                })
            }
            composable(route = Routes.DetailsScreen.route) {
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
                    ?.let {
                        DetailsScreen(it, { navController.navigateUp() })
                    }
            }
            composable(route = Routes.BookmarkScreen.route) {
                BookmarkScreen({
                    navigateToDetails(navController, it)
                })
            }
        }
    }
}

private fun navigateToTap(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navigateToDetails(
    navController: NavController,
    article: Article
) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Routes.DetailsScreen.route
    )
}