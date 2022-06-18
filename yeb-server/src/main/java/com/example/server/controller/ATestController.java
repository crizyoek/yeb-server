package com.example.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ATestController {

    @GetMapping("/employee/basic/hello")
    public String menuOne() {
        return "/employee/basic/**";
    }

    @GetMapping("/employee/advanced/hello")
    public String menuTwo() {
        return "/employee/advanced/**";
    }

}
