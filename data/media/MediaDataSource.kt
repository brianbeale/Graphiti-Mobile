package com.example.graphiti.data.media

import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MediaDataSource(appContext: Context) {
    private val resolver = appContext.contentResolver

    data class Img(val uri: Uri, val name: String, val size: Int)

    suspend fun imageQuery(selection: String? = "_size >= ?", selectionArgs: Array<String>? = arrayOf("50000"),
        sortOrder: String = "_size ASC"): List<Img> {
        val imgList = mutableListOf<Img>()

        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.SIZE,
        )

        withContext(Dispatchers.IO) {
            resolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                projection, selection, selectionArgs, sortOrder
            )?.use { cursor ->
                // Cache column indices
                val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                val nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                val sizeColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)

                while (cursor.moveToNext()) {
                    val id = cursor.getLong(idColumn)
                    val name = cursor.getString(nameColumn)
                    val size = cursor.getInt(sizeColumn)

                    val contentUri: Uri = ContentUris.withAppendedId(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id
                    )

                    imgList += Img(contentUri, name ?: "", size)
                }
            }
        }
        return imgList
    }
}