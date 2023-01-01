package com.demo.code

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainVm : ViewModel() {

    // Expose screen UI state
    private val _uiState = MutableStateFlow<MainScreenStates>(MainScreenStates.InitialUiState)
    val uiState: StateFlow<MainScreenStates> = _uiState.asStateFlow()

    fun uiLoaded() {

        _uiState.value = MainScreenStates.UiLoadedState
    }

}