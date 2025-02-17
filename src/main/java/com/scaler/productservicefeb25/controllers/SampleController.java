package com.scaler.productservicefeb25.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST + Controller => Http APIs + Controller
@RequestMapping("/search")
public class SampleController {

    // http://localhost:8080/search/hello/1000
    @GetMapping("/hello/{numberOfTimes}")
    public String sayHello(@PathVariable("numberOfTimes") int numberOfTimes) {

        return "Hello ".repeat(Math.max(0, numberOfTimes));
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye";
    }
}

/*
EndPoint - /orders, /search, /products

http ->  default port = 80
https -> default port = 443

https://www.amazon.com/search?query='iphone'

https://www.amazon.com/orders?id=101

https://www.amazon.com/payments?.....

*/