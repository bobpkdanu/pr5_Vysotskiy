package com.bignerdranch.android.prak5_vysotskiy.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bignerdranch.android.prak5_vysotskiy.ui.theme.screens.DetailScreen
import com.bignerdranch.android.prak5_vysotskiy.ui.theme.screens.ListScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            ListScreen(
                navController = navController,
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme
            )
        }
        composable(
            route = "details/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailScreen(
                specialtyId = id,
                navController = navController
            )
        }
    }
}