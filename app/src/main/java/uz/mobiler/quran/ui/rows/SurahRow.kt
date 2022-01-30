package uz.mobiler.quran.ui.rows

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import uz.mobiler.quran.R
import uz.mobiler.quran.models.surah.Data
import uz.mobiler.quran.ui.pages.SplashScreen
import uz.mobiler.quran.ui.theme.BottomItemSelectedColor

@Composable
fun SurahRow(data: Data) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
        ) {
            Box(contentAlignment = Alignment.Center) {
                Image(painter = painterResource(id = R.drawable.ic_muslim_shape), "1")
                Text(text = data.number.toString())
            }
            Spacer(modifier = Modifier.width(7.dp))
            Column {
                Text(text = data.name.transliteration.id, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = data.revelation.id, fontSize = 10.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .clip(shape = RoundedCornerShape(2.dp))
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "${data.revelation} ayat", fontSize = 10.sp)
                }
            }
            Spacer(modifier = Modifier.weight(1.0f))
            Text(text = data.name.short, color = BottomItemSelectedColor)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(Color.LightGray)) {}
    }

}

@Preview
@Composable
fun SurahRowPreview() {

}
