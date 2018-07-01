package com.neuedu.controller;

import com.neuedu.adtools.Result;
import com.neuedu.adtools.ResultUtil;
import com.neuedu.po.*;
import com.neuedu.service.ActionService;
import com.neuedu.service.DisplayService;
import com.neuedu.tools.AddressPages;
import com.neuedu.tools.TeacherPages;
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
    @Autowired
    private ActionService actionService;

    //////////////////////////////////////////////////
    ///////////////////////////////////////////////////
    @RequestMapping(value="AdminGoToEnterpriseBasic")
    public String getEnterpriseBasic(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        request.setAttribute("username",username);

        int qid = (Integer) session.getAttribute("qid");
        String enterprise_img ;


        Enterprise enterprise = new Enterprise();
        if (displayService.adminGetOneEnterprise(qid) != null){
            enterprise = displayService.adminGetOneEnterprise(qid);
        }
        enterprise_img = displayService.adminGetEnterpriseImgurl(qid,"A");

        request.setAttribute("enterprise",enterprise);
        request.setAttribute("enterprise_img",enterprise_img);
        System.err.println(" !!!!!"+enterprise_img);
        return "forward:/back/admin_enterprise_basic.jsp";
    }

    @RequestMapping(value="AdminToSetEnterpriseBasic")
    public String toSetEnterpriseBasic(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        request.setAttribute("username",username);

        int qid = (Integer) session.getAttribute("qid");
        String enterprise_img ;


        Enterprise enterprise = new Enterprise();
        if (displayService.adminGetOneEnterprise(qid) != null){
            enterprise = displayService.adminGetOneEnterprise(qid);
        }
        enterprise_img = displayService.adminGetEnterpriseImgurl(qid,"A");

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

        request.setAttribute("username",username);

        Enterprise old_enterprise = displayService.adminGetOneEnterprise(qid);
        Enterprise enterprise = new Enterprise();
        String name = request.getParameter("name");
        String introduction = request.getParameter("introduction");
        String jczs = request.getParameter("jczs");
        String imgurl="";
        String videopath="";


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
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "enterprise.jpg";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;

                    if (token == 1){
                        localFile = new File(session.getServletContext().getRealPath("/img/")+realName);
                        imgurl = realName;
                    }
                    else {
                       // realName = realName+".mp4";
                        localFile = new File(session.getServletContext().getRealPath("/video/")+realName);
                        videopath = realName;
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

        if (videopath == "" || videopath == null ){
            videopath = old_enterprise.getVideopath();
        }
        if (imgurl != null && imgurl != "" && imgurl != displayService.adminGetEnterpriseImgurl(qid,"A")) {
            actionService.adminSetEnterpriseImgurl(imgurl,qid);
            System.out.println("!!!!!!!!!imgurl"+imgurl);
        }

        enterprise.setQid(qid);
        enterprise.setName(name);
        enterprise.setIntroduction(introduction);
        enterprise.setVideopath(videopath);
        enterprise.setJczs(jczs);

        actionService.adminSetEnterprise(enterprise);

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

            realName = UUID.randomUUID().toString() + fileNameExtension+"jpg";

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

    @RequestMapping(value="AdminToShowAllAddress")
    public String showAllAddressInPage(HttpServletRequest request) {
        //String isIndex = request.getParameter("isIndex");
        //int index = (request.getParameter("index") != null) ? Integer.parseInt(request.getParameter("index")) : 0;
        //ArrayList<Integer> indexSet = new ArrayList<>();
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        request.setAttribute("username",username);

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int count = displayService.adminGetAddressAmount(qid);
        AddressPages p = new AddressPages(page, count);
        ArrayList<Address> list = displayService.adminGetSomeAddressInPage(p.getPage(),qid);
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        return "forward:/back/admin_address_all.jsp";
    }

    @RequestMapping(value="AdminToShowOneAddress")
    public String showOneAddress(HttpServletRequest request) {
        //String isIndex = request.getParameter("isIndex");
        //int index = (request.getParameter("index") != null) ? Integer.parseInt(request.getParameter("index")) : 0;
        //ArrayList<Integer> indexSet = new ArrayList<>();
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        request.setAttribute("username",username);
        int id = Integer.parseInt(request.getParameter("id"));

        Address address = displayService.adminSelectOneAddress(id);
        request.setAttribute("address",address);
        return "forward:/back/admin_address_basic.jsp";
    }

    @RequestMapping(value="AdminAddOneAddress")
    public String addOneAddress(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        request.setAttribute("username",username);
        double latitude = 0;
        double longitude = 0;
        String pot = request.getParameter("pot");
        String lat_str ;
        String lgn_str;
        try{
            lat_str = pot.split(",")[0];
            lgn_str = pot.split(",")[1];
            latitude = Double.parseDouble(lat_str);
            longitude = Double.parseDouble(lgn_str);
        }catch (Exception e){
            // not to solve
        }
        Address address = new Address();
        address.setQid(qid);
        address.setBranch(request.getParameter("branch"));
        address.setAddress(request.getParameter("address"));
        address.setTel(request.getParameter("tel"));
        address.setLatitude(latitude);
        address.setLongitude(longitude);

        actionService.adminAddOneAddress(address);
        return "forward:/AdminToShowAllAddress";
    }

    @RequestMapping(value="AdminToSetOneAddress")
    public String toSetOneAddress(HttpServletRequest request) {


        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        //request.setAttribute("username",username);

        int id = Integer.parseInt(request.getParameter("id"));
        Address address = displayService.adminSelectOneAddress(id);
        String pot = address.getLatitude()+","+address.getLongitude();

        request.setAttribute("address",address);
        request.setAttribute("pot",pot);

        return "forward:/back/admin_address_modify.jsp";
    }

    @RequestMapping(value="AdminSetOneAddress")
    public String setOneAddress(HttpServletRequest request) {

       // System.out.println("dadadadadadadadadadadsdadadadadda");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        //request.setAttribute("username",username);
        String lat_str ;
        String lgn_str;
        double latitude = 0;
        double longitude = 0;
        String branch =request.getParameter("branch");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String pot = request.getParameter("pot");
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            lat_str = pot.split(",")[0];
            lgn_str = pot.split(",")[1];
            latitude = Double.parseDouble(lat_str);
            longitude = Double.parseDouble(lgn_str);
        }catch (Exception e){
            // not to solve
        }
        Address a  = displayService.adminSelectOneAddress(id);
        a.setBranch(branch);
        a.setTel(tel);
        a.setAddress(address);
        a.setLongitude(longitude);
        a.setLatitude(latitude);
        actionService.adminSetOneAddress(a);
        //actionService.addOneAddress(address);
        return "forward:/AdminToShowAllAddress";
    }

    @RequestMapping(value="AdminDeleteOneAddress")
    public String deleteOneAddress(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        actionService.adminDeleteOneAddress(id);
        return "forward:/AdminToShowAllAddress";
    }

    @RequestMapping(value="AdminToShowAllTeacher")
    public String showAllTeacherInPage(HttpServletRequest request) {
        //String isIndex = request.getParameter("isIndex");
        //int index = (request.getParameter("index") != null) ? Integer.parseInt(request.getParameter("index")) : 0;
        //ArrayList<Integer> indexSet = new ArrayList<>();
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        request.setAttribute("username",username);

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int count = displayService.adminGetTeacherAmount(qid);
        TeacherPages p = new TeacherPages(page, count);
        ArrayList<Teacher> list = displayService.adminGetSomeTeacherInPage(p.getPage(),qid);
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        return "forward:/back/admin_teacher_all.jsp";
    }

    @RequestMapping(value="AdminToSetOneTeacher")
    public String toSetOneTeacher(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        //int qid = (Integer) session.getAttribute("qid");
        int tid = Integer.parseInt(request.getParameter("tid"));
        Teacher teacher = displayService.adminSelectOneTeacher(tid);
        request.setAttribute("teacher",teacher);
        return "forward:/back/admin_teacher_modify.jsp";
    }

    @RequestMapping(value="AdminSetOneTeacher")
    public String setOneTeacher(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        String tname = request.getParameter("tname");
        String introduction =request.getParameter("introduction");
        int tid = Integer.parseInt(request.getParameter("tid"));
        String tphoto="";
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){ //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> ite = multiRequest.getFileNames();

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
            while (ite.hasNext()){
                //token ++;
                MultipartFile file = multiRequest.getFile(ite.next());
                if(file!=null){
                    File localFile;
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "-teacher";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/")+realName);
                    tphoto = realName;

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

        Teacher teacher = new Teacher();
        teacher.setQid(qid);
        teacher.setTid(tid);
        teacher.setIntroduction(introduction);
        teacher.setTname(tname);
        teacher.setTphoto(tphoto);
        actionService.adminSetOneTeacher(teacher);

        return "forward:/AdminToShowAllTeacher";
    }


    @RequestMapping(value="AdminAddOneTeacher")
    public String addOneTeacher(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        String tname = request.getParameter("tname");
        String introduction =request.getParameter("introduction");
        //int tid = Integer.parseInt(request.getParameter("tid"));
        String tphoto="";


        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){ //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> ite = multiRequest.getFileNames();

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
            while (ite.hasNext()){
                //token ++;
                MultipartFile file = multiRequest.getFile(ite.next());
                if(file!=null){
                    File localFile;
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "-teacher";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/")+realName);
                    tphoto = realName;

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

        Teacher teacher = new Teacher();
        teacher.setQid(qid);
        //teacher.setTid(tid);
        teacher.setIntroduction(introduction);
        teacher.setTname(tname);
        teacher.setTphoto(tphoto);
        actionService.adminAddOneTeacher(teacher);


        return "forward:/AdminToShowAllTeacher";
    }
    @RequestMapping(value = "AdminToSetTeacherImg")
    public String toSetTeacherImg(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        //request.setAttribute("username",username);

        String teacherImgurl = displayService.adminGetTeacherImg(qid);
        System.out.println("!!!!!!!!!!!!!!!teacherimgurl"+teacherImgurl);
        request.setAttribute("teacherImg",teacherImgurl);
        return "forward:/back/admin_teacher_img.jsp";
    }

    @RequestMapping(value = "AdminSetTeacherImg")
    public String setTeacherImg(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        //request.setAttribute("username",username);

        String newTeacherImg="";
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){ //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> ite = multiRequest.getFileNames();

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
            while (ite.hasNext()){
                //token ++;
                MultipartFile file = multiRequest.getFile(ite.next());
                if(file!=null){
                    File localFile;
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "-teacherImg";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/")+realName);
                    newTeacherImg = realName;

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

        System.out.println(newTeacherImg);
        if (newTeacherImg == null || newTeacherImg ==""){
            newTeacherImg = displayService.adminGetTeacherImg(qid);
        }
        actionService.adminSetTeacherImg(newTeacherImg,qid);
        return "forward:/AdminToSetTeacherImg";
    }

    @RequestMapping(value="AdminDeleteOneTeacher")
    public String deleteOneTeacher(HttpServletRequest request) {

        int tid = Integer.parseInt(request.getParameter("tid"));
        actionService.adminDeleteOneTeacher(tid);
        return "forward:/AdminToShowAllTeacher";
    }

}
