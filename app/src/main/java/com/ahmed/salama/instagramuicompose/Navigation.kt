package com.ahmed.salama.instagramuicompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ProfileScreen.route) {
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(
                onPostClick = { imageUrl, accountName ->
                    navController.navigate(Screen.ReelScreen.withArgs(imageUrl.toString(), accountName))
                }
            )
        }
        composable(
            route = Screen.ReelScreen.route + "/{imageUrl}/{accountName}",
            arguments = listOf(
                navArgument("imageUrl") {
                    type = NavType.IntType
                    },
                navArgument("accountName") {
                    type = NavType.StringType
                    defaultValue = ""
                }
                )
            ) { entry ->
            val drawableId = entry.arguments?.getInt("imageUrl")
            ReelScreen(
                image = drawableId,
                accountName = entry.arguments?.getString("accountName"),
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}