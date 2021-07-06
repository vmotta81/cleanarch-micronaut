package com.vmotta.cleanarch.controllers.hl3

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/hello3") // <1>
class Hello3Controller {

    @Get("/") // <2>
    @Produces(MediaType.TEXT_PLAIN) // <3>
    fun index(): String {
        return "Hello World 3" // <4>
    }
}