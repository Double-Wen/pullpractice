package com.youkeda.wacai.web.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountingController {
    @RequestMapping(path = "/accounting")
    public String add(@RequestParam("cash") int key1, @RequestParam("income") int key2, @RequestParam("rent") int key3, @RequestParam("charges") int key4, @RequestParam("eat") int key5) {
        int result = key1 + key2 - key3 - key4 - key5;
        String s = String.valueOf(result);
        return "本月余额为:" + s;
    }
}
