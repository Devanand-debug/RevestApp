package com.devanand.revestapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun ProductDetailsScreen(
    title: String,
    description: String,
    rating: String,
    category: String,
    price: String,
   // image: Comparable<*>
) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(top = 20.dp, start = 14.dp, end = 14.dp)
            .fillMaxSize()

    ) {
//        Image(
//            painter = rememberAsyncImagePainter(image),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.size(56.dp)
//        )
        Text(text = "Product Title : $title", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Product Desc : $description",
            style = MaterialTheme.typography.titleSmall,)
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Product Rating : $rating")
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Product Category : $category")
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Product Price : $price")
    }

}