package com.mostafa.paymobtask.core.data

import com.mostafa.paymobtask.core.data.api.MovieListApi
import com.mostafa.paymobtask.core.data.api.model.mappers.ApiMovieListMapper
import com.mostafa.paymobtask.core.domain.NetworkException
import com.mostafa.paymobtask.core.utils.Constants.API_KEY
import com.mostafa.paymobtask.movieList.domain.MovieList
import retrofit2.HttpException
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiMovieListMapper: ApiMovieListMapper,
    private val movieListApi: MovieListApi,
) : IRepository {

    override suspend fun getMovieList(): MovieList {
        try {
            return apiMovieListMapper.mapToDomain(
                movieListApi.getMovieList(apiKey = API_KEY)
            )
        } catch (e: HttpException) {
            throw handleException(exception = e)
        }
    }

    private fun handleException(exception: HttpException): Exception {
        return when (exception.code()) {
            422 -> NetworkException(
                code = exception.code()
            )

            else -> {
                throw NetworkException(
                    message = exception.message ?: "Code ${exception.code()}",
                    code = exception.code()
                )
            }
        }
    }
}