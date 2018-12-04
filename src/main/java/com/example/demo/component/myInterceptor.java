package com.example.demo.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       Object j= request.getSession().getAttribute("loginname");
       if(j==null){
           request.setAttribute("msg","没有权限，请先登陆");
           request.getRequestDispatcher("/index").forward(request,response);
           return false;
       }else {
           return true;
       }
    }


}
