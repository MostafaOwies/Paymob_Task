package com.mostafa.paymobtask.movieList.domain

import com.mostafa.paymobtask.core.data.IRepository
import javax.inject.Inject

class GetMovieList @Inject constructor(
    private val repository: IRepository,
) {
    suspend operator fun invoke(): MovieList {
        return repository.getMovieList()
    }
}
