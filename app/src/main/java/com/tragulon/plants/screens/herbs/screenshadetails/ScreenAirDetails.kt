package com.tragulon.plants.screens.herbs.screenshadetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tragulon.plants.R
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@Composable
fun ScreenAirDetails(navController: NavController){
    val images = listOf(R.drawable.air, R.drawable.airr, R.drawable.airrr, R.drawable.airrrr)
    val pagerState = rememberPagerState( initialPage = 0)
    var isFavorite by rememberSaveable { mutableStateOf(false) }
Box(
    modifier = Modifier.fillMaxSize()
) {
   Column(
       modifier = Modifier.fillMaxSize(),
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
           .height(250.dp), count = 4) { page ->
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
                   .padding(bottom = 10.dp)
                   .background(color = colorResource(id = R.color.lightStatusBarColor)),
               activeColor = Color.White,
               inactiveColor = colorResource(id = R.color.green),
               indicatorHeight = 10.dp,
               indicatorWidth = 10.dp
           )
           IconButton(onClick = { isFavorite = !isFavorite }, // Обработчик нажатия на иконку
               modifier = Modifier.align(Alignment.TopEnd) // Располагаем иконку в верхнем правом углу
           ) {
               Icon(
                   painter = painterResource(id = if (isFavorite) R.drawable.baseline_favorite_white_24
                   else R.drawable.baseline_favorite_red_24),
                   contentDescription = "Favorite",
                   tint = if (isFavorite) Color.Red else Color.White
               )
           }
       }
      Text(text = "\t\t\tАИР ОБЫКНОВЕННЫЙ (Acorus calamus L.)\n" +
              "Травянистое растение с длинным ползучим корневищем, применяется как пряность " +
              "и в целебных целях при заболеваниях органов желудочно-кишечного тракта." +
              "Препараты из корневищ аира широко применяют для лечения хронических гастритов, " +
              "язвенной болезни желудка и двенадцатиперстной кишки, особенно при сниженной кислотности" +
              " желудочного сока, при диспепсических расстройствах, дискинезии желчевыводящих путей, " +
              "хроническом холецистите, ахилии, метеоризме, диарее различного происхождения и при других " +
              "нарушениях пищеварения. Их употребляют как ароматическую горечь для возбуждения" +
              " аппетита, при невротической и астенической анорексии. Эфирное масло снимает приступы кишечной колики.\n" +
              "\t\t\tКЛАССИФИКАЦИЯ\n" +
              "Аир обыкновенный (лат. Acorus calamus L.) принадлежит к семейству ароидных (лат. Araceae)." +
              " По разным данным к роду аир относят от двух до шести видов растений, распространенных " +
              "во внетропических областях Северного полушария. Но общепризнаны два вида: Аир обыкновенный " +
              "(Acorus calamus), который применяется в медицине и аир злаковый (Acorus gramineus).\n" +
              "\t\t\tБОТАНИЧЕСКОЕ ОПИСАНИЕ\n" +
              "Аир обыкновенный – это многолетнее травянистое растение, высотой 60-100 см. Корневище толстое," +
              " цилиндрическое, извилистое, покрытое сверху по спирали темными широкими листковыми рубцами," +
              " расположено горизонтально, почти на поверхности, достигает длины до 1,5 м. Корни аира тонкие, " +
              "мочковатые, расположены в узлах. Корневище и другие части растения отличаются характерным сильным запахом. " +
              "Стебель прямостоячий, неразветвленный, сплюснутый, с одной стороны желобчатый, с другой — остроребристый. " +
              "Листья мечевидные. Цветки мелкие, зелено-желтые, двуполые, собранные в початок длиной 4–12 см." +
              " Формула цветка аира обыкновенного: *О3+3Т6П(3). Цветет в мае–июле. Плод — кожистая многосемянная" +
              " красная ягода. В климатических условиях России плоды растения обычно не вызревают и оно размножается корневищами.\n" +
              "\t\t\tРАСПРОСТРАНЕНИЕ\n" +
              "Аир обыкновенный распространен в Европе, Прибалтике, на Кавказе, в Малой Азии, Индии," +
              " Китае, Японии, в Северной Америке. Встречается в средней и южной полосе европейской " +
              "части России, почти по всей территории Украины, Белоруссии, Казахстана. " +
              "Растет по берегам рек и водоемов, на болотах и болотистых лугах.\n" +
              "\t\t\tЗАГОТОВКА СЫРЬЯ\n" +
              "Как лекарственное сырье в медицине используют сухие и свежие корневища аира (Rhizoma Calami)." +
              " Сырье заготавливают ранней весной и осенью. Корневищ арастения выкапывают, " +
              "затем срезают ножом остатки листьев, стеблей и корни аира. Корневища моют," +
              " подвяливают на открытом воздухе, разрезают на куски до 20 см и сушат при температуре не выше 30°С.\n" +
              "\t\t\tХИМИЧЕСКИЙ СОСТАВ\n" +
              "В корневищах аира содержится до 3 % эфирного масла, в состав которого входят монотерпены " +
              "(камфен, камфора, борнеол) и сесквитерпены (акорон, изоакорон, акороксид и др.), ароматические соединения (азарон, эвгенол) и др." +
              "Кроме эфирного масла в корневищах аира найден специфический для растения горький гликозид " +
              "акорин, горечь акоретин, дубильные вещества, аскорбиновая и пальмитиновая кислоты, " +
              "крахмал, холин, витамины, йод. Запах корневищ обусловливается азарилальдегидом.\n" +
              "\t\t\tФАРМАКОЛОГИЧЕСКИЕ СВОЙСТВА\n" +
              "Эфирное масло аира и горький гликозид акорин влияют на вкусовые рецепторы, повышают аппетит," +
              " благоприятно влияют на тонус желчного пузыря, улучшают пищеварение, рефлекторно стимулируют" +
              " секрецию желудочного сока, способствуют отхождению газов, повышают диурез. Дубильные вещества " +
              "усиливают лечебный эффект, проявляют антидиарейные свойства." +
              "Экспериментально доказано, что препараты аира проявляют спазмолитическое действие. " +
              "За счет содержания в корневищах растения терпеноидов (проазулена, азарона) средства из " +
              "корневищ аира обладают бактериостатическими, фунгистатическими и противовоспалительными свойствами." +
              " Эфирное масло проявляет противомикробную активность в отношении золотистого стафилококка " +
              "и кишечной палочки. Водные и спиртовые вытяжки из корневищ аира умеренно угнетают развитие шигелл, протея, синегнойной палочки.\n" +
              "\t\t\tПРИМЕНЕНИЕ В НАРОДНОЙ МЕДИЦИНЕ\n" +
              "В народной медицине настой корневищ аира применяют при гастритах с пониженной кислотностью," +
              " желудочных и кишечных коликах, диарее, гепатитах, холециститах, воспалении почек и мочевого пузыря," +
              " мочевыводящих путей, нерегулярных менструациях, заболеваниях желчных путей, желчного пузыря. " +
              "Зелень и корни аира используют для приготовления лечебных ванн, которые применяют при лечении рахита и золотухи у детей и невроза у взрослых.",
          modifier = Modifier
              .padding(top = 8.dp, start = 8.dp, end = 8.dp)
              .fillMaxWidth()
              .verticalScroll(rememberScrollState()),
          fontSize = 16.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.statusBarColor))
   } 
}
}