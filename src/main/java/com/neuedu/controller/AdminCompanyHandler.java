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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        return "forward:/back/admin_enterprise_modify.jsp";
    }

    @RequestMapping(value="AdminSetEnterpriseBasic")
    public String setEnterpriseBasic(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(request.getParameter("jczs"));
//
//        request.setAttribute("enterprise",enterprise);
//        request.setAttribute("enterprise_img",enterprise_img);
//        return "forward:/back/admin_enterprise_basic.jsp";
        return "forward:/back/admin_index.jsp";
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

            String realPath = session.getServletContext().getRealPath("/back/img");
            File uploadFile = new File(realPath, realName);
            try {
                myFileName.transferTo(uploadFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String [] str = {request.getContextPath() + "/back/img/" + realName};
        return ResultUtil.success(str);
    }
}
