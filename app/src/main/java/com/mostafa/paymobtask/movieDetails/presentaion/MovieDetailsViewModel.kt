package com.mostafa.paymobtask.movieDetails.presentaion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafa.paymobtask.core.domain.Event
import com.mostafa.paymobtask.core.domain.NetworkException
import com.mostafa.paymobtask.core.domain.NetworkUnavailableException
import com.mostafa.paymobtask.core.utils.Logger
import com.mostafa.paymobtask.core.utils.createExceptionHandler
import com.mostafa.paymobtask.movieDetails.domain.GetMovieDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetails: GetMovieDetails,
) : ViewModel() {
    private val _movieDetailsState = MutableStateFlow(MovieDetailsState())
    val movieDetailsState: StateFlow<MovieDetailsState> = _movieDetailsState.asStateFlow()

    fun onEvent(event: MovieDetailsEvent) {
        when (event) {
            is MovieDetailsEvent.LoadMovieDetails -> loadMovieDetails(event.movieId)
        }
    }

    private fun loadMovieDetails(movieId: String) {
        _movieDetailsState.update {
            it.copy(
                isLoading = true,
                movieDetails = null,
            )
        }
        val errorMessage = "Failed to get Movie Details"
        val exceptionHandler = viewModelScope.createExceptionHandler(errorMessage) { onFailure(it) }
        viewModelScope.launch(exceptionHandler) {
            val response = getMovieDetails(movieId)
            _movieDetailsState.update {
                it.copy(
                    isLoading = false,
                    movieDetails = response,
                )
            }
        }
    }


    private fun onFailure(failure: Throwable) {
        when (failure) {
            is NetworkException -> {
                Logger.i("Movie Details Failed: ${failure.code} ")
                _movieDetailsState.update {
                    it.copy(isLoading = false, failure = Event(failure))
                }
            }

            is NetworkUnavailableException -> {
                _movieDetailsState.update {
                    it.copy(isLoading = false, failure = Event(failure))
                }
            }
        }
    }
}