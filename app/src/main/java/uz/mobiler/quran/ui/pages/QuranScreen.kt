package uz.mobiler.quran.ui.pages

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collect
import uz.mobiler.quran.models.surah.Data
import uz.mobiler.quran.ui.rows.QuranSurahRow
import uz.mobiler.quran.ui.rows.SearchView
import uz.mobiler.quran.ui.rows.SurahRow
import uz.mobiler.quran.vm.SurahResource
import uz.mobiler.quran.vm.SurahViewModel
import java.util.*

val list: MutableState<List<Data>> = mutableStateOf(emptyList())

@Composable
fun QuranScreen(viewModel: SurahViewModel = hiltViewModel()) {
    val textState = remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            Text(modifier = Modifier.padding(5.dp), text = "Search Surah", fontSize = 25.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            SearchView(state = textState)
            LaunchedEffect(Unit) {
                viewModel.getSurah().collect {
                    when (it) {
                        is SurahResource.Success -> {
                            list.value = it.surahData?.data!!
                        }
                        is SurahResource.Loading -> {

                        }
                        is SurahResource.Error -> {

                        }
                    }
                }
            }
            LoadSurah(textState)
        }
    }
}


@Composable
fun LoadSurah(state: MutableState<String>) {

    LazyColumn(modifier = Modifier.padding(5.dp, 0.dp,5.dp,55.dp)) {
        val searchedText = state.value
        if (searchedText.isEmpty()) {
            items(list.component1()) { data ->
                QuranSurahRow(data = data)
            }
        } else {
            val filter = list.value.filter {
                it.name.transliteration.id.lowercase(Locale.getDefault()).contains(
                    searchedText.lowercase(
                        Locale.getDefault()
                    )
                )
            }
            items(filter) { data ->
                QuranSurahRow(data = data)
            }
        }
    }
}
