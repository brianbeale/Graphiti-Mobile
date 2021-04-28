package com.example.graphiti.data.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.graphiti.data.media.MediaDataSource
import com.example.graphiti.data.media.Repository
import kotlinx.coroutines.launch

class ImagesViewModel(app: Application): AndroidViewModel(app) {
    private val repository = Repository(app.applicationContext)

    var imgList: List<MediaDataSource.Img> by mutableStateOf(listOf())

    init {
        this.getImages()
    }
    private fun getImages() {
        val repository = this.repository

        viewModelScope.launch {
            imgList = repository.getImages()
        }
    }
}