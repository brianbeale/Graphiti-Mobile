package com.example.graphiti.data.media

import android.content.Context

class Repository(appContext: Context) {
    private val mediaDataSource = MediaDataSource(appContext)

    suspend fun getImages(): List<MediaDataSource.Img> {
        return mediaDataSource.imageQuery()
    }


}