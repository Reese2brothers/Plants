package com.tragulon.plants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    val mainplants = listOf(R.drawable.plantone, R.drawable.planttwo,
        R.drawable.plantfour, R.drawable.plantfive, R.drawable.plantthree)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenStatusBar(colorResource(id = R.color.statusBarColor))
            val navController = rememberNavController()
            NavGraphNavigate(this,mainplants,navController)
        }
    }
}


