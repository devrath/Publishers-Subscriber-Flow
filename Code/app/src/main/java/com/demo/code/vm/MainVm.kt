package com.demo.code.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.code.observerLibrary.PublisherEventBus
import com.demo.code.observerLibrary.EventAction
import com.demo.code.state.MainScreenStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MainVm : ViewModel() {

    private val _uiState = MutableStateFlow<MainScreenStates>(MainScreenStates.InitialUiState)
    val uiState: StateFlow<MainScreenStates> = _uiState.asStateFlow()

    fun uiLoaded() {
        _uiState.value = MainScreenStates.UiLoadedState
    }

    fun triggerEventOne() {
        viewModelScope.launch {
            PublisherEventBus.publish(EventAction("Event-1"))
        }
    }

    fun triggerEventTwo() {
        viewModelScope.launch {
            PublisherEventBus.publish(EventAction("Event-2"))
        }
    }
}