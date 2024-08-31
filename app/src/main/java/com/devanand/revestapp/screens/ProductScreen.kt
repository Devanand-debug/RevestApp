package com.devanand.revestapp.screens

import android.annotation.SuppressLint
import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.devanand.revestapp.models.MyProducts
import com.devanand.revestapp.viewmodel.ProductViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun ProductScreen(navController: NavHostController) {

    val viewModel : ProductViewModel = hiltViewModel()
    val productData = viewModel.productData

    val isLoading = viewModel.isLoading

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchData()
    }
//    if (productData.value?.products?.isEmpty() == true){
//        Log.e("productData = ", "No Data")
//        CircularProgressIndicator()
//    }else{
//        Log.e("productData = ", productData.value?.products?.get(1)?.warrantyInformation.toString())
//    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            isLoading.value -> {
                CircularProgressIndicator()
            }

            productData != null -> {
                Surface {
                    ProductList(productData, navController)
                }
            }
            else -> {
                Text(text = "No data available")
            }
        }
    }

//    Surface {
//       // ProductCard(productData)
//        ProductList(productData,navController)
//    }
}

@Composable
fun ProductList(products: State<MyProducts?>, navController: NavHostController) {
        val productList = remember{ mutableStateListOf(products) }
        LazyColumn (modifier = Modifier.padding(top = 8.dp, bottom = 20.dp)){
            items(productList){
                 ProductCard(it,navController)
            }
        }
}

@Composable
fun ProductCard(productData: State<MyProducts?>, navController: NavHostController) {
    Log.e("myProductData1 = ", "${productData.value?.products}")

    productData.value?.products?.forEach {
        Log.e("myProductData = ", "${it.title}")

    Card( onClick = {

        navController.navigate("productDetails/${it.title}/${it.description}" +
                "/${it.rating}/${it.category}/${it.price}")

    },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .padding(top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(it.thumbnail),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(180.dp)
                    .clip(shape = RectangleShape)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = it.title?: "",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp),
                )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = it.description?: "",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

}