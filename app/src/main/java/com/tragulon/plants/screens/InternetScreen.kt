package com.tragulon.plants.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tragulon.plants.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InternetScreen(context : Context) {
    val text = rememberSaveable { mutableStateOf("") }

    Box (modifier = Modifier.fillMaxSize()){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white))
        ) {
            Icon(
               painter = painterResource(id = R.drawable.baseline_language_24),
                contentDescription = "Очистить поле",
                tint = colorResource(id = R.color.statusBarColor),
                modifier = Modifier.size(100.dp).padding(top = 16.dp)
            )
            Text(text = "Используйте интернет, чтобы найти нужную вам информацию по растениям!",  modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(colorResource(id = R.color.white)),
                textAlign = TextAlign.Center, fontSize = 24.sp,
                fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(id = R.color.white),
                        cursorColor = colorResource(id = R.color.statusBarColor),
                        unfocusedIndicatorColor = colorResource(id = R.color.statusBarColor),
                        focusedIndicatorColor = colorResource(id = R.color.statusBarColor),
                        textColor = colorResource(id = R.color.statusBarColor)
                    ),
                    value = text.value,
                    onValueChange = { newValue -> text.value = newValue
                    },
                    modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(top = 100.dp, start = 8.dp, end = 8.dp),
                    textStyle = TextStyle(fontSize = 24.sp),
                    label = {
                        Text(text = "начните свой поиск...", color = colorResource(id = R.color.orange),
                            modifier = Modifier.padding(start = 16.dp))
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = colorResource(id = R.color.statusBarColor),
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { text.value = "" }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = "Clear",
                                tint = colorResource(id = R.color.statusBarColor),
                            )
                        }
                    }
                )
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(
                        horizontalAlignment = Alignment.End,
                    ) {
                        IconButton(onClick = {
                            val url = "https://www.google.com/search?q=${text.value}"
                            if (url.isNotBlank()) {
                                try {
                                    val intent = Intent(Intent.ACTION_VIEW)
                                    intent.data = Uri.parse(url)
                                    context.startActivity(intent)
                                } catch (e: Exception) {
                                    Toast.makeText(context, "Неверный URL", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }, modifier = Modifier.size(60.dp).padding(top = 8.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.websearch),
                                contentDescription = "Search",
                                tint = colorResource(id = R.color.statusBarColor),
                                modifier = Modifier.size(60.dp).padding(end = 16.dp, top = 8.dp)
                            )
                        }
                        Text(text = "Поиск...",  modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp, end = 16.dp)
                            .background(colorResource(id = R.color.white)),
                            textAlign = TextAlign.End, fontSize = 12.sp,
                            fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                    }
                }
            }
        }
    }
}