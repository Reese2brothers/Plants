package com.tragulon.plants.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun MushroomsScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Грибы", modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
                textAlign = TextAlign.Center, fontSize = 24.sp,
                fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
            )
            Divider(color = colorResource(id = R.color.statusBarColor), thickness = 2.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp, top = 4.dp, start = 8.dp, end = 8.dp))
            LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 4.dp)
            ){
                val listCharsM = listOf("А","Б","В","Г","Д","Е","Ж","З","И","К","Л","М","Н","О","П",
                    "Р","С","Т","У","Ф","Х","Ц","Ч","Ш","Щ","Э","Ю","Я")
                items(28){itemM ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(2.dp)
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.statusBarColor)),
                        onClick = { navigateToScreenMushrooms(listCharsM[itemM], navController) }
                    ) {
                        Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ){
                        Text(text = listCharsM[itemM], modifier = Modifier.padding(top = 8.dp, start = 24.dp),
                            textAlign = TextAlign.Start, fontSize = 32.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                        )
                        Image(painter = painterResource(id = R.drawable.fonmushrooms), contentDescription = "fonmushrooms",
                            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                    }

                    }
                }
            }
        }
    }
}

private fun navigateToScreenMushrooms(sM: String, navController : NavController) {
    when (sM) {
        "А" -> navController.navigate("ScreenMA")
        // добавьте больше букв и экранов по мере необходимости
        else -> println("Экран для буквы $sM не найден")
    }
}
