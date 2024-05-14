package com.tragulon.plants.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.tragulon.plants.R
import com.tragulon.plants.database.RecepiesEntity
import com.tragulon.plants.viewmodels.RecepiesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecepiesDetailsScreen(backStackEntry: NavBackStackEntry, navController : NavController) {
    val arguments = remember { backStackEntry.arguments }
    val title = arguments?.getString("title") ?: ""
    val details = arguments?.getString("details") ?: ""
    val id = arguments?.getString("id")?.toIntOrNull() ?: 0
    val viewModel: RecepiesViewModel = hiltViewModel()
    val titleText = remember { mutableStateOf(title) }
    val detailsText = remember { mutableStateOf(details) }
    val imageSave = rememberSaveable{(mutableStateOf(R.drawable.baseline_save_as_red))}

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
                    onValueChange = { newValue -> titleText.value = newValue
                        imageSave.value = R.drawable.baseline_save_as_red

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    textStyle = TextStyle(fontSize = 24.sp),
                )
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(id = R.color.white),
                        cursorColor = colorResource(id = R.color.statusBarColor),
                        unfocusedIndicatorColor = colorResource(id = R.color.black),
                        focusedIndicatorColor = colorResource(id = R.color.statusBarColor),
                        textColor = colorResource(id = R.color.statusBarColor)
                    ),
                    value = detailsText.value , onValueChange = { newValue ->
                        detailsText.value = newValue
                        imageSave.value = R.drawable.baseline_save_as_red
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    textStyle = TextStyle(fontSize = 16.sp),
                )
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
                                        id,
                                        titleText.value,
                                        detailsText.value
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