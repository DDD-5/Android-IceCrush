package com.mmm.icecrush

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavController
import androidx.navigation.compose.KEY_ROUTE
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mmm.icecrush.ui.theme.Blue
import com.mmm.icecrush.ui.theme.Red

@SuppressLint("RestrictedApi")
@Composable
fun AppContent(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = when (navController.currentDestination?.arguments?.get(KEY_ROUTE)?.defaultValue
                ?: "") {
                Destinations.Lobby, Destinations.CreateRoom, Destinations.MakeNickname -> Blue
                Destinations.Invitation, Destinations.Room, Destinations.WaitRoom -> Red
                else -> Blue
            }
        )
    }
}