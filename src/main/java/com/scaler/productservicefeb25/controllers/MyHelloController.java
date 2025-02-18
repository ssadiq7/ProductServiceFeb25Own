package com.scaler.productservicefeb25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHelloController {

    @GetMapping("/")
    public String say() {
        return "Type something!";
    }

    @GetMapping("/{name}")
    public String showWhatTheyTyped(@PathVariable("name") String name) {
        return "This is what you typed - \"" + name + "\"" + "\n" + "Type /hello or something else!";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye bye!";
    }
}
