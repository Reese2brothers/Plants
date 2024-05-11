package com.tragulon.plants.screens.herbs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tragulon.plants.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHA(navController: NavController){
    val listHA = listOf("Аир обыкновенный")
    val listImageHA = listOf(R.drawable.air)
    var searchText by rememberSaveable { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text("Поиск", color = colorResource(id = R.color.statusBarColor), fontSize = 16.sp)  },
            textStyle = TextStyle(color = colorResource(id = R.color.statusBarColor), fontSize = 24.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.green),
                unfocusedBorderColor = colorResource(id = R.color.statusBarColor)
            ),
            leadingIcon = {
                Icon(Icons.Filled.Search, contentDescription = "Иконка поиска", tint = colorResource(id = R.color.statusBarColor))
            },
            trailingIcon = {
                if (searchText.isNotEmpty()) {
                    IconButton(onClick = { searchText = "" }) {
                        Icon(Icons.Filled.Close, contentDescription = "Очистить", tint = colorResource(id = R.color.statusBarColor))
                    }
                }
            }
        )
        LazyColumn(){
            itemsIndexed(listHA.filter { it.contains(searchText, ignoreCase = true) }){index, itemHA ->
                Card (modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(2.dp)
                    .background(Color.Transparent),
                    shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                    border = BorderStroke(1.dp, color = colorResource(id = R.color.statusBarColor)),
                    onClick = { navigateToScreenAirDetails(listHA[index], navController) })
                {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(painter = painterResource(id = listImageHA[index]), contentDescription = "air",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop)
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ){
                            Text(text = listHA[index], modifier = Modifier
                                .fillMaxWidth()
                                .background(color = colorResource(id = R.color.lightStatusBarColor)),
                                fontSize = 34.sp, textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold, color = colorResource(id = R.color.white)
                            )
                        }
                    }

                }
            }
        }
    }
}

private fun navigateToScreenAirDetails(air: String, navController : NavController) {
    when (air) {
        "Аир обыкновенный" -> navController.navigate("ScreenAirDetails")
        // добавьте больше букв и экранов по мере необходимости
        else -> println("Экран для буквы $air не найден")
    }
}