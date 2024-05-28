package com.tragulon.plants.screens

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tragulon.plants.R
import com.tragulon.plants.viewmodels.EditViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(mainplants : List<Int>) {
    val saveText = rememberSaveable { mutableStateOf("сохранить") }
    val imageResource = rememberSaveable { mutableStateOf(mainplants.random()) }
    val imageSave = rememberSaveable { mutableStateOf(R.drawable.baseline_done_red) }
    val saveTextColor = rememberSaveable { mutableStateOf(R.color.red) }
    val viewModel: EditViewModel = hiltViewModel()
    val currentText = rememberSaveable { mutableStateOf("") }
    var showIdDialog = remember { mutableStateOf(false) }

    val context = LocalContext.current
    val speechIntent2 = remember {
        Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.packageName)
        }
    }
    val launcher2 = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (matches != null && matches.isNotEmpty()) {
                currentText.value += " " + matches[0]
            }
        }
    }

    LaunchedEffect(key1 = viewModel) {
        viewModel.loadInitialData(currentText)
    }

    Box (
    modifier = Modifier.fillMaxSize()
){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(2.dp, color = colorResource(id = R.color.statusBarColor)),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        TextField(
            colors = TextFieldDefaults.textFieldColors(
                containerColor = colorResource(id = R.color.white),
                cursorColor = colorResource(id = R.color.statusBarColor),
                unfocusedIndicatorColor = colorResource(id = R.color.black),
                focusedIndicatorColor = colorResource(id = R.color.statusBarColor),
                textColor = colorResource(id = R.color.statusBarColor)
            ),
            value = currentText.value, onValueChange = { newValue ->
               currentText.value = newValue
                viewModel.addToEditEntity(newValue)
                imageSave.value = R.drawable.baseline_done_red
                saveTextColor.value = R.color.red
            },
            keyboardActions = KeyboardActions(onDone = {
                viewModel.addToEditEntity(currentText.value)
            }),
            modifier = Modifier.fillMaxSize(),
            textStyle = TextStyle(fontSize = 20.sp),
            label = {
                Image(
                    painter = painterResource(id = imageResource.value),
                    contentDescription = "Background",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.2f),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Пишите здесь...", color = colorResource(id = R.color.orange))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(id = R.drawable.baseline_mic_24), contentDescription = "mic",
                            Modifier.padding(end = 8.dp, bottom = 8.dp).clickable { launcher2.launch(speechIntent2) })
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            IconButton(onClick = { viewModel.addToEditEntity(currentText.value)
                                imageSave.value = R.drawable.baseline_done_green
                                saveText.value = "сохранено"
                                saveTextColor.value = R.color.statusBarColor}) { Image(painter = painterResource(id = imageSave.value), contentDescription = "save",
                                    modifier = Modifier.size(20.dp)) }
                            Text(text = saveText.value, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = colorResource(id = saveTextColor.value))
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            IconButton(onClick = { showIdDialog.value = true }) {
                                Icon(
                                    Icons.Default.Clear,
                                    contentDescription = "Очистить поле",
                                    tint = colorResource(id = R.color.statusBarColor),
                                )
                            }
                            Text(text = "очистить", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
                            if (showIdDialog.value) {
                                AlertDialog(
                                    onDismissRequest = {
                                        showIdDialog.value = false
                                    },
                                    title = { Text("Подтверждение", color = colorResource(id = R.color.statusBarColor)) },
                                    text = { Text("Вы действительно хотите удалить весь текст?",
                                        color = colorResource(id = R.color.statusBarColor)) },
                                    confirmButton = {
                                        Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.statusBarColor)),
                                            onClick = {
                                                currentText.value = ""
                                                viewModel.deleteAll()
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
        )
    }
}
}
