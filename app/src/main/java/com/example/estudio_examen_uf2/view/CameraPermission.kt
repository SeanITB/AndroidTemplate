package com.example.estudio_examen_uf2.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.estudio_examen_uf2.ViewModel.AppViewModiel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.estudio_examen_uf2.navigation.Routes
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale



@Composable
fun CameraPermission(navController: NavController, appVM: AppViewModiel) {
    val context = LocalContext.current
    val isCameraPermissionGranted by appVM.cameraPermissionGrnaded.observeAsState(false)
    val shouldShowPermissionRationale by appVM.shouldShowPermissionRationale.observeAsState(false)
    val showPermissionDenied by appVM.showPermissionDenied.observeAsState(false)
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                appVM.changeCameraPermissionGranted(true)
            } else {
                appVM.changeShouldShowPermissionRationale(
                    shouldShowRequestPermissionRationale(
                        context as Activity,
                        Manifest.permission.CAMERA
                    )
                )
                if (!shouldShowPermissionRationale) {
                    Log.i("CameraPermission", "showPermissionDenied")
                    appVM.changeShowPermissionDenied(true)
                }
            }

        }
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                if (!isCameraPermissionGranted) {
                    launcher.launch(Manifest.permission.CAMERA)
                } else {
                    navController.navigate(Routes.TakePhotoScreen.routes)
                }
            }
        ) {
            Text(text = "Take Photo")
        }
    }
    if (showPermissionDenied) {
        PermissionDeniedScreen()
    }
}

@Composable
fun PermissionDeniedScreen() {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
        ) {
        Text(text = "Permission denied")
        Button(
            onClick = {
                openAppSettings(context as Activity)
            }
        ) {
            Text(text = "Open app settings")
        }
    }
}

fun openAppSettings(activity: Activity) {
    val intent = Intent().apply {
        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        data = Uri.fromParts("package", activity.packageName, null)
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    activity.startActivity(intent)
}

