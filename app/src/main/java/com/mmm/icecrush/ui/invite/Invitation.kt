package com.mmm.icecrush.ui.invite

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.Black
import com.mmm.icecrush.ui.theme.Pink
import com.mmm.icecrush.ui.theme.Red
import com.mmm.icecrush.ui.theme.White


@Composable
fun Invitation(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { InvitationAppBar(onNavigationClick = { navController.popBackStack() }) },
        backgroundColor = Red
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (image, title, shareButton, confirmButton) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.ic_success),
                contentDescription = "success",
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top, 60.dp)
                        centerHorizontallyTo(parent)
                    }
            )
            Text(
                text = stringResource(id = R.string.invitation_title),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(image.bottom, 40.dp)
                        centerHorizontallyTo(parent)
                    },
                style = MaterialTheme.typography.body2,
                color = White,
            )
            Button(
                onClick = { } ,
                modifier = Modifier.constrainAs(shareButton) {
                    top.linkTo(title.bottom, 28.dp)
                    centerHorizontallyTo(parent)
                },
                colors = ButtonDefaults
                    .buttonColors(
                        backgroundColor = Pink,
                        contentColor = Black
                    ),
                shape = RoundedCornerShape(24.dp),
                contentPadding = PaddingValues(start = 20.dp, top = 13.dp, end = 20.dp, bottom = 13.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.invitation_share),
                    style = MaterialTheme.typography.caption
                )
            }
            Button(
                onClick = {  },
                modifier = Modifier
                    .constrainAs(confirmButton) {
                        bottom.linkTo(parent.bottom)
                        centerHorizontallyTo(parent)
                    }
                    .fillMaxWidth(),
                colors = ButtonDefaults
                    .buttonColors(
                        backgroundColor = Black,
                        contentColor = White
                    ),
                contentPadding = PaddingValues(top = 24.dp, bottom = 24.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.invitation_confirm),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
private fun InvitationAppBar(
    onNavigationClick: () -> Boolean
) {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(start = 109.dp),
                text = stringResource(id = R.string.invitation),
                style = MaterialTheme.typography.subtitle2
            )
        },
        navigationIcon = {
            Image(
                modifier = Modifier
                    .padding(16.dp, 0.dp, 0.dp, 0.dp)
                    .clickable {
                        onNavigationClick()
                    },
                contentDescription = "뒤로가기",
                painter = painterResource(id = R.drawable.ic_back),
            )
        },
        backgroundColor = Red,
        elevation = 0.dp
    )
}

@Composable
@Preview("invite")
fun InvitationPreview() {
    Invitation(rememberNavController())
}