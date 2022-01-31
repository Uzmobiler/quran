package uz.mobiler.quran.ui.rows

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.mobiler.quran.R
import uz.mobiler.quran.models.surah.surah_info.Verse

@Composable
fun FullSurahDataRow(data: Verse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_muslim_shape),
                contentDescription = ""
            )
            Text(text = data.number.inSurah.toString(), fontSize = 10.sp)
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text(text = data.text.arab, textAlign = TextAlign.Right)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column {
            Text(text = data.translation.id)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Tafsir", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = data.tafsir.id.short)
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .height(0.5.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {

            }
        }
    }
}