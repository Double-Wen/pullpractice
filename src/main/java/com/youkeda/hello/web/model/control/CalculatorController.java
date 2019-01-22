package com.youkeda.hello.web.model.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalculatorController {
    @RequestMapping(path = "/add")
    public int add (@RequestParam("key1")int key1,@RequestParam("key2")int key2){
        int result = key1+key2;
        return result;
    }
}
