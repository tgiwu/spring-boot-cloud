package com.test.zuul.fallback

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Component
import java.io.ByteArrayInputStream
import java.io.InputStream

@Component
class UserFallbackProvider: FallbackProvider {
    override fun fallbackResponse(route: String?, cause: Throwable?): ClientHttpResponse = object: ClientHttpResponse {
        override fun getHeaders(): HttpHeaders {
            val headers = HttpHeaders()
            headers.contentType = MediaType.APPLICATION_JSON
            return headers
        }

        override fun getStatusCode(): HttpStatus = HttpStatus.OK

        override fun getRawStatusCode(): Int = 200

        override fun close() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getStatusText(): String = "OK"

        override fun getBody(): InputStream = ByteArrayInputStream("fallback".toByteArray())
    }

    override fun getRoute(): String = "eureka-client"
}