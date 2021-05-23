package com.mmm.icecrush.ui.create

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.mmm.icecrush.Destinations
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.Black
import com.mmm.icecrush.ui.theme.Blue
import com.mmm.icecrush.ui.theme.Green
import com.mmm.icecrush.ui.theme.Pink
import com.mmm.icecrush.ui.theme.White


@Composable
fun CreateRoom(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                content = {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = stringResource(id = R.string.share),
                            modifier = Modifier
                                .padding(16.dp, 0.dp, 0.dp, 0.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(true, 12.dp, White)
                                ) {
                                    navController.popBackStack()
                                }
                        )

                        Column(
                            modifier = Modifier.fillMaxWidth(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(id = R.string.select_type),
                                style = MaterialTheme.typography.subtitle2,
                                textAlign = TextAlign.Center,
                                color = Black
                            )
                        }
                    }
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
                        text = stringResource(id = R.string.select_type_title),
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Center
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .background(Green)
                        .clickable {
                            navController.navigate("invite")
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.met_first_today),
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(30.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_highfive),
                        contentDescription = stringResource(id = R.string.met_first_today),
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
                        text = stringResource(id = R.string.want_close),
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(30.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_bubble),
                        contentDescription = stringResource(id = R.string.want_close),
                        modifier = Modifier.padding(0.dp, 56.dp, 28.dp, 56.dp)
                    )
                }
            }
        }
    )
}

@Composable
@Preview(Destinations.CreateRoom)
fun CreateRoomPreview() {
    CreateRoom(rememberNavController())
}


