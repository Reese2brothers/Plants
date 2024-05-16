package com.tragulon.plants.screens

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tragulon.plants.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context : Context, mainplants : List<Int>, navController: NavController){
    val imageResource = rememberSaveable { mutableStateOf(mainplants.random()) }
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(id = imageResource.value), contentDescription = "mainimage",
            modifier = Modifier.fillMaxSize())
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(modifier = Modifier.wrapContentSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .size(width = 70.dp, height = 70.dp)
                                .background(Color.Transparent),
                            shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                            border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                            onClick = {navController.navigate("InternetScreen")}
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = colorResource(id = R.color.white)),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Column (
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ){
                                    Icon(
                                        painter = painterResource(id = R.drawable.earth),
                                        contentDescription = null,
                                        tint = colorResource(id = R.color.statusBarColor),
                                        modifier = Modifier
                                            .padding(top = 8.dp)
                                            .size(30.dp)
                                    )
                                    Text("Интернет", modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center, fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(width = 70.dp, height = 70.dp)
                                .background(Color.Transparent),
                            shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                            border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                            onClick = {navController.navigate("InfoScreen")}
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = colorResource(id = R.color.white)),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Column (
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ){
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_auto_stories_24),
                                        contentDescription = null,
                                        tint = colorResource(id = R.color.statusBarColor),
                                        modifier = Modifier
                                            .padding(top = 8.dp)
                                            .size(30.dp)
                                    )
                                    Text("Справочник", modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center, fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                            }
                        }
                    }
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        Card(
                            modifier = Modifier
                                .size(width = 70.dp, height = 70.dp)
                                .background(Color.Transparent),
                            shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                            border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                            onClick = {navController.navigate("FavouriteScreen")}
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = colorResource(id = R.color.white)),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Column (
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ){
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = null,
                                        tint = colorResource(id = R.color.statusBarColor),
                                        modifier = Modifier
                                            .padding(top = 8.dp)
                                            .size(30.dp)
                                    )
                                    Text("Избранное", modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center, fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                            }
                        }
                        Card(
                            modifier = Modifier
                                .size(width = 70.dp, height = 70.dp)
                                .background(Color.Transparent),
                            shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                            border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                            onClick = {navController.navigate("RecepiesScreen")}
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = colorResource(id = R.color.white)),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Column (
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                ){
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_edit_note_24),
                                        contentDescription = null,
                                        tint = colorResource(id = R.color.statusBarColor),
                                        modifier = Modifier
                                            .padding(top = 3.dp)
                                            .size(35.dp)
                                    )
                                    Text("Рецепты", modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center, fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(width = 70.dp, height = 70.dp)
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(corner = CornerSize(35.dp)),
                        border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                        onClick = {navController.navigate("EditScreen")}
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = colorResource(id = R.color.white)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Column (
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ){
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = null,
                                    tint = colorResource(id = R.color.statusBarColor),
                                    modifier = Modifier
                                        .padding(top = 8.dp)
                                        .size(30.dp)
                                )
                                Text("Записи", modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center, fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                            }
                        }
                    }
                }
                IconButton(onClick = {  (context as Activity).finishAffinity() }) {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = null,
                            tint = colorResource(id = R.color.statusBarColor)
                        )
                        Text("Выход", modifier = Modifier
                            .fillMaxWidth(),
                            textAlign = TextAlign.Center, fontSize = 12.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .size(width = 120.dp, height = 120.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(corner = CornerSize(60.dp)),
                    border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    onClick = {navController.navigate("HerbsScreen")}
                    ) {
                    Column(
                        modifier = Modifier
                            .background(color = colorResource(id = R.color.white))
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(modifier = Modifier
                            .size(80.dp)
                            .padding(top = 8.dp),
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.herbs), contentDescription = "травы")
                        Text("Травы", modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                            textAlign = TextAlign.Center, fontSize = 18.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                    }
                }
                Card(
                    modifier = Modifier
                        .size(width = 120.dp, height = 120.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(corner = CornerSize(60.dp)),
                    border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    onClick = {navController.navigate("MushroomsScreen")}
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = colorResource(id = R.color.white))
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(modifier = Modifier
                            .size(80.dp)
                            .padding(top = 8.dp),
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.gribi), contentDescription = "грибы")
                        Text("Грибы", modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                            textAlign = TextAlign.Center, fontSize = 18.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                    }
                }
                Card(
                    modifier = Modifier
                        .size(width = 120.dp, height = 120.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(corner = CornerSize(60.dp)),
                    border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    onClick = {navController.navigate("TreesScreen")}
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = colorResource(id = R.color.white))
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(modifier = Modifier
                            .size(80.dp)
                            .padding(top = 8.dp),
                            alignment = Alignment.Center,
                            painter = painterResource(id = R.drawable.treeone), contentDescription = "деревья")
                        Text("Деревья", modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                            textAlign = TextAlign.Center, fontSize = 18.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                    }
                }
            }
        }
    }
}