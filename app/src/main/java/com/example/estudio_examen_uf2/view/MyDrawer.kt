package com.example.estudio_examen_uf2.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.estudio_examen_uf2.ViewModel.AppViewModiel
import com.example.estudio_examen_uf2.navigation.Routes
import kotlinx.coroutines.launch

@Composable
fun MyDrawer(navControllerAuth: NavController, appVM: AppViewModiel) {

    val navControllerHome = rememberNavController()
    val scope = rememberCoroutineScope()
    val state: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(drawerState = state, gesturesEnabled = true, drawerContent = {
        ModalDrawerSheet {
            Text(text = "Menu", modifier = Modifier.padding(16.dp))
            Divider()
            /*toDo: menu option */

            NavigationDrawerItem(
                label = { Text(text = "Logout") },
                selected = false,
                onClick = {
                    scope.launch {
                        state.close()
                    }
                    navControllerAuth.navigate(Routes.Login.routes)
                }
            )
        }
    }
    ) {
        MyScafold(navControllerHome = navControllerHome, state = state, appVM = appVM)
    }
}