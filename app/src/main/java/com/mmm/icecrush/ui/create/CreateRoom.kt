package com.mmm.icecrush.ui.create

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.lobby.Lobby
import com.mmm.icecrush.ui.theme.Black
import com.mmm.icecrush.ui.theme.Blue
import com.mmm.icecrush.ui.theme.Green
import com.mmm.icecrush.ui.theme.Pink


@Composable
fun CreateRoom() {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "뒤로가기",
                        modifier = Modifier.padding(23.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Text(
                        text = "단계 선택",
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Center,
                        color = Black,
                    )
                }
            )
        },
        content = {

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f)
                    .background(Blue)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(57.dp, 40.dp, 57.dp, 46.dp)
                ) {
                    Text(
                        text = "How Close are you?",
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .background(Green),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "오늘 처음 만났어요",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(30.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_highfive),
                        contentDescription = "오늘 처음 만났어요",
                        modifier = Modifier.padding(0.dp, 56.dp, 28.dp, 56.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .background(Pink)
                        .fillMaxWidth(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "더 친해지고 싶어요",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(30.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_bubble),
                        contentDescription = "더 친해지고 싶어",
                        modifier = Modifier.padding(0.dp, 56.dp, 28.dp, 56.dp)
                    )
                }
            }
        }
    )
}

@Composable
@Preview("create")
fun CreateRoomPreview() {
    CreateRoom()
}


