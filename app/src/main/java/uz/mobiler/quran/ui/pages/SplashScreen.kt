package uz.mobiler.quran.ui.pages

import android.util.Log
import android.widget.Toast
import android.window.SplashScreen
import android.window.SplashScreenView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.mobiler.quran.R
import uz.mobiler.quran.ui.screen.Screen
import uz.mobiler.quran.ui.theme.ButtonColor
import uz.mobiler.quran.ui.theme.TextColor
import uz.mobiler.quran.ui.theme.TextColorGren
import uz.mobiler.quran.ui.theme.Typography



@Composable
@Preview(showBackground = true)
fun SplashScreenPreView(){
    SplashScreen(navController = rememberNavController())
}


@Composable
fun SplashScreen(navController: NavController){
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        val (text,text1,card,button) = createRefs()

        createHorizontalChain(text, chainStyle = ChainStyle.Packed(0.5F))
        createVerticalChain(text, chainStyle = ChainStyle.Packed(0.05F))

        Text(text = "Quran App",
            fontSize = 30.sp,
            color = TextColor,
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    absoluteLeft.linkTo(parent.absoluteLeft, margin = 15.dp)
                    absoluteRight.linkTo(parent.absoluteRight, margin = 15.dp)
                }
                .fillMaxWidth(0.5F), fontWeight = FontWeight.Bold,
            fontFamily = Typography.body2.fontFamily,
            textAlign = TextAlign.Center
        )

//        createVerticalChain(text, chainStyle = ChainStyle.Packed(0.1F))

        Text(text = "Learn Quran and \n Recite once everyday",
            fontSize = 15.sp,
            color = TextColorGren,
            modifier = Modifier
                .constrainAs(text1) {
                    top.linkTo(text.bottom, margin = 8.dp)
                    absoluteLeft.linkTo(text.absoluteLeft)
                    absoluteRight.linkTo(text.absoluteRight)
                }
                .fillMaxWidth(0.7F), fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.poppins_light,FontWeight.Light)),
            textAlign = TextAlign.Center,
            maxLines = 2
        )
//        createVerticalChain(text1, chainStyle = ChainStyle.Packed(0.3F))
        Card(modifier = Modifier
            .constrainAs(card) {
                top.linkTo(text1.bottom, margin = 30.dp)
                absoluteLeft.linkTo(parent.absoluteLeft)
                absoluteRight.linkTo(parent.absoluteRight)
            }
            .fillMaxWidth(0.85f)
            .fillMaxHeight(0.6f), shape = RoundedCornerShape(30.dp)
        ) {
            ConstraintLayout(modifier = Modifier
                .fillMaxSize()
                .background(TextColor)){
                val image = createRef()
                createVerticalChain(image, chainStyle = ChainStyle.Packed(0.05F))
                Image(painter = painterResource(id = R.drawable.ic_group_24),
                    contentDescription ="",
                    Modifier
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            absoluteLeft.linkTo(parent.absoluteLeft)
                            absoluteRight.linkTo(parent.absoluteRight)
                        }
                        .background(TextColor)
                        .fillMaxWidth()
                        .fillMaxHeight(0.8f))
            }
        }

        Button(modifier = Modifier
            .constrainAs(button) {
                top.linkTo(card.bottom)
                bottom.linkTo(card.bottom)
                absoluteLeft.linkTo(card.absoluteLeft)
                absoluteRight.linkTo(card.absoluteRight)
            }
            .fillMaxHeight(0.08f)
            .fillMaxWidth(0.4f), onClick = {
            navController.navigate(route = Screen.Home.route){
                popUpTo(Screen.Splash.route){
                    inclusive = true
                }
            }
        }, colors = ButtonDefaults.buttonColors(backgroundColor = ButtonColor),
            shape = RoundedCornerShape(30.dp)) {
            Text(text = "Get Started",
                fontSize = 15.sp, color = Color.White)
        }
    }




}



