package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/")
    fun helloWorld(): String {
        return "Hello World"
    }
}
//curl "http://localhost:8080"


data class HelloResponse(val message: String)
@RestController
@RequestMapping("greeter")
class GreeterController {
    @GetMapping("hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {
        return HelloResponse("Hello $name")
    }
}
//curl "http://localhost:8080/greeter/hello?name=Kotlin"

@GetMapping("hello/{name}")
fun helloPathValue(@PathVariable("name") name: String): HelloResponse {
    return HelloResponse("Hello $name")
}
//curl "http://localhost:8080/greeter/hello/Kotlin"

