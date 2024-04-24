package com.example.estudio_examen_uf2.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(state: DrawerState) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        title = { Text(text = "myExamPractice") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    state.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {}
    )
}
