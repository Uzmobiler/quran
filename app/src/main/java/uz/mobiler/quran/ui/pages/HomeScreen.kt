package uz.mobiler.quran.ui.pages

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import uz.mobiler.quran.models.surah.Data
import uz.mobiler.quran.ui.rows.SurahRow
import uz.mobiler.quran.vm.SurahResource
import uz.mobiler.quran.vm.SurahViewModel

@Composable
fun HomeScreen() {
    val myViewModel = hiltViewModel<SurahViewModel>()
    val value = myViewModel.getSurah().collectAsState().value
    value.let {
        when (it) {
            is SurahResource.Success -> {
                val surahData = it.surahData
                LazyColumn {
                    items(surahData?.data ?: emptyList()) { data ->
                        SurahRow(data = data)
                    }
                }
            }
            is SurahResource.Error -> {

            }
            SurahResource.Loading -> {

            }
        }
    }
}