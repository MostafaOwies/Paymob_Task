package com.mostafa.paymobtask.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mostafa.paymobtask.core.presentation.navigation.NavGraph
import com.mostafa.paymobtask.core.presentation.theme.PaymobTaskTheme
import com.mostafa.paymobtask.core.utils.NetworkConnectionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var networkConnectionManager: NetworkConnectionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkConnectionManager.startListenNetworkState()
        enableEdgeToEdge()
        setContent {
            PaymobTaskTheme {
                val navController = rememberNavController()
                val network = networkConnectionManager.isNetworkConnectedFlow.collectAsState()
                val snackBarHostState = remember { SnackbarHostState() }


                Box {
                    Column {
                        if (!network.value) {
                            LaunchedEffect(true) {
                                snackBarHostState.showSnackbar(
                                    message = "No Internet Connection"
                                )
                            }
                        }
                        Scaffold {
                            NavGraph(
                                modifier = Modifier.padding(it),
                                navController = navController
                            )
                        }
                    }
                    SnackbarHost(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        hostState = snackBarHostState,
                        snackbar = {
                            Snackbar(
                                snackbarData = it,
                            )
                        }
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkConnectionManager.stopListenNetworkState()
    }
}
