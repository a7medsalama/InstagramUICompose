package com.ahmed.salama.instagramuicompose

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")
    object ProfileScreen: Screen("profile_screen")
    object ReelScreen: Screen("reel_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}