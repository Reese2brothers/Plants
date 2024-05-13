package com.tragulon.plants.screens

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tragulon.plants.R
import com.tragulon.plants.screens.viewmodels.EditViewModel
import com.tragulon.plants.screens.viewmodels.FavouriteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(mainplants : List<Int>) {
    val texts = rememberSaveable { mutableStateOf("") }
    val imageResource = rememberSaveable { mutableStateOf(mainplants.random()) }
    val scope = rememberCoroutineScope()
    val viewModel: EditViewModel = hiltViewModel()
    val edits by viewModel.edits.collectAsState(initial = emptyList())
    val currentText = remember { mutableStateOf("") }

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
                viewModel.updateText(newValue)
            },
            keyboardActions = KeyboardActions(onDone = {
                viewModel.addToEditEntity(currentText.value)
            }),
            //keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
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
                    IconButton(onClick = { viewModel.addToEditEntity(currentText.value) }) {
                        Icon(
                            Icons.Default.Done,
                            contentDescription = "Сохранить",
                            tint = colorResource(id = R.color.statusBarColor),
                        )
                    }
                    IconButton(onClick = { currentText.value = "" })
                    {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = "Очистить поле",
                        tint = colorResource(id = R.color.statusBarColor),
                    )
                    }
                }

            },
        )
    }
}
}
