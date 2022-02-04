package com.himawanmasyaid.moviescompose.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.himawanmasyaid.moviescompose.ui.theme.bgLineColor
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.BitmapPalette
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ImageLoadDrawable(painter: Painter, modifier: Modifier, contentDescription: String? = "") {

    Box(
        modifier = modifier
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

@Composable
fun ImageLoadPoster(imageUrl: String, modifier: Modifier) {

    val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w342"

//    @PreviewParameter(NetworkUrlPreviewProvider::class) networkUrl: Any?,
//    modifier: Modifier = Modifier,
//    circularReveal: CircularReveal? = null,
//    contentScale: ContentScale = ContentScale.FillBounds,
//    bitmapPalette: BitmapPalette? = null,
//    shimmerParams: ShimmerParams? = ShimmerParams(
//    baseColor = MaterialTheme.colors.background,
//    highlightColor = shimmerHighLight,
//    dropOff = 0.65f
//    ),
//    ) {
    val url = BASE_POSTER_PATH + imageUrl

    var palette by remember { mutableStateOf<Palette?>(null) }

    CoilImage(
        imageModel = url,
        modifier = modifier,
//        contentScale = contentScale,
//        circularReveal = circularReveal,
        bitmapPalette = BitmapPalette {
            palette = it
        },
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = bgLineColor,
            durationMillis = 1000,
            dropOff = 0.65f,
            tilt = 20f
        ),
        failure = {
            Text(
                text = "Image failed.",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.fillMaxSize()
            )
        }
    )

//        if (shimmerParams == null) {
//            CoilImage(
//                imageModel = url,
//                modifier = modifier,
//                contentScale = contentScale,
//                circularReveal = circularReveal,
//                bitmapPalette = bitmapPalette,
//                failure = {
//                    Text(
//                        text = "Image failed.",
//                        textAlign = TextAlign.Center,
//                        style = MaterialTheme.typography.body2,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            )
//        } else {
//            CoilImage(
//                imageModel = url,
//                modifier = modifier,
//                contentScale = contentScale,
//                circularReveal = circularReveal,
//                bitmapPalette = bitmapPalette,
//                shimmerParams = shimmerParams,
//                failure = {
//                    Text(
//                        text = "Image Failed.",
//                        textAlign = TextAlign.Center,
//                        style = MaterialTheme.typography.body2,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            )
//        }

}


@Preview(
    showBackground = true
)
@Composable
private fun PreviewImageExtension() {
    ImageLoadPoster(
        "/bpmLMZP3M1vLujPqHnOTnKVjRJY.jpg",
        modifier = Modifier.fillMaxWidth()
            .height(300.dp)
        )
}
