package com.himawanmasyaid.moviescompose.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.himawanmasyaid.moviescompose.ui.theme.bgLineColor
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun ImageLoadDrawable(painter: Painter, height: Int, contentDescription: String? = "") {

    Box(
        modifier = Modifier
            .height(height.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize()
        )
    }

}

@Composable
fun ImageLoadUrl(url: String) {

    GlideImage( // CoilImage, FrescoImage
        imageModel = url,
        // shows a shimmering effect when loading an image.
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = bgLineColor,
            durationMillis = 350,
            dropOff = 0.65f,
            tilt = 20f
        ),
        // shows an error text message when request failed.
        failure = {
            Text(text = "image request failed.")
        })

}

@Composable
fun ImageRoundedLoadUrl(url: String, rounded: Int) {

    GlideImage( // CoilImage, FrescoImage
        imageModel = url,
        modifier = Modifier.clip(RoundedCornerShape(rounded.dp)),
        // shows a shimmering effect when loading an image.
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = bgLineColor,
            durationMillis = 350,
            dropOff = 0.65f,
            tilt = 20f
        ),

        // shows an error text message when request failed.
        failure = {
            Text(text = "image request failed.")
        })

}