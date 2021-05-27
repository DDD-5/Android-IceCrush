package com.mmm.icecrush.ui.makenickname

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.mmm.icecrush.Destinations
import com.mmm.icecrush.R
import com.mmm.icecrush.ui.theme.*

@Composable
fun MakeNickname(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                contentColor = Black,
                backgroundColor = Blue
            ){
                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                    val (navIcon, title, confirmButton) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = stringResource(id = R.string.nickname_make_go_back),
                        modifier = Modifier
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(false, 24.dp, White)
                            ) {
                                navController.popBackStack()
                            }
                            .constrainAs(navIcon) {
                                start.linkTo(parent.start, 16.dp)
                            }
                    )
                    Text(
                        text = stringResource(id = R.string.nickname_make_title),
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.constrainAs(title){
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            centerVerticallyTo(parent)
                        }
                    )
                    Text(
                        text = stringResource(id = R.string.nickname_make_confirm),
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier
                            .constrainAs(confirmButton) {
                                end.linkTo(parent.end, 16.dp)
                                centerVerticallyTo(parent)
                            }
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(false, 24.dp, White)
                            ) {
                                navController.navigate(Destinations.WaitRoom)
                            }
                    )
                }
            }
        },
        backgroundColor = Blue
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            val textState = remember { mutableStateOf("") }
            val (tilNickname, textHelper) = createRefs()
            val isValid = textState.value.count() <= 6
            TextField(
                value = textState.value,
                onValueChange = { if(it.trim().length <= 6) textState.value = it.trim() },
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(tilNickname) {
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                        top.linkTo(parent.top, 48.dp)
                    },
                singleLine = true,
                textStyle = MaterialTheme.typography.body2,
                shape = MaterialTheme.shapes.small.copy(ZeroCornerSize),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = White,
                    cursorColor = White,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = White,
                    unfocusedIndicatorColor = White,
                    placeholderColor = SkyBlue
                ),
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.nickname_make_hint),
                        style = MaterialTheme.typography.body2
                    )
                }
            )
            Text(
                modifier = Modifier.constrainAs(textHelper){
                    top.linkTo(tilNickname.bottom, 16.dp)
                    end.linkTo(tilNickname.end)
                },
                text = if(isValid) "${textState.value.count()}/6" else "6/6" ,
                color = White,
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}

@Composable
fun MakeNicknameNavIcon(onNavIconClick: () -> Boolean){
    Image(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = stringResource(id = R.string.nickname_make_go_back),
        modifier = Modifier
            .clickable {
                onNavIconClick()
            }
            .padding(16.dp, 0.dp, 0.dp, 0.dp)
    )
}

@Composable
@Preview(Destinations.MakeNickname)
fun MakeNicknamePreview() {
    MakeNickname(rememberNavController())
}
