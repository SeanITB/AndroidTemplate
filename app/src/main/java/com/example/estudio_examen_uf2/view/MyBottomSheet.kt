package com.example.estudio_examen_uf2.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.estudio_examen_uf2.ViewModel.AppViewModiel
import com.example.estudio_examen_uf2.navigation.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomSheet(navControllerAuth: NavController, appVM: AppViewModiel) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var titele by rememberSaveable {
        mutableStateOf("")
    }
    var author by rememberSaveable {
        mutableStateOf("")
    }
    var note by rememberSaveable {
        mutableStateOf("")
    }
    ModalBottomSheet(
        onDismissRequest = {
            appVM.changeShowBottomSheet(false)
        },
        sheetState = sheetState
    ) {
        // Sheet content
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTextField(titele, {titele = it}, "Title")
            MyTextField(author, {author = it}, "Author")
            MyTextField(note, {note = it}, "Add note of the book (optional)")
            GoToAddPhoto(navControllerAuth)
            Button(
                onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            appVM.changeShowBottomSheet(false)
                        }
                    }
                }) {
                Text("Hide bottom sheet")
            }

        }
    }
}

@Composable
fun MyTextField(text: String, onTextChange: (String) -> Unit, label: String) {
    TextField(
        value = text,
        onValueChange = {onTextChange(it) },
        placeholder = { Text(label) }
        )
}

@Composable
private fun GoToAddPhoto(navControllerAuth: NavController) {
    IconButton(
        onClick = {
            navControllerAuth.navigate(Routes.CameraPermission.routes)
        }) {
        Icon(imageVector = Icons.Default.PhotoCamera, contentDescription = "Go to take Photo")
    }
}
