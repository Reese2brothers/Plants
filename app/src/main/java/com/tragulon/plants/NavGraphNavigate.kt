package com.tragulon.plants

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tragulon.plants.screens.FavouriteScreen
import com.tragulon.plants.screens.HerbsScreen
import com.tragulon.plants.screens.MainScreen
import com.tragulon.plants.screens.MushroomsScreen
import com.tragulon.plants.screens.SettingsScreen
import com.tragulon.plants.screens.TreesScreen

@Composable
fun NavGraphNavigate(context : Context, mainplants : List<Int>, navController: NavHostController) {

    NavHost(navController = navController, startDestination = "MainScreen"){
        composable("MainScreen"){
            MainScreen(context, mainplants, navController = navController)
        }
        composable("FavouriteScreen") {
            FavouriteScreen(navController = navController)
        }
        composable("SettingsScreen") {
           SettingsScreen(navController = navController)
        }
        composable("HerbsScreen") {
            HerbsScreen(navController = navController)
        }
        composable("MushroomsScreen") {
            MushroomsScreen(navController = navController)
        }
        composable("TreesScreen") {
            TreesScreen(navController = navController)
        }
    }
}