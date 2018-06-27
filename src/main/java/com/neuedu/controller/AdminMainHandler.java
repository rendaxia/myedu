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
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminMainHandler {

    ////////////////////////////////////////
    ////////////////////////////////////////

    @Autowired
    private DisplayService displayService;

    @RequestMapping(value="AdminLogin")
    public String adminLogin(HttpServletRequest request){
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        // 判断是否非空
        if (username!=null && username!="" && userpassword!= null && userpassword != ""){
            // 非空时和数据库比对
            if (displayService.checkUser(username,userpassword)){
                //如果没错
                HttpSession session = request.getSession();
                session.setAttribute("qid", displayService.getQidOfUser(username,userpassword)); // 登录成功，向session存入一个登录标记
                session.setAttribute("username",username);
                return "forward:/AdminGoToIndex";
            }else {
                // 如果错误
                request.setAttribute("loginmsg","请输入正确的用户名或密码");
                return "forward:/back/admin_login.jsp";
            }
        }else {
            // 如果有空
            request.setAttribute("loginmsg","请不要输入空用户名或密码");
            return "forward:/back/admin_login.jsp";
        }

    }

    @RequestMapping(value="AdminExit")
    public String adminExit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("qid");
        session.removeAttribute("username");
        session.invalidate();
        return "forward:/back/admin_login.jsp";
    }



    @RequestMapping(value="AdminGoToIndex")
    public String getAdminIndex(HttpServletRequest request){
        //通过session得到相关信息
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");

        String teacheramount = ""+displayService.getTeacherAmount(qid);
        String lessonamount = ""+displayService.getLessonAmount(qid);
        String freelistenamount = ""+displayService.getFreelistenAmount(qid);
        String sorderamount = ""+displayService.getSorderAmount(qid);
        String freelistenbookamount = ""+displayService.getFreelistenAmount(qid);
        String messageadditionamount = ""+(displayService.getMessagereplyAmount(qid)+displayService.getMessagelikeAmount(qid));


        //存储首页信息
        Map<String,String> indexmsg = new HashMap<>();
        indexmsg.put("teacheramount",teacheramount);
        indexmsg.put("lessonamount",lessonamount);
        indexmsg.put("freelistenamount",freelistenamount);
        indexmsg.put("sorderamount",sorderamount);
        indexmsg.put("freelistenbookamount",freelistenbookamount);
        indexmsg.put("messageadditionamount",messageadditionamount);

        //存放进request中
        request.setAttribute("indexmsg",indexmsg);
        request.setAttribute("username",username);


        return "forward:/back/admin_index.jsp";
    }
}
