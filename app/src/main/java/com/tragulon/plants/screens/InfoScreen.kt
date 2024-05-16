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
    var expanded1 by remember { mutableStateOf(false) }
    var subExpanded1 by remember { mutableStateOf(false) }
    var subExpanded2 by remember { mutableStateOf(false) }
    var subsub1 by remember { mutableStateOf(false) }
    var subsub2 by remember { mutableStateOf(false) }
    var subsub3 by remember { mutableStateOf(false) }
    var subsub4 by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }

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
                        .clickable { expanded1 = !expanded1 }
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                            textAlign = TextAlign.Start, fontSize = 21.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                if (expanded1) {
                    Column(modifier = Modifier.padding(start = 8.dp)) {
                        Text("- Первичные органические соединения",
                            Modifier
                                .clickable { subExpanded1 = !subExpanded1 }
                                .padding(start = 16.dp),
                            textAlign = TextAlign.Start, fontSize = 18.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                        if(subExpanded1){
                            Column(
                                modifier = Modifier.padding(start = 32.dp)
                            ) {
                                Text("- Полисахариды", Modifier.clickable { subsub1 = !subsub1 },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub1){
                                   Text(text = stringResource(id = R.string.polisaharidi), Modifier.padding(start = 16.dp, end = 8.dp),
                                       textAlign = TextAlign.Start, fontSize = 12.sp,
                                       fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Гомополисахариды", Modifier.clickable { subsub2 = !subsub2 },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub2){
                                    Text(text = stringResource(id = R.string.gomopolisaharidi), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Гетерополисахариды", Modifier.clickable { subsub3 = !subsub3 },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub3){
                                    Text(text = stringResource(id = R.string.geteropolisaharidi), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                                Text("- Белки", Modifier.clickable { subsub4 = !subsub4 },
                                    textAlign = TextAlign.Start, fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                if(subsub4){
                                    Text(text = stringResource(id = R.string.belki), Modifier.padding(start = 16.dp, end = 8.dp),
                                        textAlign = TextAlign.Start, fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                                }
                            }
                        }
                        Text("- Вторичные органические соединения",
                            Modifier
                                .clickable { subExpanded2 = !subExpanded2 }
                                .padding(start = 16.dp, end = 8.dp),
                            textAlign = TextAlign.Start, fontSize = 18.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                        if(subExpanded2){
                            Column(
                                modifier = Modifier.padding(start = 32.dp)
                            ) {
                                Text("- Гликозиды", Modifier)
                                Text("- Дубильные вещества(танины)", Modifier)
                                Text("- Алкалоиды", Modifier)
                                Text("- Эфирные масла", Modifier)
                                Text("- Витамины", Modifier)
                                Text("- Энзимы (ферменты)", Modifier)
                                Text("- Фитонциды", Modifier)
                                Text("- Микроэлементы", Modifier)
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
