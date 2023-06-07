package com.nrup.datapassingincompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MySharedVM() : ViewModel() {

    private val _vmData = mutableStateOf("")
    var vmData: State<String> = _vmData

    fun setThirdScreenData(value: String) {
        _vmData.value = value
    }

}