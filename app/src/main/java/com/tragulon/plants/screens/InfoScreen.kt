package com.tragulon.plants.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.tragulon.plants.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun InfoScreen() {
    var expanded1 = rememberSaveable { mutableStateOf(false) }
    var subExpanded1 = rememberSaveable { mutableStateOf(false) }
    var subExpanded2 = rememberSaveable { mutableStateOf(false) }
    var subsub1 = rememberSaveable { mutableStateOf(false) }
    var subsub2 = rememberSaveable { mutableStateOf(false) }
    var subsub3 = rememberSaveable { mutableStateOf(false) }
    var subsub4 = rememberSaveable { mutableStateOf(false) }
    var subsub5 = rememberSaveable { mutableStateOf(false) }
    var subsub6 = rememberSaveable { mutableStateOf(false) }
    var subsub7 = rememberSaveable { mutableStateOf(false) }
    var subsub8 = rememberSaveable { mutableStateOf(false) }
    var subsub9 = rememberSaveable { mutableStateOf(false) }
    var subsub10 = rememberSaveable { mutableStateOf(false) }
    var subsub11 = rememberSaveable { mutableStateOf(false) }
    var subsub12 = rememberSaveable { mutableStateOf(false) }
    var expanded2 by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(2.dp)
                .background(Color.Transparent),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            border = BorderStroke(1.dp, color = colorResource(id = R.color.statusBarColor))
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(bottom = 8.dp)
            ) {
                Text("Значение растений для синтеза биологически активных веществ",
                    Modifier
                        .clickable { expanded1.value = !expanded1.value }
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                            textAlign = TextAlign.Start, fontSize = 21.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                if (expanded1.value) {
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        Text("- Первичные органические соединения",
                            Modifier
                                .clickable { subExpanded1.value = !subExpanded1.value }
                                .padding(start = 16.dp),
                            textAlign = TextAlign.Start, fontSize = 18.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                        if(subExpanded1.value){
                            Column(
                                modifier = Modifier.padding(start = 32.dp)
                            ) {
                                Text("- Полисахариды", Modifier.clickable { subsub1.value = !subsub1.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub1.value){
                                   Text(text = stringResource(id = R.string.polisaharidi), Modifier.padding(start = 16.dp, end = 8.dp),
                                       textAlign = TextAlign.Start, fontSize = 12.sp,
                                       fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Гомополисахариды", Modifier.clickable { subsub2.value = !subsub2.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub2.value){
                                    Text(text = stringResource(id = R.string.gomopolisaharidi), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Гетерополисахариды", Modifier.clickable { subsub3.value = !subsub3.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub3.value){
                                    Text(text = stringResource(id = R.string.geteropolisaharidi), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Белки", Modifier.clickable { subsub4.value = !subsub4.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub4.value){
                                    Text(text = stringResource(id = R.string.belki), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                            }
                        }
                        Text("- Вторичные органические соединения",
                            Modifier
                                .clickable { subExpanded2.value = !subExpanded2.value }
                                .padding(start = 16.dp, end = 8.dp),
                            textAlign = TextAlign.Start, fontSize = 18.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                        if(subExpanded2.value){
                            Column(
                                modifier = Modifier.padding(start = 32.dp)
                            ) {
                                Text("- Гликозиды", Modifier.clickable { subsub5.value = !subsub5.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub5.value){
                                    Text(text = stringResource(id = R.string.glikozidi), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Дубильные вещества(танины)", Modifier.clickable { subsub6.value = !subsub6.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                 if(subsub6.value){
                                    Text(text = stringResource(id = R.string.dubilnie), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Алкалоиды", Modifier.clickable { subsub7.value = !subsub7.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                 if(subsub7.value){
                                    Text(text = stringResource(id = R.string.alkaloidi), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Эфирные масла", Modifier.clickable { subsub8.value = !subsub8.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                 if(subsub8.value){
                                    Text(text = stringResource(id = R.string.efirnie_masla), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Витамины", Modifier.clickable { subsub9.value = !subsub9.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                 if(subsub9.value){
                                    Text(text = stringResource(id = R.string.vitamini), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Энзимы (ферменты)", Modifier.clickable { subsub10.value = !subsub10.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                 if(subsub10.value){
                                    Text(text = "sub5", Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Фитонциды", Modifier.clickable { subsub11.value = !subsub11.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                 if(subsub11.value){
                                    Text(text = "sub5", Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Микроэлементы", Modifier.clickable { subsub12.value = !subsub12.value },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                 if(subsub12.value){
                                    Text(text = "sub5", Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                            }
                        }
                    }
                }
            }
        }




//        Text("Строка 2", Modifier.clickable { expanded2 = !expanded2 }.padding(top = 8.dp, start = 8.dp))
//        if (expanded2) {
//            Column(
//                modifier = Modifier.padding(top = 8.dp, start = 16.dp)
//            ) {
//                Text("Подстрока 1", Modifier.clickable { expanded2 = false })
//                Text("Подстрока 2", Modifier.clickable { expanded2 = false })
//                Text("Подстрока 3", Modifier.clickable { expanded2 = false })
//            }
//        }
    }
}
