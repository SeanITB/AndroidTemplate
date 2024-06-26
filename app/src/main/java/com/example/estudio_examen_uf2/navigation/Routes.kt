package com.example.estudio_examen_uf2.navigation

sealed class Routes (val routes: String) {
    object Login: Routes("login")
    object Register: Routes("register")
    object MyScafold: Routes("myScafold")
    object CameraPermission: Routes("cameraPermission")
    object TakePhotoScreen: Routes("takePhotoScreen")

}