package com.mybts.pls.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id) {
        log.info("id:{}", id);
        return "helllo world---->" + id;
    }
}
