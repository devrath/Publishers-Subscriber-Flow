package com.demo.code

sealed class MainScreenStates {
    //data class AddMarker(val location: LatLng) : MapStates()
    object InitialUiState : MainScreenStates()
    object UiLoadedState : MainScreenStates()
}
