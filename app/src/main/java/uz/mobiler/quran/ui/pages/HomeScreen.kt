package uz.mobiler.quran.ui.pages

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.collect
import uz.mobiler.quran.vm.SurahResource
import uz.mobiler.quran.vm.SurahViewModel

@Composable
fun HomeScreen() {
    val myViewModel = hiltViewModel<SurahViewModel>()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val value = myViewModel.getSurah().collectAsState().value
        when (value) {
            is SurahResource.Success -> {
                val surahData = value.surahData
                surahData?.data?.forEach {
                    Log.d("TAG", "HomeScreen: $it")
                    Text(
                        text = it.name.transliteration.en,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreView() {
    HomeScreen()
}