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


    ///////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////

    public boolean checkUser(String username,String userpassword);

    public int getQidOfUser(String username,String userpassword);

    public int getTeacherAmount(int qid);

    public int getLessonAmount(int qid);

    public int getFreelistenAmount(int qid);

    public int getSorderAmount(int qid);

    public int getFreelistenbookAmount(int qid);

    public int getMessagereplyAmount(int qid);

    public int getMessagelikeAmount(int qid);

    public Enterprise getOneEnterprise(int qid);

    public String getEnterpriseImgurl(int qid,String category);
}
