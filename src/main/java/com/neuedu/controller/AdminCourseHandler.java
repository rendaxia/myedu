package com.neuedu.controller;
import com.neuedu.adtools.Result;
import com.neuedu.adtools.ResultUtil;
import com.neuedu.po.*;
import com.neuedu.service.ActionService;
import com.neuedu.service.DisplayService;
import com.neuedu.tools.AddressPages;
import com.neuedu.tools.LessonPages;
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
public class AdminCourseHandler {

    ////////////////////////////////////////
    ////////////////////////////////////////

    @Autowired
    private DisplayService displayService;
    @Autowired
    private ActionService actionService;


    @RequestMapping(value = "AdminToShowAllLesson")
    public String showAllLessonInPage(HttpServletRequest request) {
        //String isIndex = request.getParameter("isIndex");
        //int index = (request.getParameter("index") != null) ? Integer.parseInt(request.getParameter("index")) : 0;
        //ArrayList<Integer> indexSet = new ArrayList<>();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        String branchid_str = request.getParameter("branchid");
        int branchid = -1;
        if (branchid_str != null && branchid_str != "") {
            branchid = Integer.parseInt(branchid_str);
        }

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int count = displayService.adminGetLessonByConditionAmount(qid, branchid);
        LessonPages p = new LessonPages(page, count);
        ArrayList<Lesson> list = displayService.adminGetAllLessonByConditionInPage(qid, branchid, page);
        ArrayList<Address> addresses = displayService.adminGetAllAddress(qid);
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        request.setAttribute("addresses", addresses);
        request.setAttribute("branchid", branchid);
        return "forward:/back/admin_lesson_all.jsp";
    }

    @RequestMapping(value = "AdminToShowAllFreelisten")
    public String showAllFreelistenInPage(HttpServletRequest request) {
        //String isIndex = request.getParameter("isIndex");
        //int index = (request.getParameter("index") != null) ? Integer.parseInt(request.getParameter("index")) : 0;
        //ArrayList<Integer> indexSet = new ArrayList<>();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        String branchid_str = request.getParameter("branchid");
        int branchid = -1;
        if (branchid_str != null && branchid_str != "") {
            branchid = Integer.parseInt(branchid_str);
        }

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int count = displayService.adminGetFreelistenByConditionAmount(qid, branchid);
        LessonPages p = new LessonPages(page, count);
        ArrayList<Freelisten> list = displayService.adminGetAllFreelistenByConditionInPage(qid, branchid, page);
        ArrayList<Address> addresses = displayService.adminGetAllAddress(qid);
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        request.setAttribute("addresses", addresses);
        request.setAttribute("branchid", branchid);
        return "forward:/back/admin_freelisten_all.jsp";
    }

    @RequestMapping(value = "AdminToAddOneLesson")
    public String toAddOneLesson(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        ArrayList<Address> addresses = displayService.adminGetAllAddress(qid);
        request.setAttribute("addresses", addresses);
        return "forward:/back/admin_lesson_add.jsp";
    }

    @RequestMapping(value = "AdminToAddOneFreelisten")
    public String toAddOneFreelisten(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");
        ArrayList<Address> addresses = displayService.adminGetAllAddress(qid);
        request.setAttribute("addresses", addresses);
        return "forward:/back/admin_freelisten_add.jsp";
    }

    @RequestMapping(value = "AdminLessonRichTextImgUpload")
    @ResponseBody
    public Result editorFileUpload(MultipartFile myFileName, HttpSession session, HttpServletRequest request) {
        String realName = "";
        if (myFileName != null) {
            String fileName = myFileName.getOriginalFilename();
            String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length() - 1);
            // 生成实际存储的真实文件名

            realName = UUID.randomUUID().toString() + fileNameExtension + "-ldescimg";

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
        String[] str = {request.getContextPath() + "/img/" + realName};
        System.out.println("!!!!!!!str:" + str[0]);
        return ResultUtil.success(str);
    }

