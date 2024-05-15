package com.tragulon.plants

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tragulon.plants.screens.EditScreen
import com.tragulon.plants.screens.FavouriteScreen
import com.tragulon.plants.screens.HerbsScreen
import com.tragulon.plants.screens.InfoScreen
import com.tragulon.plants.screens.MainScreen
import com.tragulon.plants.screens.MushroomsScreen
import com.tragulon.plants.screens.RecepiesDetailsScreen
import com.tragulon.plants.screens.RecepiesScreen
import com.tragulon.plants.screens.TreesScreen
import com.tragulon.plants.database.AppDatabase
import com.tragulon.plants.screens.InternetScreen
import com.tragulon.plants.screens.NewRecepiesScreen
import com.tragulon.plants.screens.herbs.ScreenHA
import com.tragulon.plants.screens.herbs.ScreenHЩ
import com.tragulon.plants.screens.herbs.screenshadetails.ScreenAirDetails
import com.tragulon.plants.screens.herbs.screenshadetails.ScreenAltheaDetails
import com.tragulon.plants.screens.mushrooms.ScreenMA
import com.tragulon.plants.screens.trees.ScreenTA

@Composable
fun NavGraphNavigate(database: AppDatabase, context : Context, mainplants : List<Int>, navController: NavHostController) {

    NavHost(navController = navController, startDestination = "MainScreen"){
        composable("MainScreen"){
            MainScreen(context, mainplants, navController = navController)
        }
        composable("FavouriteScreen") {
            FavouriteScreen(navController = navController)
        }
        composable("InternetScreen") {
            InternetScreen(navController = navController)
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
        composable("EditScreen") {
            EditScreen(mainplants)
        }
        composable("InfoScreen") {
            InfoScreen(navController = navController)
        }
        composable("RecepiesScreen") {
            RecepiesScreen(navController = navController)
        }
        composable("NewRecepiesScreen") {
            NewRecepiesScreen(navController = navController)
        }
        composable("RecepiesDetailsScreen/{title}/{details}/{id}") { backStackEntry ->
            RecepiesDetailsScreen(backStackEntry, navController = navController)
        }
        composable("ScreenHA") {
            ScreenHA(navController = navController)
        }
        composable("ScreenHЩ") {
            ScreenHЩ(navController = navController)
        }
       composable("ScreenMA") { 
           ScreenMA(navController = navController)
       }
        composable("ScreenTA") {
            ScreenTA(navController = navController)
        }
        composable("ScreenAirDetails") { 
            ScreenAirDetails(navController = navController)
        }
        composable("ScreenAltheaDetails") {
            ScreenAltheaDetails()
        }
    }
}
