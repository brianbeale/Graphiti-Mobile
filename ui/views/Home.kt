package com.example.graphiti.ui.views

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

@Composable
fun Home() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "ImageList") {
        composable("ImageList") { ImageList(navController) }
        composable("ImageStack") { ImageStack(navController) }
    }
    Button(onClick = { navController.navigate("ImageList") }) {
        Text("ImageList")
    }
}