    @RequestMapping(value = "AdminAddOneLesson")
    public String addOneLesson(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int qid = (Integer) session.getAttribute("qid");

        Lesson lesson = new Lesson();
        Lessonbranch lessonbranch = new Lessonbranch();
        String lname = request.getParameter("lname");
        String ldesc = request.getParameter("ldesc");
        String lprice_str = request.getParameter("lprice");
        String category = request.getParameter("category");
        int branchid = Integer.parseInt(request.getParameter("branchid"));
        Double lprice = 0.0;
        if (lprice_str != null && lprice_str != "") {
            lprice = Double.parseDouble(lprice_str);
        }
        String imgurl = "";

        int token = 0;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) { //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();

            while (ite.hasNext()) {
                token++;
                MultipartFile file = multiRequest.getFile(ite.next());
                if (file != null) {
                    File localFile;
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "-lesson";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/") + realName);
                    imgurl = realName;

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

        lesson.setLname(lname);
        lesson.setImgurl(imgurl);
        lesson.setLprice(lprice);
        lesson.setLdesc(ldesc);
        lesson.setCategory(category);
        lesson.setQid(qid);
        System.out.println("!!!!!!!!lesson info :" + lname + " " + imgurl + " " + lprice + " " + ldesc + " ???  " + category);
        actionService.adminAddOneLesson(lesson);

        lessonbranch.setBranchid(branchid);
        lessonbranch.setLid(displayService.adminGetOneLessonByLnameAndQidAndCategory(lname, qid, category).getLid());
        actionService.adminAddOneLessonbranch(lessonbranch);
//
//        request.setAttribute("enterprise",enterprise);
//        request.setAttribute("enterprise_img",enterprise_img);
//        return "forward:/back/admin_enterprise_basic.jsp";
        return "forward:/AdminToShowAllLesson";
    }

    @RequestMapping(value = "AdminFreelistenRichTextImgUpload")
    @ResponseBody
    public Result editorFileUploadForF(MultipartFile myFileName, HttpSession session, HttpServletRequest request) {
        String realName = "";
        if (myFileName != null) {
            String fileName = myFileName.getOriginalFilename();
            String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length() - 1);
            // 生成实际存储的真实文件名

            realName = UUID.randomUUID().toString() + fileNameExtension + "-freelisten";

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
        String[] str = {request.getContextPath() + "/img/" + realName};
        System.out.println("!!!!!!!str:" + str[0]);
        return ResultUtil.success(str);
    }

    @RequestMapping(value = "AdminAddOneFreelisten")
    public String addOneFreelisten(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        Freelisten freelisten = new Freelisten();
        String title = request.getParameter("title");
        String fdesc = request.getParameter("fdesc");
        int branchid = Integer.parseInt(request.getParameter("branchid"));
        Double lprice = 0.0;
        String imgurl = "";

        int token = 0;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) { //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();

            while (ite.hasNext()) {
                token++;
                MultipartFile file = multiRequest.getFile(ite.next());
                if (file != null) {
                    File localFile;
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "-freelisten";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/") + realName);
                    imgurl = realName;

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

        freelisten.setTitle(title);
        freelisten.setImgurl(imgurl);
        freelisten.setBranchid(branchid);
        freelisten.setFdesc(fdesc);
        freelisten.setStatus("进行中");
        freelisten.setQid(qid);
        actionService.adminAddOneFreelisten(freelisten);

        return "forward:/AdminToShowAllFreelisten";
    }

    @RequestMapping(value = "AdminToShowOneLesson")
    public String showOneLesson(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int lid = Integer.parseInt(request.getParameter("lid"));
        Address address = displayService.adminGetOneAddressByLid(lid);
        Lesson lesson = displayService.adminGetOneLesson(lid);
        request.setAttribute("address", address);
        request.setAttribute("lesson", lesson);
        return "forward:/back/admin_lesson_basic.jsp";
    }

    @RequestMapping(value = "AdminToShowOneFreelisten")
    public String showOneFreelisten(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Freelisten freelisten = displayService.adminGetOneFreelisten(id);
        Address address = displayService.adminSelectOneAddress(freelisten.getBranchid());
        request.setAttribute("address", address);
        request.setAttribute("freelisten", freelisten);
        return "forward:/back/admin_freelisten_basic.jsp";
    }

    @RequestMapping(value = "AdminToSetOneLesson")
    public String ToSetOneLesson(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int lid = Integer.parseInt(request.getParameter("lid"));
        int qid = (int) (session.getAttribute("qid"));
        Address address = displayService.adminGetOneAddressByLid(lid);
        Lesson lesson = displayService.adminGetOneLesson(lid);
        request.setAttribute("address", address);
        request.setAttribute("lesson", lesson);
        ArrayList<Address> addresses = displayService.adminGetAllAddress(qid);
        request.setAttribute("addresses", addresses);
        return "forward:/back/admin_lesson_modify.jsp";

    }

    @RequestMapping(value = "AdminToSetOneFreelisten")
    public String toSetOneFreelisten(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        int qid = (int) (session.getAttribute("qid"));

        Freelisten freelisten = displayService.adminGetOneFreelisten(id);
        Address address = displayService.adminSelectOneAddress(freelisten.getBranchid());
        request.setAttribute("address", address);
        request.setAttribute("freelisten", freelisten);
        ArrayList<Address> addresses = displayService.adminGetAllAddress(qid);
        request.setAttribute("addresses", addresses);
        request.setAttribute("status",freelisten.getStatus());
        return "forward:/back/admin_freelisten_modify.jsp";
    }

    @RequestMapping(value = "AdminSetOneLesson")
    public String setOneLesson(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        Lesson lesson = new Lesson();
        Lessonbranch lessonbranch = new Lessonbranch();
        int lid = Integer.parseInt(request.getParameter("lid"));
        String lname = request.getParameter("lname");
        String ldesc = request.getParameter("ldesc");
        String lprice_str = request.getParameter("lprice");
        String category = request.getParameter("category");
        int branchid = Integer.parseInt(request.getParameter("branchid"));
        Double lprice = 0.0;
        if (lprice_str != null && lprice_str != "") {
            lprice = Double.parseDouble(lprice_str);
        }
        String imgurl = "";

        int token = 0;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) { //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();

            while (ite.hasNext()) {
                token++;
                MultipartFile file = multiRequest.getFile(ite.next());
                if (file != null) {
                    File localFile;
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "-lesson.jpg";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/") + realName);
                    imgurl = realName;

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

        lesson = displayService.adminGetOneLesson(lid);
        lesson.setLname(lname);

        if (imgurl != lesson.getImgurl()) {
            lesson.setImgurl(imgurl);
        }
        lesson.setLprice(lprice);
        lesson.setLdesc(ldesc);
        lesson.setCategory(category);
        lesson.setQid(qid);
        System.out.println("!!!!!!!!lesson info :" + lname + " " + imgurl + " " + lprice + " " + ldesc + " ???  " + category);
        actionService.adminSetOneLesson(lesson);

        lessonbranch.setBranchid(branchid);
        lessonbranch.setLid(lesson.getLid());
        actionService.adminSetOneLessonbranch(lessonbranch);

        return "forward:/AdminToShowAllLesson";
    }

    @RequestMapping(value = "AdminSetOneFreelisten")
    public String setOneFreelisten(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        Freelisten freelisten = new Freelisten();
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String fdesc = request.getParameter("fdesc");
        int branchid = Integer.parseInt(request.getParameter("branchid"));
        String status =request.getParameter("status");
        Double lprice = 0.0;
        String imgurl = "";

        int token = 0;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) { //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();

            while (ite.hasNext()) {
                token++;
                MultipartFile file = multiRequest.getFile(ite.next());
                if (file != null) {
                    File localFile;
                    String fileName = file.getOriginalFilename();
                    String fileNameExtension = "-freelisten";
                    // 生成实际存储的真实文件名

                    String realName = UUID.randomUUID().toString() + fileNameExtension;
                    localFile = new File(session.getServletContext().getRealPath("/img/") + realName);
                    imgurl = realName;

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
        freelisten = displayService.adminGetOneFreelisten(id);
        freelisten.setTitle(title);
        if (imgurl != freelisten.getImgurl()) {
            freelisten.setImgurl(imgurl);
        }
        freelisten.setBranchid(branchid);
        freelisten.setFdesc(fdesc);
        freelisten.setStatus("进行中");
        freelisten.setQid(qid);
        freelisten.setStatus(status);
        actionService.adminSetOneFreelisten(freelisten);

        return "forward:/AdminToShowAllFreelisten";
    }

    @RequestMapping(value = "AdminDeleteOneLesson")
    public String deleteOneLesson(HttpServletRequest request) {
        int lid = Integer.parseInt(request.getParameter("lid"));
        int branchid = displayService.adminGetOneAddressByLid(lid).getId();
        actionService.adminDeleteOneLesson(lid);
        actionService.adminDeleteOneLessonbranch(displayService.adminGetOneLessonbranch(lid, branchid).getId());
        return "forward:/AdminToShowAllLesson";
    }

    @RequestMapping(value = "AdminDeleteOneFreelisten")
    public String deleteOneFreelisten(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        actionService.adminDeleteOneFreelisten(id);
        return "forward:/AdminToShowAllLesson";
    }

    @RequestMapping(value = "AdminToShowAllFreelistenbook")
    public String showAllFreelistenbookInPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        String fid_str = request.getParameter("fid");
        String status_o = request.getParameter("status");
        String status = request.getParameter("status");
        String username = request.getParameter("username");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        int fid = -1;
        if (fid_str != null && fid_str != "") {
            fid = Integer.parseInt(fid_str);
        }
        if (status == null) status = "";
        if (status.equals("All")) status = "";
        if (status_o == null) status_o = "All";
        if (username == null) username = "";
        if (startTime == null) startTime = "";
        if (endTime == null) endTime = "";

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        ArrayList<Freelistenbook> list = displayService.adminGetAllFreelistenbookByConditionInPage(qid, fid, status, username, startTime, endTime, page);
        int count = displayService.adminGetAllFreelistenbookByCondition(qid, fid, status, username, startTime, endTime).size();
        LessonPages p = new LessonPages(page, count);
        for (Freelistenbook one : list) {
            one.setFreelisten(displayService.adminGetOneFreelisten(one.getFid()));
        }
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        if (fid == -1) {
            request.setAttribute("fid", "");
        } else
            request.setAttribute("fid", fid);
        request.setAttribute("status", status_o);
        request.setAttribute("username", username);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "forward:/back/admin_freelistenbook_all.jsp";
    }

    @RequestMapping(value = "AdminToConfirmOneFreelistenbook")
    public String confirmFreelistenbook(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        actionService.adminConfirmFreelistenbook(id);
        return "forward:/AdminToShowAllFreelistenbook";
    }

    @RequestMapping(value = "AdminToShowAllSorder")
    public String showAllSorderInPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        String lid_str = request.getParameter("lid");
        String status_o = request.getParameter("status");
        String status = request.getParameter("status");
        String nickname = request.getParameter("nickname");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        int lid = -1;
        if (lid_str != null && lid_str != "") {
            lid = Integer.parseInt(lid_str);
        }
        if (status == null) status = "";
        if (status.equals("All")) status = "";
        if (status_o == null) status_o = "All";
        if (nickname == null) nickname = "";
        if (startTime == null) startTime = "";
        if (endTime == null) endTime = "";

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        ArrayList<Sorder> list = displayService.adminGetAllSorderByConditionInPage(qid, lid, status, nickname, startTime, endTime, page);
        int count = displayService.adminGetAllSorderByCondition(qid, lid, status, nickname, startTime, endTime).size();
        LessonPages p = new LessonPages(page, count);
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        if (lid == -1) {
            request.setAttribute("lid", "");
        } else
            request.setAttribute("lid", lid);
        request.setAttribute("status", status_o);
        request.setAttribute("nickname", nickname);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "forward:/back/admin_sorder_all.jsp";
    }

    @RequestMapping(value = "AdminToShowAllSorderForRefund")
    public String showAllSorderForRefundInPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        String lid_str = request.getParameter("lid");
        String status_o = request.getParameter("status");
        String status = request.getParameter("status");
        String nickname = request.getParameter("nickname");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        int lid = -1;
        if (lid_str != null && lid_str != "") {
            lid = Integer.parseInt(lid_str);
        }
        if (status == null) status = "退款中";

        //if (status_o == null) status_o = "All";
        if (nickname == null) nickname = "";
        if (startTime == null) startTime = "";
        if (endTime == null) endTime = "";

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        ArrayList<Sorder> list = displayService.adminGetAllSorderByConditionInPage(qid, lid, status, nickname, startTime, endTime, page);
        int count = displayService.adminGetAllSorderByCondition(qid, lid, status, nickname, startTime, endTime).size();
        LessonPages p = new LessonPages(page, count);
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        if (lid == -1) {
            request.setAttribute("lid", "");
        } else
            request.setAttribute("lid", lid);
        request.setAttribute("status", status);
        request.setAttribute("nickname", nickname);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "forward:/back/admin_sorder_all_for_refund.jsp";
    }

    @RequestMapping(value = "AdminToRefundOneSorder")
    public String refundOneSorder(HttpServletRequest request) {
        int oid = Integer.parseInt(request.getParameter("oid"));
        actionService.adminRefundSorder(oid);
        return "forward:/AdminToShowAllSorderForRefund";
    }
    @RequestMapping(value = "AdminToShowAllSorderForCAV")
    public String showAllSorderForCAVInPage(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int qid = (Integer) session.getAttribute("qid");

        String lid_str = request.getParameter("lid");
        String status_o = request.getParameter("status");
        String status = request.getParameter("status");
        String nickname = request.getParameter("nickname");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        int lid = -1;
        if (lid_str != null && lid_str != "") {
            lid = Integer.parseInt(lid_str);
        }
        if (status == null) status = "已付款";

        //if (status_o == null) status_o = "All";
        if (nickname == null) nickname = "";
        if (startTime == null) startTime = "";
        if (endTime == null) endTime = "";

        int page = 1;
        if (request.getParameter("page") == null || request.getParameter("page") == "") {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        ArrayList<Sorder> list = displayService.adminGetAllSorderByConditionInPage(qid, lid, status, nickname, startTime, endTime, page);
        int count = displayService.adminGetAllSorderByCondition(qid, lid, status, nickname, startTime, endTime).size();
        LessonPages p = new LessonPages(page, count);
        request.setAttribute("list", list);
        request.setAttribute("p", p);
        if (lid == -1) {
            request.setAttribute("lid", "");
        } else
            request.setAttribute("lid", lid);
        request.setAttribute("status", status);
        request.setAttribute("nickname", nickname);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        return "forward:/back/admin_sorder_all_for_CAV.jsp";
    }

    @RequestMapping(value = "AdminToCAVOneSorder")
    public String cAVOneSorder(HttpServletRequest request) {
        int oid = Integer.parseInt(request.getParameter("oid"));
        actionService.adminCAVSorder(oid);
        return "forward:/AdminToShowAllSorderForCAV";
    }

}
