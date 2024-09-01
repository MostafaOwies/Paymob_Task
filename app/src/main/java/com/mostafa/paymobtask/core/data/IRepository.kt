package com.mostafa.paymobtask.core.data

import com.mostafa.paymobtask.movieList.domain.MovieList


interface IRepository {

    suspend fun getMovieList(): MovieList

}