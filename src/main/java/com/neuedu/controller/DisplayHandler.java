package com.neuedu.controller;

import org.springframework.stereotype.Controller;

@Controller
public class DisplayHandler {

    private String openid;

    private String username;

    private String tel;

    public void getTel(String te){
        tel = te;
        openid = "user"+tel;
        username = "user"+tel;
        System.out.println("display: "+username);
    }














}

