package com.demo.code.state

sealed class MainScreenStates {
    //data class AddMarker(val location: LatLng) : MapStates()
    object InitialUiState : MainScreenStates()
    object UiLoadedState : MainScreenStates()
}
