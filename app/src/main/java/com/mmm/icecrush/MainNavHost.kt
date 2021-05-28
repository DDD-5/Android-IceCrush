package com.mmm.icecrush

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.Lobby) {


        composable(Destinations.Lobby) {

        }

        composable(Destinations.CreateRoom){

        }

        composable(Destinations.Invitation){

        }

        composable(Destinations.MakeNickname){

        }

        composable(Destinations.Finish){

        }
    }


}