package com.nura.vechiledetails.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nura.vechiledetails.R
import com.nura.vechiledetails.data.model.BikeDetails

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(R.layout.fragment_first) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    // In Compose world
                    HomeFragment()
                }
            }

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


@Composable
fun HomeFragment() {
    val bikeList = listOf(
        BikeDetails(
            bikeId = "BIKE-001",
            brand = "Honda",
            model = "CBR1000RR",
            year = 2020,
            color = "Red",
            engineCapacity = 1000.0,
            price = 15000.0,
            isAvailable = true,
            imageId = 1001
        ),
        BikeDetails(
            bikeId = "BIKE-002",
            brand = "Yamaha",
            model = "R1",
            year = 2021,
            color = "Blue",
            engineCapacity = 1000.0,
            price = 18000.0,
            isAvailable = false,
            imageId = 1002
        ),
        BikeDetails(
            bikeId = "BIKE-003",
            brand = "Kawasaki",
            model = "Ninja ZX-10R",
            year = 2019,
            color = "Green",
            engineCapacity = 998.0,
            price = 17000.0,
            isAvailable = true,
            imageId = 1003
        ),
        BikeDetails(
            bikeId = "BIKE-004",
            brand = "Suzuki",
            model = "GSX-R1000",
            year = 2022,
            color = "Black",
            engineCapacity = 999.0,
            price = 16000.0,
            isAvailable = true,
            imageId = 1004
        ),
        BikeDetails(
            bikeId = "BIKE-005",
            brand = "Ducati",
            model = "Panigale V4",
            year = 2023,
            color = "Yellow",
            engineCapacity = 1103.0,
            price = 25000.0,
            isAvailable = false,
            imageId = 1005
        )
    )
//    Column(modifier = Modifier.fillMaxSize()) {
//        Row (modifier = Modifier.weight(0.1f)){
//            Text(text = "Most Popular" , fontSize = 40.sp)
//            Text(text = "See all")
//        }
//        LazyRow  (horizontalArrangement = Arrangement.spacedBy(10.dp),modifier = Modifier.weight(0.4f)) {
//            items(bikeList) { bike ->
//                MostPopularBike()
//            }
//        }
//        Row (modifier = Modifier.weight(0.1f)) {
//            Text(text = "New Models")
//            Spacer(modifier = Modifier.weight(0.2f).size(10.dp))
//            Text(text = "See all")
//        }
//        LazyColumn (verticalArrangement = Arrangement.spacedBy(10.dp),modifier = Modifier.weight(0.4f)) {
//            items(bikeList) { bike ->
//                MostPopularBike()
//            }
//        }
//    }

    Column(modifier = Modifier.fillMaxSize().padding(10.dp) , verticalArrangement = Arrangement.spacedBy(15.dp)) {
        Row() {
            Text(text = "New Models", fontSize = 40.sp)
            Spacer(modifier = Modifier
                .weight(0.2f)
                .size(10.dp))
            Text(text = "See all")
        }
        LazyRow() {
            items(bikeList) { bike -> MostPopularBike() }
        }

        Row(modifier = Modifier.weight(0.1f)) {
            Text(text = "New Models",fontSize = 40.sp)
            Spacer(modifier = Modifier
                .weight(0.2f)
                .size(10.dp))
            Text(text = "See all")
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(bikeList) { bike ->
                MostPopularBike()
            }
        }
    }
}


@Preview
@Composable
fun TestComposable() {
    HomeFragment()
}