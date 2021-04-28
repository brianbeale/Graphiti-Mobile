package com.example.graphiti.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.graphiti.data.viewModels.ImagesViewModel

@Composable
fun ImageList(navController: NavController) {
    val ivm = viewModel<ImagesViewModel>()
    val scrollState = rememberLazyListState()
    if (ivm.imgList.isNotEmpty()){
        LazyColumn(state = scrollState) {
            items(50) {
                Column {
                    ImageBox(
                        ivm.imgList[it].uri,
                        modifier = Modifier.clickable { navController.navigate("ImageStack/${it}") }
                    )
                    Text("Here is a picture")
                }
            }
        }
    }
}