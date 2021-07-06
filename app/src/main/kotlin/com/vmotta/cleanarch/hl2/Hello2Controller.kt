package com.vmotta.cleanarch.hl2

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/hello2") // <1>
class Hello2Controller {

    @Get("/") // <2>
    @Produces(MediaType.TEXT_PLAIN) // <3>
    fun index(): String {
        return "Hello World 2" // <4>
    }
}