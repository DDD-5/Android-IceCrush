package com.mmm.icecrush.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mmm.icecrush.R

// Set of Material typography styles to start with

private val montserratBlack = Font(R.font.montserrat_black)
private val gMarketSansMedium = Font(R.font.gmarket_sans_medium)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily(montserratBlack),
        fontWeight = FontWeight.Black,
        fontSize = 44.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily(montserratBlack),
        fontWeight = FontWeight.Black,
        fontSize = 16.sp
    ),

    subtitle2 = TextStyle(
        fontFamily = FontFamily(gMarketSansMedium),
        fontWeight = FontWeight.Black,
        fontSize = 16.sp
    ),

    body1 = TextStyle(
        fontFamily = FontFamily(gMarketSansMedium),
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp
    ),

    body2 = TextStyle(
        fontFamily = FontFamily(gMarketSansMedium),
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp

    ),
    caption = TextStyle(
        fontFamily = FontFamily(gMarketSansMedium),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)