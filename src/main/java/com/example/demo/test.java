package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class test {
    @ResponseBody
    @RequestMapping("/he")
    public String say(){
        return "hi";
    }
    @RequestMapping("/test")
    public String su(Map<String,Object> m){
            m.put("sb","name");
            m.put("user", Arrays.asList("<h1>zhangsan</h1>","lisi","wangwu"));
        return "su";
    }
}
