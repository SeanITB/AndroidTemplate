package com.example.estudio_examen_uf2.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.estudio_examen_uf2.navigation.Routes

@Composable
fun MyRegister(navControllerAut: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Register", modifier = Modifier.clickable {
            navControllerAut.navigate(Routes.MyScafold.routes)
        })
        Text(text = "Login", modifier = Modifier.clickable {
            navControllerAut.navigate(Routes.Login.routes)
        })
    }
}