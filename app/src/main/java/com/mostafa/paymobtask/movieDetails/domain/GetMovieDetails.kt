package com.mostafa.paymobtask.movieDetails.domain

import com.mostafa.paymobtask.core.data.IRepository
import javax.inject.Inject

class GetMovieDetails @Inject constructor(
    private val repository: IRepository,
) {
    suspend operator fun invoke(
        movieId: String?,
    ): MovieDetails {
        return repository.getMovieDetails(
            movieId = movieId
        )
    }
}