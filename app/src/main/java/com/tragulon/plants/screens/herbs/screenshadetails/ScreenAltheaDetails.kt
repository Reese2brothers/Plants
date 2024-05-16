package com.tragulon.plants.screens.herbs.screenshadetails

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.tragulon.plants.R
import com.tragulon.plants.viewmodels.FavouriteViewModel
import kotlinx.coroutines.launch

@Composable
fun ScreenAltheaDetails(){
    val images = listOf(R.drawable.althea, R.drawable.altheaa, R.drawable.altheaaa, R.drawable.altheaaaa, R.drawable.altheaaaaa)
    val pagerState = rememberPagerState( initialPage = 0)
    val viewModel: FavouriteViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val favouriteItems by viewModel.favourites.collectAsState(initial = emptyList())
    var isFavorite by remember { mutableStateOf(false) }

    LaunchedEffect(favouriteItems) {
        isFavorite = favouriteItems.any { it.imageResId == R.drawable.althea && it.title == "Алтей лекарственный" }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
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
                    .height(250.dp), count = 5) { page ->
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
                            viewModel.removeFromFavourites(R.drawable.althea, "Алтей лекарственный", "ScreenAltheaDetails")
                            isFavorite = !isFavorite
                        } else {
                            viewModel.addToFavourites(R.drawable.althea, "Алтей лекарственный", "ScreenAltheaDetails")
                            isFavorite = !isFavorite
                        }
                    } },
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
            Text(text = "\t\t\tАЛТЕЙ ЛЕКАРСТВЕННЫЙ (Althaéa officinális)\n" +
                    "Алтей лекарственный – травянистое многолетнее растение, семейства мальвовых, достигает в " +
                    "росте полутораметровой высоты. Корневище у алтея короткое, а главный корень толстый, и имеет " +
                    "множество боковых корешков. Стебли алтея круглые, прямостоячие. Листья, как правило," +
                    " имеют форму эллипса, иногда сердцевидную. Каждый листок алтея лекарственного покрыт пушком серого цвета.\n"+
                    "\t\t\tКЛАССИФИКАЦИЯ\n" +
                    "Растение имеет один главный стебель, высота которого может быть более 2-х метров. " +
                    "От ствола у старых растений отходит дополнительные крепкие стебли (более 10 шт.), " +
                    "молодой же алей обычно имеет только один стебель. Листья у алтея округлой формы и за" +
                    " счет мелких ворсинок имеют бархатистую фактуру. Цветы обычно белого цвета с розовым оттенком" +
                    " и расположены вдоль всего стебля, собраны в небольшие пучки по 5-7 соцветий. Период цветения" +
                    " составляет с начала июня до конца августа. Плоды у алтея имеют форму диска, внутри которого " +
                    "находится много семян. Корень у растения достаточно короткий, но мощный и достигает 2-х см в диаметре.\n"+
                    "\t\t\tБОТАНИЧЕСКОЕ ОПИСАНИЕ\n" +
                    "Алтей лекарственный, даже во время цветения не имеет запаха. Его цветы собраны в букетики на коротких цветоножках, розового цвета. " +
                    "Плоды алтея лекарственного созревают в виде плоской многосемянки. Цветет алтей только со второго года жизни," +
                    " на протяжении всего лета, с середины мая по август, созревает в конце августа и плодоносит до конца сентября. " +
                    "Дикий алтей размножается семенным способом. Если алтей культивировать, то применяется способ деления корневища. " +
                    "Как лекарственная трава алтей был описан еще древними врачами, в девятом веке до нашей эры.\n " +
                    "\t\t\tРАСПРОСТРАНЕНИЕ\n" +
                    "Встречается он во всех странах Европы, в некоторых странах Азии, Северной Африки и Северной Америки." +
                    " Очень широкое распространение алтея есть в Украине, Казахстане, в лесостепной зоне России, Сибири, на Кавказе." +
                    " Самая благоприятная среда для алтея лекарственного, это влажная легкая почва на берегах водоемов, заливных лугах, в речных поймах, оврагах.\n"+
                    "\t\t\tЗАГОТОВКА СЫРЬЯ\n" +
                    "Существует большое разнообразие видов алтея, но в лекарственных целях используется три основных вида: " +
                    "алтей лекарственный, армянский алтей и коноплевый алтей. В природе ареал вида распространяется практически" +
                    " на всю территорию Европы, Азии, Китая, Северной Африки и Северной Америки, а также в лесостепных местностях Кавказа, Карпат и Алтая." +
                    " Для медицинских целей растение культивируют в степных зонах Украины.\n" +
                    "\t\t\tХИМИЧЕСКИЙ СОСТАВ\n" +
                    "В корнях растения обнаружены крахмал (до 37 %), слизистые вещества (до 35 %), пектин (11—16 %)," +
                    " сахара (8 %), каротин, лецитин, фитостерин, минеральные соли и жирные масла (1—1,5 %)." +
                    " Корни алтея содержат незаменимые для человеческого организма аминокислоты, в частности, от 2 до 19,8 % аспарагина и до 4 % бетаина.\n" +
                    "В листьях, кроме того, содержатся слизи, эфирное масло, каучукоподобные вещества, аскорбиновая кислота, каротин.\n" +
                    "Жирное масло из семян содержит — олеиновую (30,8 %), α-линолевую (52,9 %); α-линоленовую (1,85 %) и β-линоленовую кислоту (0,65 %).\n" +
                    "Количество сахара, слизи и других веществ меняется по временам года. Зола богата фосфатами."+
                    "В составе корней было выявлено большое содержание крахмалистых и слизистых веществ," +
                    " сахара, пектин, лецитин, каротин, эфирные масла, минеральные соли, а также незаменимые " +
                    "аминокислоты (бетаин, аспарагин). В листьях кроме указанных веществ, содержащихся в корнях," +
                    " присутствуют также витамин С и каучукоподобные вещества. Семена же богаты жирными маслами: линоленовое, линолевое и олеиновое.\n"+
                    "\t\t\tФАРМАКОЛОГИЧЕСКИЕ СВОЙСТВА\n" +
                    "В корнях алтея лекарственного содержатся: крахмал, полисахариды, пектины, слизи," +
                    " жирные масла, фитостерины, калий, кальций, магний. А в листьях алтея ученые обнаружили" +
                    " вещества каучукоподобные и значительное количество витамина С.\n" +
                    "Благодаря своему химическому составу алтей лекарственный обладает свойствами репаративными," +
                    " противовоспалительными, отхаркивающими, обволакивающими. В фармакологии выпускают следующие формы " +
                    "препаратов на основании алтея лекарственного: экстракт сухого корня алтея, экстракт " +
                    "жидкий корня алтея, сироп алтея, таблетки (Мукалтин), сухая микстура, грудные сборы.\n"+
                    "\t\t\tПРИМЕНЕНИЕ В НАРОДНОЙ МЕДИЦИНЕ\n"+
                    "Алтей лекарственный имеет достаточно большое значение в фармакологической промышленности. " +
                            "На его основе производят препараты для лечения заболеваний органов дыхания и пищеварения." +
                            " Так корень алтея обладает противовоспалительными и отхаркивающими свойствами," +
                            " снимает отечность неба и миндалин, смягчает кашель и улучшает отхождение мокроты. " +
                            "За счет высокого содержания слизистых веществ алтей назначают при гастрите, " +
                            "язвах желудка и двенадцатиперстной кишки и колитах. В народной медицине настой корней " +
                            "алтея используют в качестве компрессов, примочек и полоскания при кожных опухолях," +
                            " лишаях и ожогах. Также из него делают сиропы, настои, отвары или спиртовые настойки.\n" +
                            "Сухие цветы алтея (1 дес. л.) залить кипятком и дать настояться в течение часа. " +
                            "Затем процедить и принимать по 2 ст.л. 3 раза в день. Используется данный рецепт при коклюше и бронхите.\n" +
                            "Грипп и пневмонию можно вылечить, если пить по 50 мл 3 раза в день настой измельченных сухих листьев алтея в 200 мл кипятка.\n" +
                            "При первых признаках ОРЗ или ангины необходимо употреблять настой корня алтея и " +
                            "полоскать ним горло. Для этого истолченный сухой корень (2 ст.л.) нужно залить" +
                            " кипяченой водой (600 мл), охлажденной до 30°С, и настоять в течение 8 часов." +
                            " Готовый раствор принимают по 25 мл 4 раза в день, а также поласкают горло не реже," +
                            " чем 3 раза в день. Этот же настой можно использовать в качестве компрессов при аденоме простаты.",
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                fontSize = 16.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor)
            )
        }
    }
}
