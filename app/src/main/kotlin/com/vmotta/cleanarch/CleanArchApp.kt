package com.vmotta.cleanarch

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.vmotta.cleanarch", "com.vmotta.cleanarch.controllers")
        .start()
}