package com.example.estudio_examen_uf2.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.estudio_examen_uf2.ViewModel.AppViewModiel
import com.example.estudio_examen_uf2.navigation.Routes

@Composable
fun MyScafold(navControllerAuth: NavController, navControllerHome: NavController, state: DrawerState, appVM: AppViewModiel) {
    val showBottomSheet by appVM.showBottomSheet.observeAsState(false)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Scaffold(
            topBar = { MyTopBar(state) },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        appVM.changeShowBottomSheet(true)
                    }
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add a book")
                }
            }
        ) { paddingValues ->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
            ) {
                if (showBottomSheet) {
                    MyBottomSheet(navControllerAuth = navControllerAuth, appVM = appVM)
                }
            }
        }
    }
}
