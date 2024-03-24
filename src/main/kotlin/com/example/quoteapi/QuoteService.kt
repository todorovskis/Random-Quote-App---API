package com.example.quoteapi

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class QuoteService {

    val apiUrl = "https://api.api-ninjas.com/v1/quotes?category="
    val apiKey = "QSdvQ8eu0ZDRp1LbtDpfEQ==z7Q0ULy0uedwN4Kj"

    fun getRandomQuote(): String {
        println("method on backend called")
        val restTemplate = RestTemplate()

        val headers = HttpHeaders()
        headers.set("X-Api-Key", apiKey)

        val entity = HttpEntity<String>(headers)
        val urlWithApiKey = "$apiUrl&X-Api-Key=$apiKey"


        val response = restTemplate.exchange(urlWithApiKey, HttpMethod.GET, entity, String::class.java)
        println(response.body)
        return response.body ?: "No quote available"
    }

}
