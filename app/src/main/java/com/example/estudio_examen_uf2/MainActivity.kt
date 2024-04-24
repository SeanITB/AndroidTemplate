package com.example.estudio_examen_uf2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.estudio_examen_uf2.navigation.Routes
import com.example.estudio_examen_uf2.ui.theme.Estudio_Examen_uf2Theme
import com.example.estudio_examen_uf2.view.MyDrawer
import com.example.estudio_examen_uf2.view.MyLogin
import com.example.estudio_examen_uf2.view.MyScafold
import com.example.estudio_examen_uf2.view.MyRegister

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Estudio_Examen_uf2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navControllerAuth = rememberNavController()
                    NavHost(
                        navController = navControllerAuth,
                        startDestination = Routes.Login.routes
                    ) {
                        composable(Routes.Login.routes) { MyLogin(navControllerAuth)}
                        composable(Routes.Register.routes) { MyRegister(navControllerAuth) }
                        composable(Routes.MyScafold.routes) { MyDrawer(navControllerAuth) }
                    }

                }
            }
        }
    }
}



/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Estudio_Examen_uf2Theme {
        Greeting("Android")
    }
}

 */