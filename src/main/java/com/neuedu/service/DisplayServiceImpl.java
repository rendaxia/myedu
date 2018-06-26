package com.neuedu.service;


import com.neuedu.myBatis.SqlSessionUtil;
import com.neuedu.po.*;
import com.neuedu.mapper.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DisplayServiceImpl implements DisplayService{
    @Override
    public ArrayList<Lesson> getAllLessonByCondition(String type, String address) {
        ArrayList<Lesson> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            list = mapper.getAllLessonByCondition(type,address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Freelisten> getAllFreelistenByCondition(String type, String address) {
        ArrayList<Freelisten> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            list = mapper.getAllFreelistenByCondition(type,address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Teacher> getAllTeacher() {
        ArrayList<Teacher> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            list = mapper.getAllTeacher();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Address> getAllAddress() {
        ArrayList<Address> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            list = mapper.getAllAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Message> getAllMessage() {
        ArrayList<Message> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.getAllMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Enterprise> getEnterprise() {
        ArrayList<Enterprise> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            list = mapper.getAllEnterprise();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Sorder> getAllSorderByCondition(String openid, String status) {
        ArrayList<Sorder> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SorderMapper mapper = sqlSession.getMapper(SorderMapper.class);
        try {
            list = mapper.getAllSorderByCondition(openid,status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////
}
