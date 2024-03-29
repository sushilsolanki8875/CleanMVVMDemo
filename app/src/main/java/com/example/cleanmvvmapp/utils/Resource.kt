package com.example.cleanmvvmapp.utils

sealed class Resource<out T>(val data: T?) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(throwable: Throwable): Resource<T>(null)
    class Loading<T>(isLoading: Boolean): Resource<T>(null)
}