package com.rodrigopr.marcador_presentation.search

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val detectableFood: List<DetectableFoodUiState> = emptyList()
)
