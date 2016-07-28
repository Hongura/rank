package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hongura on 2016-04-28.
 */
@Controller
public class Main {
    @RequestMapping(value = "/test.daum")
    public String test() {
        return "test";

    }
}
