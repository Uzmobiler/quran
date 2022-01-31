package uz.mobiler.quran.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collect
import uz.mobiler.quran.R
import uz.mobiler.quran.models.surah.Data
import uz.mobiler.quran.ui.rows.SurahRow
import uz.mobiler.quran.ui.screen.Screen
import uz.mobiler.quran.ui.theme.BottomItemSelectedColor
import uz.mobiler.quran.vm.SurahResource
import uz.mobiler.quran.vm.SurahViewModel

val listCard: MutableState<List<Data>> = mutableStateOf(emptyList())

@Composable
fun HomeScreen(navController: NavHostController, viewModel: SurahViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getSurah().collect {
            when (it) {
                is SurahResource.Success -> {
                    listCard.value = it.surahData?.data!!
                }
                is SurahResource.Loading -> {

                }
                is SurahResource.Error -> {

                }
            }
        }
    }
    Column() {
        ConstraintLayout(
            modifier = Modifier
                .background(Color.White)
        ) {
            val (text, card, text1, text2, lazy) = createRefs()
            createHorizontalChain(text, chainStyle = ChainStyle.Packed(0.1F))
            createVerticalChain(text, chainStyle = ChainStyle.Packed(0.05F))
            Text(
                text = "Quran+",
                fontSize = 30.sp, modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .constrainAs(text) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        absoluteLeft.linkTo(parent.absoluteLeft)
                        absoluteRight.linkTo(parent.absoluteRight)
                    }, color = Color.Black, textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.poppins_bold, FontWeight.Light))
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.2f)
                    .constrainAs(card) {
                        top.linkTo(text.bottom, margin = 10.dp)
                        absoluteLeft.linkTo(text.absoluteLeft)
                    }, backgroundColor = Color.Black,
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_frame_30),
                    contentDescription = "Image Quran",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                ConstraintLayout {
                    val (textCard, IconCard, textCard1, textCard2, textCard3) = createRefs()

                    createHorizontalChain(IconCard, chainStyle = ChainStyle.Packed(0.05F))
                    createVerticalChain(IconCard, chainStyle = ChainStyle.Packed(0.2F))
                    Image(painter = painterResource(id = R.drawable.ic_group),
                        contentDescription = "image",
                        modifier = Modifier
                            .width(20.dp)
                            .height(24.dp)
                            .constrainAs(IconCard) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                absoluteLeft.linkTo(parent.absoluteLeft)
                                absoluteLeft.linkTo(parent.absoluteLeft)
                                absoluteRight.linkTo(parent.absoluteRight)
                            })
                    Text(
                        text = "Last Read",
                        modifier = Modifier.constrainAs(textCard) {
                            top.linkTo(IconCard.top)
                            bottom.linkTo(IconCard.bottom)
                            absoluteLeft.linkTo(IconCard.absoluteRight, margin = 8.dp)
                        }, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left
                    )

                    Text(
                        text = "Al-Fatiah",
                        modifier = Modifier.constrainAs(textCard1) {
                            top.linkTo(IconCard.bottom, margin = 10.dp)
                            absoluteLeft.linkTo(IconCard.absoluteLeft)
                        }, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left
                    )

                    Text(
                        text = "Last Read",
                        modifier = Modifier.constrainAs(textCard2) {
                            top.linkTo(textCard1.bottom, margin = 8.dp)
                            absoluteLeft.linkTo(textCard1.absoluteLeft)
                        }, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Left
                    )
                }
            }
            Text(
                text = "Surah",
                modifier = Modifier
                    .constrainAs(text1) {
                        top.linkTo(card.bottom, margin = 10.dp)
                        absoluteLeft.linkTo(card.absoluteLeft)
                    }, color = Color.Black, textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold, fontSize = 17.sp
            )

            Text(
                text = "See All",
                modifier = Modifier
                    .constrainAs(text2) {
                        top.linkTo(card.bottom, margin = 10.dp)
                        absoluteRight.linkTo(card.absoluteRight)
                    }, color = BottomItemSelectedColor, textAlign = TextAlign.Right,
                fontWeight = FontWeight.Bold, fontSize = 13.sp
            )
        }
        LoadCard(navController)
    }


}

@Composable
fun LoadCard(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 10.dp, 10.dp, 55.dp)
    ) {
        items(listCard.component1()) { data ->
            Row(modifier = Modifier.clickable {
                navController.navigate(Screen.Info.route + "/${data.number}")
            }) {
                SurahRow(data = data)
            }
        }
    }
}