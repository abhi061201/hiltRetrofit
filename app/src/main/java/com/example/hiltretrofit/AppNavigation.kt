package com.example.hiltretrofit

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgs
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hiltretrofit.Screens.DetailScreen
import com.example.hiltretrofit.Screens.HomeScreen
import com.example.hiltretrofit.models.PostList


@Composable
fun AppNavigation() {

    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen"){
        composable("HomeScreen"){
            HomeScreen(
                {
                    navController.navigate("DetailScreen/${it}")
                }
            )
        }
        composable("DetailScreen/{index}", arguments = listOf(
            navArgument("index"){
                type = NavType.IntType
            }
        )){
            var index = it.arguments!!.getInt("index")
            DetailScreen(index)
        }
    }

}