package com.neuedu.controller;

import com.neuedu.po.*;
import com.neuedu.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class DisplayHandler {

    @Autowired
    private DisplayService displayService;

    private String openid;

    @RequestMapping(value="DisplayHandler_getAllLessonByCondition")
    @ResponseBody
    public ArrayList<Lesson> getAllLessonByCondition(HttpServletRequest request){
        String type = request.getParameter("type");
        String address = request.getParameter("address");
        ArrayList<Lesson> list=null;
        list=displayService.getAllLessonByCondition(type,address);
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllFreelistenByCondition")
    @ResponseBody
    public ArrayList<Freelisten> getAllFreelistenByCondition(HttpServletRequest request){
        String type = request.getParameter("type");
        String address = request.getParameter("address");
        ArrayList<Freelisten> list=null;
        list=displayService.getAllFreelistenByCondition(type,address);
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllTeacher")
    @ResponseBody
    public ArrayList<Teacher> getAllTeacher(HttpServletRequest request){
        System.out.println("******************DisplayHandler_getAllTeacher*********************");
        ArrayList<Teacher> list=null;
        list=displayService.getAllTeacher();
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllAddress")
    @ResponseBody
    public ArrayList<Address> getAllAddress(HttpServletRequest request){
        ArrayList<Address> list=null;
        list=displayService.getAllAddress();
        return list;
    }

    @RequestMapping(value="DisplayHandler_getEnterprise")
    @ResponseBody
    public ArrayList<Enterprise> getEnterprise(HttpServletRequest request){
        ArrayList<Enterprise> list=null;
        list=displayService.getEnterprise();
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllMessage")
    @ResponseBody
    public ArrayList<Message> getAllMessage(HttpServletRequest request){
        ArrayList<Message> list=null;
        list=displayService.getAllMessage();
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllSorderByCondition")
    @ResponseBody
    public ArrayList<Sorder> getAllSorderByCondition(HttpServletRequest request){
        HttpSession session = request.getSession();
        String openid = (String)session.getAttribute("openid");
        String status = request.getParameter("status");
        System.out.println(status);
        ArrayList<Sorder> list=null;
        list=displayService.getAllSorderByCondition("oC9yV5HNntbgqDyPEg2J0YSY8dC8",status);
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllFreelistenBookByCondition")
    @ResponseBody
    public ArrayList<Freelistenbook> getAllFreelistenBookByCondition(HttpServletRequest request){
        HttpSession session = request.getSession();
        String openid = (String)session.getAttribute("openid");
        ArrayList<Freelistenbook> list=null;
        list=displayService.getAllFreelistenbookByCondition("oC9yV5HNntbgqDyPEg2J0YSY8dC8");
        return list;
    }










}

