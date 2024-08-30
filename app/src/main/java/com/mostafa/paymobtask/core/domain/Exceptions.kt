package com.mostafa.paymobtask.core.domain

import java.io.IOException


class NetworkUnavailableException(message: String = "No network available :(") : IOException(message)
class NetworkException(message: String, val code: Int? = null): Exception(message)
