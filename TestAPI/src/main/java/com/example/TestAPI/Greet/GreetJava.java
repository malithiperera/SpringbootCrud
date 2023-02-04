package com.example.TestAPI.Greet;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetJava {
    @GetMapping("/greet")
    public String geetMessege(){
        return  "Good Day";
    }
}
