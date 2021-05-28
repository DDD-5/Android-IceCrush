package com.mmm.icecrush

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mmm.icecrush.ui.theme.Blue
import com.mmm.icecrush.ui.theme.Red

@SuppressLint("RestrictedApi")
@Composable
fun AppContent(){
    val systemUiController = rememberSystemUiController()
    val navController = rememberNavController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = when (navController.currentDestination?.displayName) {
                Destinations.Lobby, Destinations.CreateRoom -> Blue
                Destinations.Invitation, Destinations.Room, Destinations.WaitRoom -> Red
                else -> Blue
            }
        )
    }
}