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
}
