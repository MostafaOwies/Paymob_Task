package com.mostafa.paymobtask.movieDetails.presentaion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import coil.compose.AsyncImage
import com.mostafa.paymobtask.R
import com.mostafa.paymobtask.core.utils.ComposableLifecycle
import com.mostafa.paymobtask.core.utils.Logger

@Composable
fun MovieDetailsScreen(
    movieId: String?,
) {

    val viewModel = hiltViewModel<MovieDetailsViewModel>()
    ComposableLifecycle { _, event ->
        if (event == Lifecycle.Event.ON_CREATE) {
            viewModel.onEvent(MovieDetailsEvent.LoadMovieDetails(movieId))
        }
    }

    val state = viewModel.movieDetailsState.collectAsState().value

    Logger.i("MOVIE DETAILS ${state.movieDetails}")


    var isFavorite by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {}
            .padding(8.dp) // Add padding around the entire column
    ) {
        // Movie Item
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp), // Add vertical padding between items
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Movie Poster
            AsyncImage(
                model = state.movieDetails?.poster,
                contentDescription = "Movie Poster",
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 8.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                // Movie Tite
                state.movieDetails?.originalTitle?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }

                // Release Year, Duration, and Rating
                state.movieDetails?.releaseDate?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
                state.movieDetails?.originalLanguage?.let {
                    Text(
                        text = "language: $it",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }

                // Movie Rating
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rating), // Star Icon
                        contentDescription = "Rating",
                        tint = Color(0xFFFFD700), // Golden color for star
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "${state.movieDetails?.rating} (${state.movieDetails?.voteCount})",
                        color = Color.Gray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            // Favorite Icon Button
            IconButton(
                onClick = { isFavorite = !isFavorite }
            ) {
                Icon(
                    painter = painterResource(if (isFavorite) R.drawable.ic_fav_filled else R.drawable.ic_fav_emp),
                    contentDescription = "Add to Favorite",
                    tint = if (isFavorite) Color.Red else Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 8.dp), // Add horizontal padding for the divider
            thickness = 1.dp,
            color = Color.Gray
        )
        state.movieDetails?.overview?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}