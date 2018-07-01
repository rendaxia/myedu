package com.neuedu.service;

import com.neuedu.po.*;

import java.util.ArrayList;

public interface DisplayService {
    public ArrayList<Lesson> getAllLessonByCondition(String type, String address);

    public ArrayList<Freelisten> getAllFreelistenByCondition(String type, String address);

    public ArrayList<Teacher> getAllTeacher();

    public ArrayList<Address> getAllAddress();

    public ArrayList<Message> getAllMessage();

    public ArrayList<Enterprise> getEnterprise();

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

    public ArrayList<Teacher> adminGetAllTeacher(int qid);

    public ArrayList<Teacher> adminGetSomeTeacherInPage(int qid,int page);

    public Teacher adminSelectOneTeacher(int tid);

    public String adminGetTeacherImg(int qid );



}
