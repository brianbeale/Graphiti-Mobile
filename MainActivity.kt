package com.example.graphiti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.graphiti.ui.theme.GraphitiTheme
import com.example.graphiti.ui.views.ImageList
import com.example.graphiti.ui.views.ImageStack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphitiTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "ImageList") {
                        composable("ImageList") { ImageList(navController) }
                        composable("ImageStack/{ImgID}") { backStackEntry ->
                            ImageStack(navController, backStackEntry.arguments?.getString("ImgID")?.toInt() ?: 0)
                        }
                    }
                }
            }
        }
    }
}
