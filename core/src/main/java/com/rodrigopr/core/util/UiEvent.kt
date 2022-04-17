package com.rodrigopr.core.util

sealed class UiEvent{
    object  Success: UiEvent()
    object navigateUp: UiEvent()
    data class ShowSnackBar(val message: UiText): UiEvent()

}