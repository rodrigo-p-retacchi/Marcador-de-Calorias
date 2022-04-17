package com.rodrigopr.marcador_presentation.search

import com.rodrigopr.marcador_domain.model.DetectableFood

data class DetectableFoodUiState(
    val food: DetectableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)