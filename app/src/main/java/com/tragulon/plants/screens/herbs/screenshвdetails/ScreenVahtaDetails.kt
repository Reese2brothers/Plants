package com.tragulon.plants.screens.herbs.screenshвdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.tragulon.plants.R
import com.tragulon.plants.viewmodels.FavouriteViewModel
import kotlinx.coroutines.launch

@Composable
fun ScreenVahtaDetails(){
    val images = listOf(
        R.drawable.v_vahta, R.drawable.v_vahtaa, R.drawable.v_vahtaaa, R.drawable.v_vahtaaaa,
        R.drawable.v_vahtaaaaa, R.drawable.v_vahtaaaaaa)
    val pagerState = rememberPagerState( initialPage = 0)
    val scope = rememberCoroutineScope()
    val viewModel: FavouriteViewModel = hiltViewModel()
    val favouriteItems by viewModel.favourites.collectAsState(initial = emptyList())
    var isFavorite by remember { mutableStateOf(false) }

    LaunchedEffect(favouriteItems) {
        isFavorite = favouriteItems.any { it.imageResId == R.drawable.v_vahta && it.title == "Вахта трехлистная" }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                HorizontalPager(state = pagerState, modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp), count = 6) { page ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(id = images[page]),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                    }
                }
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .padding(bottom = 10.dp),
                    activeColor = Color.White,
                    inactiveColor = colorResource(id = R.color.green),
                    indicatorHeight = 10.dp,
                    indicatorWidth = 10.dp
                )
                IconButton(onClick = {
                    scope.launch {
                        if (isFavorite) {
                            viewModel.removeFromFavourites(R.drawable.v_vahta, "Вахта трехлистная", "ScreenVahtaDetails")
                            isFavorite = !isFavorite
                        } else {
                            viewModel.addToFavourites(R.drawable.v_vahta, "Вахта трехлистная",  "ScreenVahtaDetails")
                            isFavorite = !isFavorite
                        }
                    }},
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = if (isFavorite) R.drawable.baseline_favorite_red_24
                        else R.drawable.baseline_favorite_white_24),
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color.Red else Color.White
                    )
                }
            }
            Text(text = stringResource(id = R.string.vahta),
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                fontSize = 16.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
            )
        }
    }
}