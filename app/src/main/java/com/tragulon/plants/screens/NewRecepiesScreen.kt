package com.tragulon.plants.screens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tragulon.plants.R
import com.tragulon.plants.database.RecepiesEntity
import com.tragulon.plants.viewmodels.RecepiesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewRecepiesScreen(navController : NavController) {
    val viewModel: RecepiesViewModel = hiltViewModel()
    val titleText = rememberSaveable { mutableStateOf("") }
    val detailsText = rememberSaveable { mutableStateOf("") }
    val imageSave = rememberSaveable{(mutableStateOf(R.drawable.baseline_save_as_red))}
    val imageMic = rememberSaveable{(mutableStateOf(R.drawable.baseline_mic_24))}
    val context = LocalContext.current
    val speechIntent = remember {
        Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, context.packageName)
        }
    }
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (matches != null && matches.isNotEmpty()) {
                titleText.value += " " + matches[0]
            }
        }
    }
    val launcherDetails = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val matches = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (matches != null && matches.isNotEmpty()) {
                detailsText.value += " " + matches[0]
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.white),
                    cursorColor = colorResource(id = R.color.statusBarColor),
                    unfocusedIndicatorColor = colorResource(id = R.color.black),
                    focusedIndicatorColor = colorResource(id = R.color.statusBarColor),
                    textColor = colorResource(id = R.color.statusBarColor)
                ),
                value = titleText.value,
                onValueChange = { newValue ->
                    titleText.value = newValue
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                textStyle = TextStyle(fontSize = 24.sp),
                label = {
                    Text(text = "Напишите заглавие...", color = colorResource(id = R.color.orange))
                },
                trailingIcon = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            painter = painterResource(id = imageMic.value),
                            contentDescription = "speak",
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    launcher.launch(speechIntent)
                                },
                            tint = colorResource(id = R.color.statusBarColor)
                        )
                        IconButton(onClick = { titleText.value = "" }) {
                            Icon(
                                Icons.Default.Clear,
                                contentDescription = "Очистить поле",
                                tint = colorResource(id = R.color.statusBarColor)
                            )
                        }
                    }
                }
            )
            Box(
                modifier = Modifier.fillMaxSize().weight(1f)
            ) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.white),
                    cursorColor = colorResource(id = R.color.statusBarColor),
                    unfocusedIndicatorColor = colorResource(id = R.color.black),
                    focusedIndicatorColor = colorResource(id = R.color.statusBarColor),
                    textColor = colorResource(id = R.color.statusBarColor)
                ),
                value = detailsText.value,
                onValueChange = { newValue ->
                    detailsText.value = newValue
                },
                modifier = Modifier.fillMaxSize(),
                textStyle = TextStyle(fontSize = 16.sp),
                label = {
                    Text(text = "Напишите детали...", color = colorResource(id = R.color.orange))
                },
            )
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(id = imageMic.value), contentDescription = "speak",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                launcherDetails.launch(speechIntent)
                            },
                        tint =  colorResource(id = R.color.statusBarColor)
                    )
                    IconButton(onClick = { detailsText.value = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Очистить поле", tint = colorResource(id = R.color.statusBarColor))
                    }
                }
        }
        }
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(70.dp)
                    .background(colorResource(id = R.color.trWhite), CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = imageSave.value), contentDescription = "save",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(end = 16.dp, bottom = 16.dp)
                        .clickable {
                            viewModel.insertOrUpdateRecepies(
                                RecepiesEntity(
                                    title = titleText.value,
                                    details = detailsText.value
                                )
                            )
                            navController.popBackStack()
                            imageSave.value = R.drawable.baseline_save_as
                        },
                    tint = if (imageSave.value == R.drawable.baseline_save_as_red) colorResource(id = R.color.red)
                    else colorResource(id = R.color.statusBarColor)
                )
            }
        }
    }
}