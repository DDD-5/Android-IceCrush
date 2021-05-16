package com.mmm.icecrush.ui.lobby

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.Black
import com.mmm.icecrush.ui.theme.Blue
import com.mmm.icecrush.ui.theme.Red
import com.mmm.icecrush.ui.theme.Yellow


@Composable
fun Lobby(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Ice Crush",
                            style = MaterialTheme.typography.subtitle1,
                            textAlign = TextAlign.Center,
                            color = Black
                        )
                    }
                }
            )
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Blue)
                    .fillMaxHeight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(57.dp, 40.dp, 57.dp, 46.dp)
                ) {
                    Text(
                        text = "Let's break some ice!",
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Red)
                        .weight(1f)
                        .clickable {
                            navController.navigate("create")
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "방 열기",
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(26.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_go),
                        contentDescription = "방 열기",
                        alignment = Alignment.CenterEnd,
                        modifier = Modifier.padding(0.dp, 0.dp, 26.dp, 0.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Yellow)
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "방 들어가기",
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(26.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_go),
                        contentDescription = "방 열기",
                        alignment = Alignment.CenterEnd,
                        modifier = Modifier.padding(0.dp, 0.dp, 26.dp, 0.dp)
                    )
                }
            }


        }
    )
}

@Composable
@Preview("lobby")
fun LobbyPreview() {
    Lobby(rememberNavController())
}

