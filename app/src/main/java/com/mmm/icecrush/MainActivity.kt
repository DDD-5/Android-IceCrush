package com.mmm.icecrush

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.mmm.icecrush.ui.create.CreateRoom
import com.mmm.icecrush.ui.invite.Invitation
import com.mmm.icecrush.ui.lobby.Lobby
import com.mmm.icecrush.ui.wait.WaitRoom
import com.mmm.icecrush.ui.theme.IceCrushTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets {
                IceCrushTheme {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Destinations.WaitRoom,
                        modifier = Modifier.statusBarsPadding()
                    ) {
                        composable(Destinations.Lobby) { Lobby(navController) }
                        composable(Destinations.CreateRoom) { CreateRoom(navController) }
                        composable(Destinations.WaitRoom) { WaitRoom(navController = navController, list = listOf("1","2"))}
                        composable(Destinations.Invitation){ Invitation(navController) }
                    }
                }
            }
        }
    }
}

