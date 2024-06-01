package com.tragulon.plants.screens.herbs

import android.content.Context
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tragulon.plants.R
import kotlinx.coroutines.launch
import okhttp3.internal.filterList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHA(navController: NavController, context : Context){
    val listHA = listOf("Аир обыкновенный", "Алтей лекарственный", "Анис обыкновенный")
    val listImageHA = listOf(R.drawable.air, R.drawable.althea, R.drawable.a_anis)
    val searchText by rememberSaveable { mutableStateOf("") }
    var filteredList by remember { mutableStateOf(listHA) }


    LaunchedEffect(searchText) {
        filteredList = listHA.filter { it.contains(searchText, ignoreCase = true) }
    }

    Column {
            LazyColumn() {
                itemsIndexed(filteredList) { index, itemHA ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(2.dp)
                        .background(Color.Transparent),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        border = BorderStroke(
                            1.dp,
                            color = colorResource(id = R.color.statusBarColor)
                        ),
                        onClick = { navigateToScreenADetails(listHA[index], navController, context) })
                    {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = listImageHA[index]),
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
                                    text = listHA[index],
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(color = colorResource(id = R.color.lightStatusBarColor)),
                                    fontSize = 24.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.white)
                                )
                            }
                        }
                    }
                }
            }
    }
}

private fun navigateToScreenADetails(a: String, navController : NavController, context: Context) {
    when (a) {
        "Аир обыкновенный" -> navController.navigate("ScreenAirDetails")
        "Алтей лекарственный" -> navController.navigate("ScreenAltheaDetails")
        "Анис обыкновенный" -> navController.navigate("ScreenAnisDetails")
        // добавьте больше букв и экранов по мере необходимости
        else -> Toast.makeText(context, "Экран для $a не найден", Toast.LENGTH_SHORT).show()
    }
}