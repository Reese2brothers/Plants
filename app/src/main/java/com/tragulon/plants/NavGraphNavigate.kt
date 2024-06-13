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
import com.tragulon.plants.screens.herbs.ScreenHБ
import com.tragulon.plants.screens.herbs.ScreenHВ
import com.tragulon.plants.screens.herbs.ScreenHЩ
import com.tragulon.plants.screens.herbs.screenshбdetails.ScreenBarbarisDetails
import com.tragulon.plants.screens.herbs.screenshadetails.ScreenAirDetails
import com.tragulon.plants.screens.herbs.screenshadetails.ScreenAltheaDetails
import com.tragulon.plants.screens.herbs.screenshadetails.ScreenAnisDetails
import com.tragulon.plants.screens.herbs.screenshбdetails.ScreenBeladonnaDetails
import com.tragulon.plants.screens.herbs.screenshвdetails.ScreenVahtaDetails
import com.tragulon.plants.screens.mushrooms.ScreenMA
import com.tragulon.plants.screens.trees.ScreenTA
import com.tragulon.plants.screens.trees.ScreenTБ
import com.tragulon.plants.screens.trees.screenstбdetails.ScreenBerezaDetails

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
            InternetScreen(context)
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
            InfoScreen()
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
            ScreenHA(navController = navController, context)
        }
        composable("ScreenHБ") {
            ScreenHБ(navController = navController, context)
        }
        composable("ScreenHВ") {
            ScreenHВ(navController = navController, context)
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
        composable("ScreenTБ") {
            ScreenTБ(navController = navController, context)
        }
        composable("ScreenAirDetails") { 
            ScreenAirDetails(navController = navController)
        }
        composable("ScreenAltheaDetails") {
            ScreenAltheaDetails()
        }
        composable("ScreenAnisDetails") {
            ScreenAnisDetails()
        }
        composable("ScreenBarbarisDetails") {
            ScreenBarbarisDetails()
        }
        composable("ScreenBeladonnaDetails") {
            ScreenBeladonnaDetails()
        }
        composable("ScreenVahtaDetails") {
            ScreenVahtaDetails()
        }
        composable("ScreenBerezaDetails") {
            ScreenBerezaDetails()
        }
    }
}
