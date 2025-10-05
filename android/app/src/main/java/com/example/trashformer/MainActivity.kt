package com.example.trashformer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trashformer.ui.theme.TrashformerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrashformerTheme {
                val navController = rememberNavController()

                // 시작 지점이 "login"으로 설정되어 있는지 확인하세요.
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(navController = navController)
                    }
                    composable("camera") {
                        CameraPermissionScreen()
                    }
                }
            }
        }
    }
}