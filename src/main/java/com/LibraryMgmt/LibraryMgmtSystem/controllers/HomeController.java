package com.LibraryMgmt.LibraryMgmtSystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        System.out.println("Everything running");
        return "Welcome to the Library Management System!";
    }
}   
