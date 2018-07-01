package com.neuedu.controller;

import com.neuedu.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ActionHandler {

    @Autowired
    private ActionService actionService;

    private String openid;

    @RequestMapping(value="ActionHandler_freelistenBook")
    @ResponseBody
    public String freelistenBook (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        openid = (String) session.getAttribute("openid");
        String username = (String) session.getAttribute("username");
        String tel = (String) session.getAttribute("tel");
        int fid = Integer.parseInt(request.getParameter("fid"));
        String comment = request.getParameter("comment");
        isOK = actionService.freelistenBook(fid,"费园园","15804049843",comment,"oC9yV5IbgeaLrGfM8tSLSO8Jmj0c");
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    public boolean freelistenCancel (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        openid = (String) session.getAttribute("openid");
        int fid = Integer.parseInt(request.getParameter("fid"));
        isOK = actionService.freelistenCancel(fid,openid);
        return isOK;
    }

    public boolean addToCart (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        openid = (String) session.getAttribute("openid");
        int lid = Integer.parseInt(request.getParameter("lid"));
        double total = Double.parseDouble(request.getParameter("total"));
        String username = (String) session.getAttribute("username");
        String tel = (String) session.getAttribute("tel");
        isOK = actionService.addToCart(lid,openid,total,username,tel);
        return isOK;
    }

    public boolean paySorder (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        openid = (String) session.getAttribute("openid");
        int lid = Integer.parseInt(request.getParameter("lid"));
        double actual = Double.parseDouble(request.getParameter("actual"));
        isOK = actionService.paySorder(lid,openid,actual);
        return isOK;
    }

    public boolean refundSorder (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        openid = (String) session.getAttribute("openid");
        int lid = Integer.parseInt(request.getParameter("lid"));
        isOK = actionService.refundSorder(lid,openid);
        return isOK;
    }

    public boolean addMessagelike (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        int mid = Integer.parseInt(request.getParameter("mid"));
        String username = (String) session.getAttribute("username");
        isOK = actionService.addMessagelike(mid,username);
        return isOK;
    }

    public boolean addMessagereply (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        int mid = Integer.parseInt(request.getParameter("mid"));
        String username = (String) session.getAttribute("username");
        String content = request.getParameter("content");
        isOK = actionService.addMessagereply(mid,username,content);
        return isOK;
    }

    public boolean removeMessagelike (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        int mid = Integer.parseInt(request.getParameter("mid"));
        String username = (String) session.getAttribute("username");
        isOK = actionService.removeMessagelike(mid,username);
        return isOK;
    }

    public boolean removeMessagereply (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        int mid = Integer.parseInt(request.getParameter("mid"));
        String username = (String) session.getAttribute("username");
        isOK = actionService.removeMessagereply(mid,username);
        return isOK;
    }





}
