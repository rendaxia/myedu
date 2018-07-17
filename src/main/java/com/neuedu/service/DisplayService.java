package com.neuedu.service;

import com.neuedu.po.*;

import java.util.ArrayList;

public interface DisplayService {
    public ArrayList<Lesson> getAllLessonByCondition(String type, String address);

    public ArrayList<Freelisten> getAllFreelistenByCondition(String type, String address);

    public ArrayList<Teacher> getAllTeacher();

    public ArrayList<Address> getAllAddress();

    public Address getAddressByCondition(String address);

    public ArrayList<Message> getAllMessage();

    public Enterprise getEnterprise();

    public ArrayList<Sorder> getAllSorderByCondition(String openid, String status);

    public ArrayList<Freelistenbook> getAllFreelistenbookByCondition(String openid);

    public ArrayList<Message> getAllMessagelikeByCondition(String nickname);

    public ArrayList<Message> getAllMessagereplyByCondition(String nickname);

    public ArrayList<Integer> getAllMessagelikeByMessage();

    public ArrayList<Integer> getAllMessagereplyByMessage();



    ///////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////

    public boolean adminCheckUser(String username,String userpassword);

    public int adminGetQidOfUser(String username,String userpassword);

    public int adminGetTeacherAmount(int qid);

    public int adminGetLessonAmount(int qid);

    public int adminGetFreelistenAmount(int qid);

    public int adminGetSorderAmount(int qid);

    public int adminGetFreelistenbookAmount(int qid);

    public int adminGetMessagereplyAmount(int qid);

    public int adminGetMessagelikeAmount(int qid);

    public Enterprise adminGetOneEnterprise(int qid);

    public String adminGetEnterpriseImgurl(int qid,String category);

    public ArrayList<Address> adminGetAllAddress(int qid);

    public Address adminSelectOneAddress(int id);

    public int adminGetAddressAmount(int qid);

    public ArrayList<Address> adminGetSomeAddressInPage(int page,int qid);

    //may
    public ArrayList<Teacher> adminGetAllTeacher(int qid);

    public ArrayList<Teacher> adminGetSomeTeacherInPage(int qid,int page);

    public Teacher adminSelectOneTeacher(int tid);

    public String adminGetTeacherImg(int qid );

    //may
    public ArrayList<Lesson> adminGetAllLessonByCondition(int qid,int branchid);

    public ArrayList<Lesson> adminGetAllLessonByConditionInPage(int qid,int branchid,int page);

    public int adminGetLessonByConditionAmount(int qid,int branchid);

    //may
    public ArrayList<Freelisten> adminGetAllFreelistenByCondition(int qid,int branchid);

    public ArrayList<Freelisten> adminGetAllFreelistenByConditionInPage(int qid,int branchid,int page);

    public int adminGetFreelistenByConditionAmount(int qid,int branchid);

    public Lesson adminGetOneLesson(int lid);

    public Freelisten adminGetOneFreelisten(int id);

    public Lesson adminGetOneLessonByLnameAndQidAndCategory(String lname,int qid,String category);

    public Address adminGetOneAddressByLid(int lid );

    public Lessonbranch adminGetOneLessonbranch(int lid,int branchid);

    public ArrayList<Freelistenbook> adminGetAllFreelistenbookByCondition(int qid,int fid,String status,String username,String startTime,String endTime);

    public ArrayList<Freelistenbook> adminGetAllFreelistenbookByConditionInPage(int qid,int fid,String status,String username,String startTime,String endTime,int page);

    public ArrayList<Sorder> adminGetAllSorderByCondition(int qid,int lid,String status,String nickname,String startTime,String endTime);

    public ArrayList<Sorder> adminGetAllSorderByConditionInPage(int qid,int lid,String status,String nickname,String startTime,String endTime,int page);

    public ArrayList<Message> adminGetAllMessage(int qid);

    public ArrayList<Message> adminGetAllMessageInPage(int qid,int page);

    public ArrayList<Messagelike> adminGetSomeMessagelikeOfOneMessage(int mid);

    public ArrayList<Messagereply> adminGetSomeMessagereplyOfOneMessage(int mid);

    public ArrayList<Messageimg> adminGetSomeMessageimgOfOneMessage(int mid);

    public Message adminGetOneMessageByMtimeAndMtitle(String mtitle);

    public String adminGetMessageImg(int qid);

}
