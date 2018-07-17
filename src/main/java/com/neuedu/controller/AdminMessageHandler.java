package com.neuedu.controller;
import com.neuedu.adtools.Result;
import com.neuedu.adtools.ResultUtil;
import com.neuedu.po.*;
import com.neuedu.service.ActionService;
import com.neuedu.service.DisplayService;
import com.neuedu.tools.AddressPages;
import com.neuedu.tools.LessonPages;
import com.neuedu.tools.MessagePages;
import com.neuedu.tools.TeacherPages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class AdminMessageHandler {


    ////////////////////////////////////////
    ////////////////////////////////////////

    @Autowired
    private DisplayService displayService;
    @Autowired
    private ActionService actionService;

    @RequestMapping(value = "Admin/AdminToShowAllMessage")
    public String showAllLessonInPageOn(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int count = displayService.adminGetAllMessage(qid).size();
        MessagePages p = new MessagePages(page, count);
        ArrayList<Message> list = displayService.adminGetAllMessageInPage(qid, page);
        for (Message one : list) {
            one.setMessagelikes(displayService.adminGetSomeMessagelikeOfOneMessage(one.getMid()));
            one.setMessagelikesamount(one.getMessagelikes().size());
            one.setMessagereplies(displayService.adminGetSomeMessagereplyOfOneMessage(one.getMid()));
            one.setMessageimgs(displayService.adminGetSomeMessageimgOfOneMessage(one.getMid()));
            one.setMtime(one.getMtime().substring(0,10));
            for (Messagereply  m:one.getMessagereplies()) {
                m.setStime(m.getStime().substring(0,10));
            }
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!size" + list.size());
        String enterpriseImg = displayService.adminGetEnterpriseImgurl(qid, "A");
        String enterpriseName = displayService.adminGetOneEnterprise(qid).getName();
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        request.setAttribute("enterpriseImg", enterpriseImg);
        request.setAttribute("enterpriseName", enterpriseName);

        return "forward:/back/admin_message_all.jsp";
    }

    @RequestMapping(value = "Admin/AdminAddOneMessage")
    public String addOneMessage(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {

        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");


        Message message = new Message();
        String mtitle = request.getParameter("mtitle");
        message.setMtitle(mtitle);
        message.setQid(qid);
        actionService.adminAddOneMessage(message);

        Message lastMessage = displayService.adminGetOneMessageByMtimeAndMtitle(mtitle);

        String imgurl = "";
        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];

                try {
                    //获取存取路径
                    File localFile;
                    String fileNameExtension = "-messageimg";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/") + realName);
                    imgurl = realName;
                    Messageimg messageimg = new Messageimg();
                    messageimg.setMid(lastMessage.getMid());
                    messageimg.setImgurl(imgurl);
                    actionService.adminAddOneMessageimg(messageimg);
                    // 转存文件
                    file.transferTo(localFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 重定向

        }

        return "forward:/Admin/AdminToShowAllMessage";
    }

    @RequestMapping(value = "Admin/AdminDeleteOneMessage")
    public String deleteOneMessage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int mid = Integer.parseInt(request.getParameter("mid"));
        actionService.adminDeleteOneMessage(mid);
        actionService.adminDeleteAllMessagereplyOfOneMessage(mid);
        actionService.adminDeleteAllMessageimgOfOneMessage(mid);
        actionService.adminDeleteAllMessagelikeOfOneMessage(mid);

        return "forward:/Admin/AdminToShowAllMessage";
    }

    @RequestMapping(value = "Admin/AdminDeleteOneMessagereply")
    public String deleteOneMessagereply(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        int page= Integer.parseInt(request.getParameter("page"));
        actionService.adminDeleteOneMessagereplyOfOneMessage(id);

        return "forward:/Admin/AdminToShowAllMessage?page="+page;
    }

    @RequestMapping(value = "Admin/AdminToSetMessageImg")
    public String toSetMessageImg(HttpServletRequest request){
        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        String messageImg = displayService.adminGetMessageImg(qid);
        request.setAttribute("messageImg",messageImg);
        return "forward:/back/admin_message_img.jsp";
    }

    @RequestMapping(value = "Admin/AdminSetMessageImg")
    public String setMessageImg(HttpServletRequest request){
        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        String newMessageImg="";
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){ //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> ite = multiRequest.getFileNames();

            while (ite.hasNext()){
                MultipartFile file = multiRequest.getFile(ite.next());
                if(file!=null&&file.getSize()>0){
                    File localFile;
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "-MessageIndexImg.jpg";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/")+realName);
                    newMessageImg = realName;

                    try {
                        file.transferTo(localFile); //将上传文件写到服务器上指定的文件
                    } catch (IllegalStateException e) {
                        //e.printStackTrace();
                    } catch (IOException e) {
                        //e.printStackTrace();
                    }
                }
            }
        }

        System.out.println(newMessageImg);
        if (newMessageImg == ""){
            newMessageImg = displayService.adminGetTeacherImg(qid);
        }
        actionService.adminSetMessageImg(newMessageImg,qid);
        return "forward:/Admin/AdminToSetMessageImg";
    }
}