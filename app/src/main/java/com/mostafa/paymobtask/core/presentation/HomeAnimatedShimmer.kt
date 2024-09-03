package com.mostafa.paymobtask.core.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeAnimatedShimmer(showShimmer: Boolean) {
    if (showShimmer) {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f)
        )
        val transient = rememberInfiniteTransition(label = "InfiniteStateAnimation")
        val translateAnim = transient.animateFloat(
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            ), label = "FloatAnimation"
        )

        val brush = Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnim.value, y = translateAnim.value)
        )
        Column {
            repeat(4) {
                ShimmerListItem(brush = brush)
            }
        }
    }
}


@Composable
fun ShimmerListItem(brush: Brush) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.7f)
                .clip(MaterialTheme.shapes.medium)
                .background(brush)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.4f)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(brush)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.3f)
                .clip(MaterialTheme.shapes.medium)
                .background(brush)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.4f)
                .clip(MaterialTheme.shapes.medium)
                .background(brush)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 1f)
                .clip(MaterialTheme.shapes.medium)
                .background(brush)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 1f)
                .clip(MaterialTheme.shapes.medium)
                .background(brush)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(fraction = 0.8f)
                .clip(MaterialTheme.shapes.medium)
                .background(brush)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(shape = MaterialTheme.shapes.medium)
                .fillMaxWidth(fraction = 0.15f)
                .background(brush)
        )

    }


}


@Preview(showBackground = true)
@Composable
fun ShimmerItemsPreview() {

    HomeAnimatedShimmer(showShimmer = true)
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ShimmerItemsDarkPreview() {
    ShimmerListItem(
        brush = Brush.linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.6f),
                Color.LightGray.copy(alpha = 0.2f),
                Color.LightGray.copy(alpha = 0.6f)
            )
        )
    )
}
