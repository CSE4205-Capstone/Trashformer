package com.example.trashformer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("로그인 화면")
        Spacer(modifier = Modifier.height(16.dp))
        // 버튼을 누르면 "camera" 경로로 이동합니다.
        Button(onClick = { navController.navigate("camera") }) {
            Text("카메라 실행하기")
        }
    }
}