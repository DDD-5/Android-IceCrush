package com.mmm.icecrush

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mmm.icecrush.ui.create.CreateRoom
import com.mmm.icecrush.ui.lobby.Lobby
import com.mmm.icecrush.ui.theme.IceCrushTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IceCrushTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "create") {
                    composable("lobby") { Lobby() }
                    composable("create") { CreateRoom() }
                }
            }
        }
    }
}

