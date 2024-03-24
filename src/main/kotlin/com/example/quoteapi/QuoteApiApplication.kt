package com.example.quoteapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class QuoteApiApplication

@RestController("/")
class QuoteController(val quoteService: QuoteService) {

    @CrossOrigin(origins = ["http://localhost:4200"])
    @GetMapping
    fun getRandomQuote(): String {
        return this.quoteService.getRandomQuote();
    }
}

fun main(args: Array<String>) {
    runApplication<QuoteApiApplication>(*args)
}
