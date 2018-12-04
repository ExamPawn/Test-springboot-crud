package com.example.demo.Controller;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class controller {


    @PostMapping("/user/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> m, HttpSession session){

       if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
           //防止表单重复提交，这里用重定向（但是重定向可以不登陆直接访问页面，就要靠拦截器）
           session.setAttribute("loginname",username);
           return "redirect:/main";
       }else {
           m.put("msg", "登陆信息错误");
           return "login";
       }
    }
}
