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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import com.tragulon.plants.R
import com.tragulon.plants.viewmodels.FavouriteViewModel
import com.tragulon.plants.viewmodels.RecepiesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecepiesScreen(navController: NavController) {
    val viewModel: RecepiesViewModel = hiltViewModel()
    val recepiesItems by viewModel.recepies.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    var showIdDialog = remember { mutableStateOf(false) }

    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Column(modifier = Modifier.fillMaxWidth()) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Row {
                    Image(painter = painterResource(id = R.drawable.baseline_edit_note_24), contentDescription = "",
                        modifier = Modifier
                            .padding(start = 100.dp)
                            .size(40.dp))
                    Text("Рецепты", modifier = Modifier.padding(top = 4.dp, start = 8.dp),
                        textAlign = TextAlign.Start, fontSize = 26.sp,
                        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                    )
                }
                IconButton(onClick = { navController.navigate("NewRecepiesScreen") },
                    modifier = Modifier.size(50.dp)) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "add",
                        tint = colorResource(id = R.color.statusBarColor),
                        modifier = Modifier.size(45.dp)
                    )
                }
            }
            Divider(color = colorResource(id = R.color.statusBarColor), thickness = 2.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp, top = 2.dp, start = 8.dp, end = 8.dp))
            LazyColumn(){
                itemsIndexed(recepiesItems){index,item->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(start = 2.dp, top = 4.dp, end = 2.dp)
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.statusBarColor)),
                        onClick = { navController.navigate("RecepiesDetailsScreen/${item.title}/${item.details}/${item.id}") }
                    ) {
                        Column(modifier = Modifier.fillMaxSize().background(colorResource(id = R.color.white))) {
                            Row (modifier = Modifier.fillMaxWidth().background(colorResource(id = R.color.statusBarColor)),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically){
                                Text(item.title, modifier = Modifier
                                    .wrapContentHeight()
                                    .weight(1f)
                                    .padding(start = 8.dp),
                                    textAlign = TextAlign.Center, fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold, color = colorResource(id = R.color.white)
                                )
                                IconButton(onClick = { showIdDialog.value = true }) {
                                    Icon(
                                        Icons.Default.Delete,
                                        contentDescription = "delete",
                                        tint = colorResource(id = R.color.white),
                                        modifier = Modifier.size(25.dp)
                                    )
                                }
                            }
                            Text(item.details, modifier = Modifier.fillMaxWidth()
                                .padding(8.dp).background(colorResource(id = R.color.white)),
                                textAlign = TextAlign.Start, fontSize = 16.sp,
                                fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
                            )
                            if (showIdDialog.value) {
                                AlertDialog(
                                    onDismissRequest = {
                                        showIdDialog.value = false
                                    },
                                    title = { Text("Подтверждение", color = colorResource(id = R.color.statusBarColor)) },
                                    text = { Text("Вы уверены, что хотите удалить элемент из списка?",
                                        color = colorResource(id = R.color.statusBarColor)) },
                                    confirmButton = {
                                        Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.statusBarColor)),
                                            onClick = {
                                                    viewModel.deleteText(item.id, item.title, item.details)
                                                showIdDialog.value = false
                                            }) {
                                            Text("Да", color = colorResource(id = R.color.white))
                                        }
                                    },
                                    dismissButton = {
                                        Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.statusBarColor)),
                                            onClick = {
                                                showIdDialog.value = false
                                            }) {
                                            Text("Нет", color = colorResource(id = R.color.white))
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}