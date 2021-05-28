package com.mmm.icecrush.ui.wait

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import androidx.navigation.compose.rememberNavController
import com.mmm.icecrush.Destinations
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.Black
import com.mmm.icecrush.ui.theme.Green
import com.mmm.icecrush.ui.theme.Red
import com.mmm.icecrush.ui.theme.White

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

            ConstraintLayout {
                val (speakerTitle, speakerProfile, card, skip, next) = createRefs()
            }


        }
    )
}

@Composable
@Preview(Destinations.WaitRoom)
fun RoomPreview() {
    Room(rememberNavController())
}
