package com.neuedu.controller;

import com.neuedu.adtools.Result;
import com.neuedu.adtools.ResultUtil;
import com.neuedu.po.*;
import com.neuedu.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Controller
public class AdminCompanyHandler {

    @Autowired
    private DisplayService displayService;


    //////////////////////////////////////////////////
    ///////////////////////////////////////////////////
    @RequestMapping(value="AdminGoToEnterpriseBasic")
    public String getEnterpriseBasic(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        String enterprise_img ;


        Enterprise enterprise = new Enterprise();
        if (displayService.getOneEnterprise(qid) != null){
            enterprise = displayService.getOneEnterprise(qid);
        }
        enterprise_img = displayService.getEnterpriseImgurl(qid,"A");

        request.setAttribute("enterprise",enterprise);
        request.setAttribute("enterprise_img",enterprise_img);
        return "forward:/back/admin_enterprise_basic.jsp";
    }

    @RequestMapping(value="AdminToSetEnterpriseBasic")
    public String toSetEnterpriseBasic(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        String enterprise_img ;


        Enterprise enterprise = new Enterprise();
        if (displayService.getOneEnterprise(qid) != null){
            enterprise = displayService.getOneEnterprise(qid);
        }
        enterprise_img = displayService.getEnterpriseImgurl(qid,"A");

        request.setAttribute("enterprise",enterprise);
        request.setAttribute("enterprise_img",enterprise_img);
        request.setAttribute("jczs",enterprise.getJczs());
        return "forward:/back/admin_enterprise_modify.jsp";
    }

    @RequestMapping(value="AdminSetEnterpriseBasic")
    public String setEnterpriseBasic(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");

        String name = request.getParameter("name");
        String introduction = request.getParameter("introduction");
        String jczs = request.getParameter("jczs");
        String imgurl;
        String videopath;

        int token = 0;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){ //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> ite = multiRequest.getFileNames();

            while(ite.hasNext()){
                token ++;
                MultipartFile file = multiRequest.getFile(ite.next());
                if(file!=null){
                    File localFile;
                    if (token == 1){
                        localFile = new File(session.getServletContext().getRealPath("/img/")+file.getOriginalFilename());
                        imgurl = file.getOriginalFilename();
                    }
                    else {
                        localFile = new File(session.getServletContext().getRealPath("/video/")+file.getOriginalFilename());
                        videopath = file.getOriginalFilename();
                    }
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




        System.out.println(request.getParameter("jczs"));
//
//        request.setAttribute("enterprise",enterprise);
//        request.setAttribute("enterprise_img",enterprise_img);
//        return "forward:/back/admin_enterprise_basic.jsp";
        return "forward:/AdminGoToEnterpriseBasic";
    }

    @RequestMapping(value="AdminEnterpriseRichTextImgUpload")
    @ResponseBody
    public Result editorFileUpload(MultipartFile myFileName, HttpSession session, HttpServletRequest request){

//        if (editorUploadFileName != null){
//            if (editorUploadFileName.getSize()>(3 * 1024 * 1024)){
//                return "error|"+getMessage("file.upload.max.size", new Object[]{"3M"});
//            }
//            FileUploadModel fileUploadModel = AliyunFileUploadUtil.upload(editorUploadFileName);
//            if (fileUploadModel != null && !StringUtils.isEmpty(fileUploadModel.getUrl())) {
//                return fileUploadModel.getUrl();
//            }else{
//                return "error|"+getMessage("do.fail");
//            }
//        }
//        return "error|"+getMessage("file.upload.not.found.file");
        String realName = "";
        if (myFileName != null) {
            String fileName = myFileName.getOriginalFilename();
            String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length() - 1);
            // 生成实际存储的真实文件名

            realName = UUID.randomUUID().toString() + fileNameExtension;

            // "/upload"是你自己定义的上传目录

            String realPath = session.getServletContext().getRealPath("/img");
            //System.out.println("!!!!!!!!realpath:"+realPath);
            File uploadFile = new File(realPath, realName);
            try {
                myFileName.transferTo(uploadFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String [] str = {request.getContextPath() + "/img/" + realName};
        System.out.println("!!!!!!!str:"+str[0]);
        return ResultUtil.success(str);
    }
}
