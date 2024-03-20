package com.annotations.taskmanager_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloWorld {
    @GetMapping("/hello")
    public String Hello(){
        System.out.println("this here is my first code");
        return "Hello world!!!";
    }@GetMapping("/age")
    public int age(){
        return 23;
    }

}
