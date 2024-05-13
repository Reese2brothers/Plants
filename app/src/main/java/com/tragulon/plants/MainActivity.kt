package com.tragulon.plants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import androidx.room.Database
import com.tragulon.plants.screens.database.AppDatabase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainplants = listOf(R.drawable.plantone, R.drawable.planttwo,
        R.drawable.plantfour, R.drawable.plantfive, R.drawable.plantthree)
    private lateinit var database : AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = AppDatabase.getDatabase(this)
        setContent {
            ScreenStatusBar(colorResource(id = R.color.statusBarColor))
            val navController = rememberNavController()
            NavGraphNavigate(database,this,mainplants,navController)
        }
    }
}


