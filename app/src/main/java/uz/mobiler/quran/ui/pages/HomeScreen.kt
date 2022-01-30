package uz.mobiler.quran.ui.pages

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.mobiler.quran.models.surah.Data
import uz.mobiler.quran.ui.rows.SurahRow
import uz.mobiler.quran.vm.SurahResource
import uz.mobiler.quran.vm.SurahViewModel

val listCard: MutableState<List<Data>> = mutableStateOf(emptyList())

@Composable
fun HomeScreen(viewModel: SurahViewModel = hiltViewModel()) {
//    val exampleViewModel = hiltViewModel<SurahViewModel>()

    LaunchedEffect(Unit){
        viewModel.getSurah().collect {
            when(it){
                is SurahResource.Success->{
                    listCard.value = it.surahData?.data!!
                }
                is  SurahResource.Loading->{

                }
                is SurahResource.Error->{

                }
            }
        }
    }
    LoadData()


}

@Composable
fun LoadData(){
    LazyColumn{
        items(listCard.component1()) { data ->
            Log.d("TAG", "LoadData: $data")
            SurahRow(data = data)
        }
    }
}

@Composable
fun LoadData(data: List<Data>?) {

}