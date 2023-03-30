package com.sdk.tafakkur.ui.navigation

import androidx.annotation.DrawableRes
import com.sdk.tafakkur.R

sealed class BottomBarScreen(
    val label: String,
    val route: String,
    @DrawableRes val icon: Int
) {
    object HomeScreen: BottomBarScreen(
        label = "Asosiy",
        route = "home",
        icon = R.drawable.house
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