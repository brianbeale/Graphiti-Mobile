package com.example.graphiti.ui.views

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.imageloading.MaterialLoadingImage

@Composable
fun ImageBox(uri: Uri, modifier: Modifier = Modifier) {
    CoilImage(data = uri, modifier = modifier) {
            imageState ->
        when (imageState) {
            is ImageLoadState.Loading -> {
                Surface(color = Color.Black, modifier = Modifier.size(5000.dp)) {}
            }
            is ImageLoadState.Success -> {
                MaterialLoadingImage(
                    result = imageState,
                    contentDescription = "This is one of your pictures!",
                    fadeInEnabled = true,
                    fadeInDurationMs = 600,
                )
            }
            else -> Log.d("media", "ImageLoadState not Success")
        }
    }
}