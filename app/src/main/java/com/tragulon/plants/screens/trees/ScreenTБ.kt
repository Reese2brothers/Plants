package com.tragulon.plants.screens.trees

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import com.tragulon.plants.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTБ(navController: NavController, context : Context){
    val listTБ = listOf("Береза белая", )
    val listImageTБ = listOf(R.drawable.b_bereza, )
    val searchText by rememberSaveable { mutableStateOf("") }
    var filteredList by remember { mutableStateOf(listTБ) }


    LaunchedEffect(searchText) {
        filteredList = listTБ.filter { it.contains(searchText, ignoreCase = true) }
    }

    Column {
        LazyColumn() {
            itemsIndexed(filteredList) { index, itemTБ ->
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
                    onClick = { navigateToScreenБDetails(listTБ[index], navController, context) })
                {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = listImageTБ[index]),
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
                                text = listTБ[index],
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

private fun navigateToScreenБDetails(в: String, navController : NavController, context: Context) {
    when (в) {
        "Береза белая" -> navController.navigate("ScreenBerezaDetails")
        // добавьте больше букв и экранов по мере необходимости
        else -> Toast.makeText(context, "Экран для $в не найден", Toast.LENGTH_SHORT).show()
    }
}