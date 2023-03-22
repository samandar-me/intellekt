package com.sdk.tafakkur.ui.navigation

import androidx.annotation.DrawableRes
import com.sdk.tafakkur.R

sealed class BottomBarScreen(
    val label: String,
    val route: String,
    @DrawableRes val icon: Int
) {
    object HomeScreen: BottomBarScreen(
        label = "O'yin",
        route = "home",
        icon = R.drawable.ic_game
    )
    object Statistics: BottomBarScreen(
        label = "Reyting",
        route = "rating",
        icon = R.drawable.diagram
    )
    object Settings: BottomBarScreen(
        label = "Sozlamalar",
        route = "settings",
        icon = R.drawable.setting
    )
}