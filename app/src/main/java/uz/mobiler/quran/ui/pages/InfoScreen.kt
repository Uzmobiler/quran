package uz.mobiler.quran.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collect
import uz.mobiler.quran.models.surah.surah_info.Verse
import uz.mobiler.quran.ui.rows.FullSurahDataRow
import uz.mobiler.quran.vm.SurahInfoResource
import uz.mobiler.quran.vm.SurahViewModel

val info: MutableState<List<Verse>> = mutableStateOf(emptyList())

@Composable
fun InfoScreen(id:Int, viewModel: SurahViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getSurahInfo(id).collect {
            when (it) {
                is SurahInfoResource.Success -> {
                    info.value = it.surahInfoData?.data?.verses ?: emptyList()
                }
                is SurahInfoResource.Loading -> {

                }
                is SurahInfoResource.Error -> {

                }
            }
        }
    }
    Column {
        LoadInfoSurah()
    }
}

@Composable
fun LoadInfoSurah() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 10.dp, 10.dp, 55.dp)
    ) {
        items(info.component1()) { data ->
            FullSurahDataRow(data)
        }
    }
}
