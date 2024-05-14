package com.tragulon.plants.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tragulon.plants.R
import com.tragulon.plants.viewmodels.FavouriteViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController: NavController) {
    val viewModel: FavouriteViewModel = hiltViewModel()
    val favouriteItems by viewModel.favourites.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Image(painter = painterResource(id = R.drawable.baseline_favorite_red_24), contentDescription = "",
                    modifier = Modifier
                        .padding(start = 100.dp)
                        .size(25.dp))
                Text("Избранное", modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 16.dp),
                    textAlign = TextAlign.Start, fontSize = 30.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
            }
            Divider(color = colorResource(id = R.color.statusBarColor), thickness = 2.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp, top = 2.dp, start = 8.dp, end = 8.dp))
            LazyColumn {
                itemsIndexed(favouriteItems) {index, item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(2.dp)
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.statusBarColor)),
                        onClick = { navController.navigate(item.screenName) }
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = item.imageResId),
                                contentDescription = "",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Column(
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = item.title,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(color = colorResource(id = R.color.lightStatusBarColor)),
                                    fontSize = 24.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.white)
                                )
                            }
                            IconButton(onClick = {
                                scope.launch {
                                    viewModel.removeFromFavourites(item.imageResId, item.title, item.screenName)
                                }
                            }, modifier = Modifier.align(Alignment.TopEnd)) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(34.dp)
                                        .background(colorResource(id = R.color.trWhite), CircleShape)
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_favorite_red_24),
                                        contentDescription = "Remove from favourites",
                                        tint = Color.Red
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}