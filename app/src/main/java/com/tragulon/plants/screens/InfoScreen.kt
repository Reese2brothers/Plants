package com.tragulon.plants.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tragulon.plants.R
import okhttp3.internal.checkDuration

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun InfoScreen() {
    var expanded1 = rememberSaveable { mutableStateOf(false) }
    var subExpanded1 = rememberSaveable { mutableStateOf(false) }
    var subExpanded2 = rememberSaveable { mutableStateOf(false) }
    var subExpanded3 = rememberSaveable { mutableStateOf(false) }
    var subsub1 = rememberSaveable { mutableStateOf(false) }
    var subsub2 = rememberSaveable { mutableStateOf(false) }
    var subsub3 = rememberSaveable { mutableStateOf(false) }
    var subsub4 = rememberSaveable { mutableStateOf(false) }
    var subsub5 = rememberSaveable { mutableStateOf(false) }
    var subsub6 = rememberSaveable { mutableStateOf(false) }
    var subsub7 = rememberSaveable { mutableStateOf(false) }
    var subsub8 = rememberSaveable { mutableStateOf(false) }
    var subsub9 = rememberSaveable { mutableStateOf(false) }
    var subsub90 = rememberSaveable { mutableStateOf(false) }
    var subsub10 = rememberSaveable { mutableStateOf(false) }
    var subsub11 = rememberSaveable { mutableStateOf(false) }
    var subsub12 = rememberSaveable { mutableStateOf(false) }
    var subsub13 = rememberSaveable { mutableStateOf(false) }
    var subsub14 = rememberSaveable { mutableStateOf(false) }
    var subsub15 = rememberSaveable { mutableStateOf(false) }
    var subsub16 = rememberSaveable { mutableStateOf(false) }
    var subsub17 = rememberSaveable { mutableStateOf(false) }
    var subsub18 = rememberSaveable { mutableStateOf(false) }
    var subsub19 = rememberSaveable { mutableStateOf(false) }
    var expanded2 = rememberSaveable { mutableStateOf(false) }
    var expanded3 = rememberSaveable { mutableStateOf(false) }
    var expanded4 = rememberSaveable { mutableStateOf(false) }
    var expanded5 = rememberSaveable { mutableStateOf(false) }
    var expanded6 = rememberSaveable { mutableStateOf(false) }

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
                Text(
                    "Значение растений для синтеза биологически активных веществ",
                    Modifier
                        .clickable { expanded1.value = !expanded1.value }
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                    textAlign = TextAlign.Start, fontSize = 21.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                )
                if (expanded1.value) {
//                    AnimatedVisibility(visible = expanded1.value,  enter = expandIn(animationSpec = tween(durationMillis = 1000)),
//                        exit = shrinkOut(animationSpec = tween(durationMillis = 1000))) {
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(
                                "- Первичные органические соединения",
                                Modifier
                                    .clickable { subExpanded1.value = !subExpanded1.value }
                                    .padding(start = 16.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.statusBarColor)
                            )
                            if (subExpanded1.value) {
//                                AnimatedVisibility(visible = subExpanded1.value,  enter = expandIn(animationSpec = tween(durationMillis = 1000)),
//                                    exit = shrinkOut(animationSpec = tween(durationMillis = 1000))) {
                                    Column(
                                        modifier = Modifier.padding(start = 32.dp)
                                    ) {
                                        Text(
                                            "- Полисахариды",
                                            Modifier.clickable { subsub1.value = !subsub1.value },
                                            textAlign = TextAlign.Start,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                        if (subsub1.value) {
//                                            AnimatedVisibility(visible = subsub1.value,
//                                                enter = expandIn(animationSpec = tween(durationMillis = 1000)),
//                                                exit = shrinkOut(animationSpec = tween(durationMillis = 1000))) {
                                                Text(
                                                    text = stringResource(id = R.string.polisaharidi),
                                                    Modifier.padding(start = 16.dp, end = 8.dp)
                                                        //.animateContentSize(animationSpec = TweenSpec(durationMillis = 2000, easing = LinearOutSlowInEasing))
                                                    ,
                                                    textAlign = TextAlign.Start,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = colorResource(id = R.color.statusBarColor)
                                                )
                                           // }
                                        }
                                        Text(
                                            "- Гомополисахариды",
                                            Modifier.clickable { subsub2.value = !subsub2.value },
                                            textAlign = TextAlign.Start,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                        if (subsub2.value) {
                                            Text(
                                                text = stringResource(id = R.string.gomopolisaharidi),
                                                Modifier.padding(start = 16.dp, end = 8.dp),
                                                textAlign = TextAlign.Start,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = colorResource(id = R.color.statusBarColor)
                                            )
                                        }
                                        Text(
                                            "- Гетерополисахариды",
                                            Modifier.clickable { subsub3.value = !subsub3.value },
                                            textAlign = TextAlign.Start,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                        if (subsub3.value) {
                                            Text(
                                                text = stringResource(id = R.string.geteropolisaharidi),
                                                Modifier.padding(start = 16.dp, end = 8.dp),
                                                textAlign = TextAlign.Start,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = colorResource(id = R.color.statusBarColor)
                                            )
                                        }
                                        Text(
                                            "- Белки",
                                            Modifier.clickable { subsub4.value = !subsub4.value },
                                            textAlign = TextAlign.Start,
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                        if (subsub4.value) {
                                            Text(
                                                text = stringResource(id = R.string.belki),
                                                Modifier.padding(start = 16.dp, end = 8.dp),
                                                textAlign = TextAlign.Start,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = colorResource(id = R.color.statusBarColor)
                                            )
                                        }
                                    }
                                //}
                            }
                            Text("- Вторичные органические соединения",
                                Modifier
                                    .clickable { subExpanded2.value = !subExpanded2.value }
                                    .padding(start = 16.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.statusBarColor))
                            if (subExpanded2.value) {
                                Column(
                                    modifier = Modifier.padding(start = 32.dp)
                                ) {
                                    Text(
                                        "- Гликозиды",
                                        Modifier.clickable { subsub5.value = !subsub5.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub5.value) {
                                        Text(
                                            text = stringResource(id = R.string.glikozidi),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                    Text(
                                        "- Дубильные вещества(танины)",
                                        Modifier.clickable { subsub6.value = !subsub6.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub6.value) {
                                        Text(
                                            text = stringResource(id = R.string.dubilnie),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                    Text(
                                        "- Алкалоиды",
                                        Modifier.clickable { subsub7.value = !subsub7.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub7.value) {
                                        Text(
                                            text = stringResource(id = R.string.alkaloidi),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                    Text(
                                        "- Эфирные масла",
                                        Modifier.clickable { subsub8.value = !subsub8.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub8.value) {
                                        Text(
                                            text = stringResource(id = R.string.efirnie_masla),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                    Text(
                                        "- Витамины",
                                        Modifier.clickable { subsub9.value = !subsub9.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub9.value) {
                                        Text(
                                            text = stringResource(id = R.string.vitamini),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                    Text(
                                        "- Витамины(продолжение)",
                                        Modifier.clickable { subsub90.value = !subsub90.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub90.value) {
                                        Text(
                                            text = stringResource(id = R.string.vitamini2),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                    Text(
                                        "- Энзимы (ферменты)",
                                        Modifier.clickable { subsub10.value = !subsub10.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub10.value) {
                                        Text(
                                            text = stringResource(id = R.string.enzimi),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                    Text(
                                        "- Фитонциды",
                                        Modifier.clickable { subsub11.value = !subsub11.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub11.value) {
                                        Text(
                                            text = stringResource(id = R.string.fitoncidi),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                    Text(
                                        "- Микроэлементы",
                                        Modifier.clickable { subsub12.value = !subsub12.value },
                                        textAlign = TextAlign.Start,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(id = R.color.statusBarColor)
                                    )
                                    if (subsub12.value) {
                                        Text(
                                            text = stringResource(id = R.string.microelementi),
                                            Modifier.padding(start = 16.dp, end = 8.dp),
                                            textAlign = TextAlign.Start,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(id = R.color.statusBarColor)
                                        )
                                    }
                                }
                            }
                        }
                    //}
                }
            }
        }
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
                Text(
                    "Фитотерапия и биологические науки",
                    Modifier
                        .clickable { expanded2.value = !expanded2.value }
                        .padding(top = 8.dp, start = 8.dp),
                    textAlign = TextAlign.Start, fontSize = 21.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                )
                if (expanded2.value) {
                    Column(
                        modifier = Modifier.padding(top = 8.dp, start = 48.dp)
                    ) {
                        Text(
                            stringResource(id = R.string.fitoterapia_i_bio_nauki),
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                    }
                }
            }
        }

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
                Text(
                    "Сбор трав",
                    Modifier
                        .clickable { expanded3.value = !expanded3.value }
                        .padding(top = 8.dp, start = 8.dp),
                    textAlign = TextAlign.Start, fontSize = 21.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                )
                if (expanded3.value) {
                    Column(
                        modifier = Modifier.padding(top = 8.dp, start = 48.dp)
                    ) {
                        Text(
                            stringResource(id = R.string.sbor_trav),
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                    }
                }
            }
        }
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
                Text(
                    "Консервирование и стабилизация трав",
                    Modifier
                        .clickable { expanded4.value = !expanded4.value }
                        .padding(top = 8.dp, start = 8.dp),
                    textAlign = TextAlign.Start, fontSize = 21.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                )
                if (expanded4.value) {
                    Column(
                        modifier = Modifier.padding(top = 8.dp, start = 48.dp)
                    ) {
                        Text(
                            stringResource(id = R.string.konservirovanie_i_stabilizacia_trav),
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                    }
                }
            }
        }
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
                Text(
                    "Сушка трав",
                    Modifier
                        .clickable { expanded5.value = !expanded5.value }
                        .padding(top = 8.dp, start = 8.dp),
                    textAlign = TextAlign.Start, fontSize = 21.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                )
                if (expanded5.value) {
                    Column(
                        modifier = Modifier.padding(top = 8.dp, start = 48.dp)
                    ) {
                        Text(
                            stringResource(id = R.string.sushka_trav),
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                    }
                }
            }
        }
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
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    "Подготовка собирателя трав",
                    Modifier
                        .clickable { expanded6.value = !expanded6.value }
                        .padding(top = 8.dp, start = 8.dp),
                    textAlign = TextAlign.Start, fontSize = 21.sp,
                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                )
                if (expanded6.value) {
                    Column(
                        modifier = Modifier.padding(top = 8.dp, start = 48.dp)
                    ) {
                        Text(
                            "- Почки - распознавание и сбор",
                            Modifier.clickable { subsub13.value = !subsub13.value },
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                        if (subsub13.value) {
                            Text(
                                stringResource(id = R.string.pochki),
                                Modifier.padding(start = 16.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.statusBarColor)
                            )
                        }
                        Text(
                            "- Цветки - распознавание и сбор",
                            Modifier.clickable { subsub14.value = !subsub14.value },
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                        if (subsub14.value) {
                            Column(
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(id = R.string.cvetki),
                                    Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor)
                                )
                                Image(painter = painterResource(id = R.drawable.stroeniecvetka), contentDescription = "stroeniecvetka",
                                    Modifier.padding(end = 8.dp))
                                Text("Рис.1  Строение цветка",  Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor))
                                Text(
                                    text = stringResource(id = R.string.cvetki2),
                                    Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor)
                                )
                                Image(painter = painterResource(id = R.drawable.formicvetka), contentDescription = "formicvetka",
                                    Modifier.padding(end = 8.dp))
                                Text("Рис.2  Разновидности цветков по форме",  Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor))
                                Text(
                                    text = stringResource(id = R.string.cvetki3),
                                    Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor)
                                )
                                Image(painter = painterResource(id = R.drawable.vidizaviazy), contentDescription = "vidizaviazy",
                                    Modifier.padding(end = 8.dp))
                                Text("Рис.3  Виды завязи",  Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor))
                                Text(
                                    text = stringResource(id = R.string.cvetki4),
                                    Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor)
                                )
                                Image(painter = painterResource(id = R.drawable.vidisocvetiy), contentDescription = "vidisocvetiy",
                                    Modifier.padding(end = 8.dp))
                                Text("Рис.4  Виды соцветий",  Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor))
                                Text(
                                    text = stringResource(id = R.string.cvetki5),
                                    Modifier.padding(start = 16.dp, end = 8.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.statusBarColor)
                                )
                            }
                        }
                        Text(
                            "- Листья - распознавание и сбор",
                            Modifier.clickable { subsub15.value = !subsub15.value },
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                        if (subsub15.value) {
                            Text(
                                text = "stringResource(id = R.string.alkaloidi)",
                                Modifier.padding(start = 16.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.statusBarColor)
                            )
                        }
                        Text(
                            "- Стебли и побеги - распознавание и сбор",
                            Modifier.clickable { subsub16.value = !subsub16.value },
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                        if (subsub16.value) {
                            Text(
                                text = "stringResource(id = R.string.efirnie_masla)",
                                Modifier.padding(start = 16.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.statusBarColor)
                            )
                        }
                        Text(
                            "- Корни, коренища, клубни и луковицы -   распознавание и сбор",
                            Modifier.clickable { subsub17.value = !subsub17.value },
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                        if (subsub17.value) {
                            Text(
                                text = "stringResource(id = R.string.vitamini)",
                                Modifier.padding(start = 16.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.statusBarColor)
                            )
                        }
                        Text(
                            "- Плоды и семена - распознавание и сбор",
                            Modifier.clickable { subsub18.value = !subsub18.value },
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                        if (subsub18.value) {
                            Text(
                                text = "stringResource(id = R.string.vitamini2)",
                                Modifier.padding(start = 16.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.statusBarColor)
                            )
                        }
                        Text(
                            "- Кора - сбор и сушение",
                            Modifier.clickable { subsub19.value = !subsub19.value },
                            textAlign = TextAlign.Start,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.statusBarColor)
                        )
                        if (subsub19.value) {
                            Text(
                                text = "7777",
                                Modifier.padding(start = 16.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.statusBarColor)
                            )
                        }
                    }
                }
            }
        }
    }
}


