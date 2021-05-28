package com.mmm.icecrush.ui.finish

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsPadding
import com.mmm.icecrush.AppContent
import com.mmm.icecrush.Destinations
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.Black
import com.mmm.icecrush.ui.theme.Pink
import com.mmm.icecrush.ui.theme.Red
import com.mmm.icecrush.ui.theme.White

@Composable
fun Finish(
    navController: NavController
) {
    AppContent(navController = rememberNavController())
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                contentColor = Black,
                backgroundColor = Red
            ) {
                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (navIcon, shareButton) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = stringResource(id = R.string.want_close),
                        modifier = Modifier
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(false, 24.dp, White)
                            ) {
                                navController.navigate(Destinations.Lobby)
                            }
                            .constrainAs(navIcon) {
                                start.linkTo(parent.start, 16.dp)
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = stringResource(id = R.string.share),
                        modifier = Modifier
                            .constrainAs(shareButton) {
                                end.linkTo(parent.end, 12.dp)
                                centerVerticallyTo(parent)
                            }
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(false, 24.dp, White)
                            ) {

                            }
                    )
                }
            }
        },
        backgroundColor = Red
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .navigationBarsPadding()
        ) {
            val (imageFinish, textFinish, viewSummary) = createRefs()
            Image(
                modifier = Modifier.constrainAs(imageFinish) {
                    centerHorizontallyTo(parent)
                    top.linkTo(parent.top, 60.dp)
                },
                painter = painterResource(id = R.drawable.ic_finish),
                contentDescription = stringResource(id = R.string.finish)
            )
            Text(
                text = stringResource(id = R.string.finish_title),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.constrainAs(textFinish) {
                    centerHorizontallyTo(parent)
                    top.linkTo(imageFinish.bottom, 34.dp)
                },
                color = Black
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .constrainAs(viewSummary) {
                        start.linkTo(parent.start)
                        top.linkTo(textFinish.bottom, 44.dp)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    }.background(Pink)
            ){
                Text(
                    text = stringResource(id = R.string.finish_summary_title),
                    style = MaterialTheme.typography.body1,
                    color = Black
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(id = R.string.finish_summary_content),
                    style = MaterialTheme.typography.body1,
                    color = Black
                )
            }
        }
    }
}

@Composable
@Preview(Destinations.Finish)
fun FinishPreview() {
    Finish(rememberNavController())
}