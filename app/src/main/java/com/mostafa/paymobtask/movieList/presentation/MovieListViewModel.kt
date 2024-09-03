package com.mostafa.paymobtask.movieList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.paymobtask.core.domain.Event
import com.mostafa.paymobtask.core.domain.NetworkException
import com.mostafa.paymobtask.core.domain.NetworkUnavailableException
import com.mostafa.paymobtask.core.utils.Logger
import com.mostafa.paymobtask.core.utils.createExceptionHandler
import com.mostafa.paymobtask.movieList.domain.GetMovieList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieList: GetMovieList,
) : ViewModel() {
    private val _movieListState = MutableStateFlow(MovieListState())
    val movieListState: StateFlow<MovieListState> = _movieListState.asStateFlow()

    fun onEvent(event: MovieListEvent) {
        when (event) {
            is MovieListEvent.LoadMovieList -> loadMovieList()
        }
    }

    private fun loadMovieList() {
        _movieListState.update {
            it.copy(
                isLoading = true,
                movieList = null,
            )
        }
        val errorMessage = "Failed to get Movie List"
        val exceptionHandler = viewModelScope.createExceptionHandler(errorMessage) { onFailure(it) }
        viewModelScope.launch(exceptionHandler) {
            val response = getMovieList()
            _movieListState.update {
                it.copy(
                    isLoading = false,
                    movieList = response,
                )
            }
        }
    }


    private fun onFailure(failure: Throwable) {
        when (failure) {
            is NetworkException -> {
                Logger.i("Movie List Failed: ${failure.code} ")
                _movieListState.update {
                    it.copy(isLoading = false, failure = Event(failure))
                }
            }

            is NetworkUnavailableException -> {
                _movieListState.update {
                    it.copy(isLoading = false, failure = Event(failure))
                }
            }
        }
    }
}