package com.neuedu.controller;

import com.neuedu.po.*;
import com.neuedu.service.ActionService;
import com.neuedu.service.DisplayService;
import com.neuedu.tools.MessageVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class ActionHandler {

    @Autowired
    private ActionService actionService;

    @Autowired
    private DisplayService displayService;

    private String openid = "user15804049842";

    private String tel = "15804049842";

    private String username = "user15804049842";




    @RequestMapping(value="ActionHandler_getVerification")
    @ResponseBody
    public String getVerification (HttpServletRequest request){
        String veri = null;
        tel = request.getParameter("tel");
        //tel = "15804049843";
        System.out.println(tel);
        DisplayHandler dh = new DisplayHandler();
        dh.getTel(tel);
        try {
            veri = MessageVerification.getVeri(tel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(veri);
        //调用验证码接口
        openid = "user"+tel;
        username = "user"+tel;
        return veri;
    }

    @RequestMapping(value="ActionHandler_getUsername")
    @ResponseBody
    public String getUsername (HttpServletRequest request){
        return "{\"result\":\""+username+"\"}";
    }

    @RequestMapping(value="ActionHandler_freelistenBook")
    @ResponseBody
    public String freelistenBook (HttpServletRequest request){
        Boolean isOK =false;
        String str = request.getParameter("ID");
        String str2 = str.trim();
        int fid = Integer.parseInt(str2);
        String comment = request.getParameter("comment");
        isOK = actionService.freelistenBook(fid,username,tel,comment,openid);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_freelistenCancel")
    @ResponseBody
    public String freelistenCancel (HttpServletRequest request){
        System.out.println("***************ActionHandler_freelistenCancel****************");
        Boolean isOK =false;
        int id = Integer.parseInt(request.getParameter("id"));
        isOK = actionService.freelistenCancel(id);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_addToCart")
    @ResponseBody
    public String addToCart (HttpServletRequest request){
        Boolean isOK =false;

        String str_m = request.getParameter("money");
        String str2_m = str_m.trim();
        int total = Integer.parseInt(str2_m);

        String str = request.getParameter("ID");
        String str2 = str.trim();
        int lid = Integer.parseInt(str2);
        //double total = Double.parseDouble(request.getParameter("total"));
        isOK = actionService.addToCart(lid,openid,total,username,tel);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_refundCart")
    @ResponseBody
    public String refundCart (HttpServletRequest request){
        System.out.println("**********ActionHandler_refundCart**********");
        Boolean isOK =false;
        int oid = Integer.parseInt(request.getParameter("oid"));
        isOK = actionService.refundCart(oid);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_paySorder")
    @ResponseBody
    public String paySorder (HttpServletRequest request){
        Boolean isOK =false;
        int oid = Integer.parseInt(request.getParameter("oid"));
        //double actual = Double.parseDouble(request.getParameter("actual"));
        isOK = actionService.paySorder(oid,openid);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_refundSorder")
    @ResponseBody
    public String refundSorder (HttpServletRequest request){
        System.out.println("**********ActionHandler_refundSorder**********");
        Boolean isOK =false;
        int oid = Integer.parseInt(request.getParameter("oid"));
        isOK = actionService.refundSorder(oid);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_addMessagelike")
    @ResponseBody
    public String addMessagelike (HttpServletRequest request){
        Boolean isOK =false;
        int mid = Integer.parseInt(request.getParameter("mid"));
        isOK = actionService.addMessagelike(mid,username);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_addMessagereply")
    @ResponseBody
    public String addMessagereply (HttpServletRequest request){
        Boolean isOK =false;
        int mid = Integer.parseInt(request.getParameter("mid"));
        String content = request.getParameter("content");
        isOK = actionService.addMessagereply(mid,username,content);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_removeMessagelike")
    @ResponseBody
    public String removeMessagelike (HttpServletRequest request){
        Boolean isOK =false;
        System.out.println("****************ActionHandler_removeMessagelike*****************");
        int mid = Integer.parseInt(request.getParameter("mid"));
        System.out.println(mid);
        isOK = actionService.removeMessagelike(mid,username);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="ActionHandler_removeMessagereply")
    @ResponseBody
    public String removeMessagereply (HttpServletRequest request){
        System.out.println("**************ActionHandler_removeMessagereply***************");
        Boolean isOK =false;
        int comment_id = Integer.parseInt(request.getParameter("comment_id"));
        isOK = actionService.removeMessagereply(comment_id,username);
        if(isOK){
            return "{\"result\":\"success\"}";
        }
        else{
            return "{\"result\":\"failed\"}";
        }
    }

    @RequestMapping(value="DisplayHandler_getAllLessonByCondition")
    @ResponseBody
    public ArrayList<Lesson> getAllLessonByCondition(HttpServletRequest request){
        String type = request.getParameter("category");
        String address = request.getParameter("branch");
        ArrayList<Lesson> list=null;
        list=displayService.getAllLessonByCondition(type,address);
        return list;
    }



    @RequestMapping(value="DisplayHandler_getAllFreelistenByCondition")
    @ResponseBody
    public ArrayList<Freelisten> getAllFreelistenByCondition(HttpServletRequest request){
        String type = request.getParameter("type");
        String address = request.getParameter("branch");
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

    @RequestMapping(value="DisplayHandler_getAddressByCondition")
    @ResponseBody
    public Address getAddressByCondition(HttpServletRequest request){
        Address list=null;
        String address = request.getParameter("address");
        list=displayService.getAddressByCondition(address);
        return list;
    }

    @RequestMapping(value="DisplayHandler_getEnterprise")
    @ResponseBody
    public Enterprise getEnterprise(HttpServletRequest request){
        Enterprise en=null;
        en=displayService.getEnterprise();
        return en;
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
        String status = request.getParameter("status");
        System.out.println(status);
        ArrayList<Sorder> list=null;
        list=displayService.getAllSorderByCondition(openid,status);
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllFreelistenBookByCondition")
    @ResponseBody
    public ArrayList<Freelistenbook> getAllFreelistenBookByCondition(HttpServletRequest request){
        System.out.println("************DisplayHandler_getAllFreelistenBookByCondition************");
        ArrayList<Freelistenbook> list=null;
        System.out.println("openid:"+openid);
        list=displayService.getAllFreelistenbookByCondition(openid);
        return list;
    }


    //获得每个说说的点赞数
    @RequestMapping(value="DisplayHandler_getAllMessagelikeByMessage")
    @ResponseBody
    public ArrayList<Integer> getAllMessagelikeByMessage(HttpServletRequest request){
        System.out.println("************DisplayHandler_getAllMessagelikeByMessage************");
        ArrayList<Integer> list=null;
        list=displayService.getAllMessagelikeByMessage();
        return list;
    }

    //获得每个说说的评论数
    @RequestMapping(value="DisplayHandler_getAllMessagereplyByMessage")
    @ResponseBody
    public ArrayList<Integer> getAllMessagereplyByMessage(HttpServletRequest request){
        System.out.println("************DisplayHandler_getAllMessagereplyByMessage************");
        ArrayList<Integer> list=null;
        list=displayService.getAllMessagereplyByMessage();
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllMessagelikeByCondition")
    @ResponseBody
    public ArrayList<Message> getAllMessagelikeByCondition(HttpServletRequest request){
        System.out.println("************DisplayHandler_getAllMessagelikeByCondition************");
        ArrayList<Message> list=null;
        list=displayService.getAllMessagelikeByCondition(username);
        return list;
    }

    @RequestMapping(value="DisplayHandler_getAllMessagereplyByCondition")
    @ResponseBody
    public ArrayList<Message> getAllMessagereplyByCondition(HttpServletRequest request){
        System.out.println("************DisplayHandler_getAllMessagereplyByCondition************");
        ArrayList<Message> list=null;
        list=displayService.getAllMessagereplyByCondition(username);
        return list;
    }





}
