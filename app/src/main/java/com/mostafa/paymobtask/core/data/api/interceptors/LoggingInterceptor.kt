package com.mostafa.paymobtask.core.data.api.interceptors

import com.mostafa.paymobtask.core.utils.Logger
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class LoggingInterceptor @Inject constructor() : HttpLoggingInterceptor.Logger {

  override fun log(message: String) {
    Logger.i(message)
  }
}