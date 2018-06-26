package com.neuedu.controller;

import com.neuedu.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ActionHandler {

    @Autowired
    private ActionService actionService;

    private String openid;

    public boolean freelistenBook (HttpServletRequest request){
        Boolean isOK =false;
        HttpSession session = request.getSession();
        openid = (String) session.getAttribute("openid");
        String username = (String) session.getAttribute("username");
        String tel = (String) session.getAttribute("tel");
        int fid = Integer.parseInt(request.getParameter("fid"));
        String comment = request.getParameter("comment");
        isOK = actionService.freelistenBook(fid,username,tel,comment,openid);

    }
}
