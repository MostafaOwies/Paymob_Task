package com.mostafa.paymobtask.core.data.api.interceptors

import com.Aqua_waterfliter.technician_app.jobOrderDetails.domain.model.NetworkUnavailableException
import com.mostafa.paymobtask.core.utils.ConnectionManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkStatusInterceptor @Inject constructor(
    private val connectionManager: ConnectionManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
      return if (connectionManager.isConnected) {
        chain.proceed(chain.request())
      } else {
          throw NetworkUnavailableException()
      }
    }
}
