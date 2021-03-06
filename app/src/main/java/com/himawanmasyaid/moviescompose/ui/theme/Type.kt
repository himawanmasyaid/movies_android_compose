package com.himawanmasyaid.moviescompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.himawanmasyaid.moviescompose.R

// Set of Material typography styles to start with
val TextStyleTypography by lazy {
    Typography(
        h1 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = textBlackColor
        ),
        h2 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = textBlackColor
        ),
        h3 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = textBlackColor
        ),
        h4 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = textBlackColor
        ),
        h5 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = textBlackColor
        ),
        subtitle1 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = textBlackColor
        ),
        subtitle2 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = textBlackColor
        ),
        body1 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = textBlackColor
        ),
        body2 = TextStyle(
            fontFamily = FontPrimary,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = textBlackColor
        ),

        /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
    )
}


val FontPrimary = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_regular)
)
