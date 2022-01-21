package com.example.weatherapp.data.remote

import com.example.weatherapp.core.Constants
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @see DefaultRequestInterceptor implemented to build request with api keys.
 */
@Singleton
class DefaultRequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url
            .newBuilder()
            .addQueryParameter(
                Constants.API_KEY_QUERY,
                Constants.API_KEY_VALUE
            )
            .build()
        val request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
