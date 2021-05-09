package com.mmm.icecrush

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmm.icecrush.ui.theme.Blue
import com.mmm.icecrush.ui.theme.Red
import com.mmm.icecrush.ui.theme.Yellow


@Composable
fun Lobby() {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Blue)
                .weight(2.4f)
        ) {
            Text(
                text = "IceCrush",
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(0.dp, 14.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "Let's break some ice!",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(48.dp, 40.dp, 48.dp, 44.dp)
                    .fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Red)
                .weight(2f),
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
                .weight(2f),
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

@Composable
@Preview("lobby")
fun LobbyPreview() {
    Lobby()
}