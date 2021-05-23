package com.mmm.icecrush.ui.wait

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsPadding
import com.mmm.icecrush.Destinations
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.Black
import com.mmm.icecrush.ui.theme.Disable
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
                            contentDescription = stringResource(id = R.string.leave_room),
                            modifier = Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(false, 24.dp, White)
                            ) {
                                navController.popBackStack()
                            }
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_share),
                            contentDescription = stringResource(id = R.string.share),
                            modifier = Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(false, 24.dp, White)
                            ) {

                            }
                        )
                    }
                },
                backgroundColor = Red
            )

        },
        content = {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .navigationBarsPadding()
            ) {

                val (title, userCount, grid, button) = createRefs()

                Text(
                    style = MaterialTheme.typography.h1,
                    text = stringResource(id = R.string.room_wait_title),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentHeight()
                        .background(Red)
                        .padding(69.dp, 16.dp, 69.dp, 71.dp)
                        .constrainAs(title) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                )

                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    modifier = Modifier
                        .constrainAs(grid) {
                            top.linkTo(title.bottom)
                            bottom.linkTo(button.top)
                            height = Dimension.fillToConstraints
                        }
                        .background(Pink)
                        .clipToBounds(),
                    contentPadding = PaddingValues(0.dp, 64.dp, 0.dp, 0.dp)
                ) {
                    items(list.size) { index ->
                        UserProfile(true, index)
                    }
                }

                Button(
                    onClick = {

                    },
                    colors = buttonColors(
                        backgroundColor = Black,
                        disabledBackgroundColor = Black,
                        contentColor = White,
                        disabledContentColor = Disable
                    ),
                    modifier = Modifier
                        .constrainAs(button) {
                            bottom.linkTo(parent.bottom)
                        }
                        .fillMaxWidth()
                        .height(68.dp),
                    content = {
                        Text(
                            text = stringResource(id = R.string.start),
                            style = MaterialTheme.typography.body2
                        )
                    },
                    shape = RoundedCornerShape(0)
                )

                Card(
                    shape = RoundedCornerShape(30.dp),
                    backgroundColor = Green,
                    modifier = Modifier
                        .constrainAs(userCount) {
                            top.linkTo(title.bottom)
                            bottom.linkTo(grid.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .height(64.dp)
                        .width(104.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = stringResource(
                                id = R.string.current_user_count,
                                1
                            )
                        )
                        Text(text = "1", style = MaterialTheme.typography.body2)
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
                .border(
                    width = if (isOwner) 3.dp else 0.dp,
                    color = Red,
                    shape = CircleShape
                )
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
