package uz.mobiler.quran.ui.pages

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.*
import kotlinx.coroutines.flow.collect
import uz.mobiler.quran.models.surah.Data
import uz.mobiler.quran.ui.rows.SurahRow
import uz.mobiler.quran.vm.SurahResource
import uz.mobiler.quran.vm.SurahResource.*
import uz.mobiler.quran.vm.SurahViewModel


val listCard: MutableState<List<Data>> = mutableStateOf(emptyList())

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(viewModel: SurahViewModel = hiltViewModel()) {
//    val exampleViewModel = hiltViewModel<SurahViewModel>()

    LaunchedEffect(Unit){
        viewModel.getSurah().collect {
            when(it){
                is SurahResource.Success->{
                    Log.e("DAtalar", it.surahData?.data.toString() )
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


    //val myViewModel = hiltViewModel<SurahViewModel>()
   // val value = myViewModel.getSurah().collectAsState().value
//    value.let {
//
//    }
//       when(it){
//           is SurahResource.Success->{
//               Log.e("Datalar", it.surahData?.data?.toString().toString())
//           }
//           is SurahResource.Loading->{
//
//           }
//
//           is SurahResource.Error->{
//
//           }
//       }


}

@Composable
fun LoadData(){
    LazyColumn{
        items(listCard.component1()) { data ->
            SurahRow(data = data)
        }
    }
}

@Composable
fun LoadData(data: List<Data>?) {

}



