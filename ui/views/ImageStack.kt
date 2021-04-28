package com.example.graphiti.ui.views

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.graphiti.data.viewModels.ImagesViewModel

@Composable
fun ImageStack(navController: NavController, ImgId: Int = 0) {
    val ivm = viewModel<ImagesViewModel>()
//    var index by remember { mutableStateOf(ImgId) }

    if (ivm.imgList.isNotEmpty()) {
        Log.d("media", ivm.imgList[ImgId].toString())
        val img = ivm.imgList[ImgId]
        Column {
            ImageBox(uri = img.uri, modifier = Modifier.clickable {
                navController.navigate("ImageStack/${ImgId + 1}") {
                    popUpTo(route = "ImageList") {}
                }
            })
            Text("This is your picture!")
        }
    }
    else {
        Text("...waiting for images")
    }
}