package com.example.estudio_examen_uf2.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModiel: ViewModel() {
    private val _cameraPermissionGranded = MutableLiveData(false)
    val cameraPermissionGrnaded = _cameraPermissionGranded

    private val _shouldShowPermissionRationale = MutableLiveData(false)
    val shouldShowPermissionRationale = _shouldShowPermissionRationale

    private val _showPermissionDenied = MutableLiveData(false)
    val showPermissionDenied = _showPermissionDenied

    private val _showBottomSheet = MutableLiveData(false)
    val showBottomSheet = _showBottomSheet

    fun changeCameraPermissionGranted(granted: Boolean) {
        _cameraPermissionGranded.value = granted
    }

    fun changeShouldShowPermissionRationale(show: Boolean) {
        _shouldShowPermissionRationale.value = show
    }

    fun changeShowPermissionDenied(show: Boolean) {
        _showPermissionDenied.value = show
    }

    fun changeShowBottomSheet(show: Boolean) {
        _showBottomSheet.value = show
    }
}
