package com.mostafa.paymobtask.core.utils

import android.content.Context
import android.net.*
import android.os.Build
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectionManager @Inject constructor(@ApplicationContext private val context: Context) {

    val isConnected: Boolean
        get() = _isConnected.get()

    private val _isConnected = AtomicBoolean(false)

    init {
        listenToNetworkChanges()
    }

    private fun listenToNetworkChanges() {
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                _isConnected.set(true)
            }

            override fun onLost(network: Network) {
                _isConnected.set(false)
            }
        }

        // Use the appropriate method to get ConnectivityManager based on API level
        val connectivityManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.getSystemService(ConnectivityManager::class.java)
        } else {
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // For API level 24 and above (Android 7.0+)
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        } else {
            // For API level 21 to 23 (Android 5.0 to 6.0)
            try {
                connectivityManager.requestNetwork(networkRequest, networkCallback)
            } catch (e: SecurityException) {
                // Handle potential SecurityException if it occurs
                println("Security exception: ${e.message}")
            }
        }
    }
}
