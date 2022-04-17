package com.rodrigopr.marcador_presentation.marcador_overview

import com.rodrigopr.marcador_domain.model.MarcadaFood

sealed class MarcadorOverviewEvent{
    object OnNextDayClick : MarcadorOverviewEvent()
    object OnPreviousDayClick: MarcadorOverviewEvent()
    data class OnToggleMealClick(val meal: Meal): MarcadorOverviewEvent()
    data class OnDeleteMarcadaFoodClick(val marcadafood: MarcadaFood): MarcadorOverviewEvent()
}
