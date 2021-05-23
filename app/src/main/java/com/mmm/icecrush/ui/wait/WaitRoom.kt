package com.mmm.icecrush.ui.wait

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mmm.icecrush.Destinations
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.Green
import com.mmm.icecrush.ui.theme.Pink
import com.mmm.icecrush.ui.theme.Red
import com.mmm.icecrush.ui.theme.White

@ExperimentalFoundationApi
@Composable
fun WaitRoom(navController: NavController, list: List<String>) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                content = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_close),
                            contentDescription = stringResource(id = R.string.leave_room)
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_share),
                            contentDescription = stringResource(id = R.string.share),
                        )
                    }
                },
                backgroundColor = Red
            )

        },
        content = {
            Column {
                Box(
                    modifier = Modifier
                        .background(Red)
                        .padding(0.dp, 16.dp, 0.dp, 71.dp)
                ) {
                    Text(
                        style = MaterialTheme.typography.h1,
                        text = stringResource(id = R.string.room_wait_title),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

                Box(
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .background(Red)
                                .fillMaxWidth(1f)
                                .height(32.dp)
                        )
                        Box(
                            modifier = Modifier
                                .background(Pink)
                                .fillMaxWidth(1f)
                                .height(32.dp)
                        )
                    }
                    Card(
                        shape = RoundedCornerShape(30.dp),
                        backgroundColor = Green,
                        modifier = Modifier
                            .height(64.dp)
                            .width(104.dp)
                            .align(Alignment.Center),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_profile),
                                contentDescription = stringResource(id = R.string.current_user_count,1)
                            )
                            Text(text = "1", style = MaterialTheme.typography.body2)
                        }

                    }

                }
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    modifier = Modifier
                        .background(Pink)
                        .fillMaxHeight()
                ) {
                    items(list.size) { index ->
                        UserProfile(false, index)
                    }

                }
            }
        }
    )
}

@Composable
fun UserProfile(isOwner: Boolean, index: Int) {
    val startPadding = if (index % 2 == 0) 52.dp else 28.dp
    val endPadding = if (index % 2 == 0) 28.dp else 52.dp
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(startPadding, 20.dp, endPadding, 0.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_bubble),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .background(White)
                .alpha(0.5f)
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Text(
            text = "비타코코",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp)
        )
    }
}

@ExperimentalFoundationApi
@Composable
@Preview(Destinations.WaitRoom)
fun RoomPreview() {
    WaitRoom(rememberNavController(), listOf("1", "2", "3"))
}
