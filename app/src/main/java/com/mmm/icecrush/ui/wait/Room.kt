package com.mmm.icecrush.ui.wait

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle.Companion.Packed
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsPadding
import com.mmm.icecrush.Destinations
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.*

@Composable
fun Room(navController: NavController) {

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
                        Button(
                            onClick = {
                                navController.navigate(Destinations.Lobby) {
                                    popUpTo(Destinations.Lobby) { inclusive = false }
                                }
                            },
                            content = {
                                Text(
                                    text = stringResource(id = R.string.exit),
                                    style = MaterialTheme.typography.button
                                )
                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Green,
                                contentColor = Black,
                            ),
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

                val (speakerTitleLayout, speakerProfile, cardLayout, buttonLayout) = createRefs()

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .constrainAs(speakerTitleLayout) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(Red)
                        .padding(0.dp, 20.dp, 0.dp, 68.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.speaker),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(0.dp, 0.dp, 4.5.dp, 0.dp)
                    )
                    Text(
                        text = "비타코코",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(4.5.dp, 0.dp, 0.dp, 0.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .constrainAs(cardLayout) {
                            top.linkTo(speakerTitleLayout.bottom)
                            bottom.linkTo(buttonLayout.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                            height = Dimension.fillToConstraints
                        }
                        .background(Yellow),
                    contentAlignment = Alignment.Center
                ) {
                    QuestionCard(1, "가나다라마바사입니다.")
                    QuestionCard(2, "가나다라마바사입니다.")
                    QuestionCard(3, "가나다라마바사입니다.")
                }

                Image(
                    painter = painterResource(R.drawable.ic_bubble),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(White)
                        .border(
                            width = 3.dp,
                            color = Red,
                            shape = CircleShape
                        )
                        .height(100.dp)
                        .width(100.dp)
                        .constrainAs(speakerProfile) {
                            top.linkTo(speakerTitleLayout.bottom)
                            bottom.linkTo(cardLayout.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .constrainAs(buttonLayout) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                        .background(Black)
                ) {
                    TextButton(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Black,
                            disabledBackgroundColor = Black,
                            contentColor = White,
                            disabledContentColor = Disable
                        ),
                        modifier = Modifier.weight(0.4f)
                    ) {
                        Text(
                            text = stringResource(id = R.string.skip),
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .padding(0.dp, 24.dp),
                            textAlign = TextAlign.Center
                        )
                    }

                    TextButton(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Black,
                            disabledBackgroundColor = Black,
                            contentColor = White,
                            disabledContentColor = Disable
                        ),
                        modifier = Modifier.weight(0.4f)
                    ) {
                        Text(
                            text = stringResource(id = R.string.complete_response),
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .padding(0.dp, 24.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun QuestionCard(index: Int, question: String) {
    Card(
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(38.dp, 24.dp, 38.dp, 34.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Green, shape = CircleShape)
                        .width(36.dp)
                        .height(36.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "01",
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .defaultMinSize(36.dp)
                    )
                }
                Text(
                    text = "우선 간단한 자기소개로 시작해볼까요?",
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
                )
            }
        },
        modifier = Modifier
            .padding(
                (40 - (index - 1) * 4).dp,
                0.dp,
                (40 - (index - 1) * 4).dp,
                ((index - 1) * 15).dp
            )
            .fillMaxWidth(),
        elevation = 3.dp
    )
}

@Composable
@Preview(Destinations.Room)
fun RoomPreview() {
    Room(rememberNavController())
}
