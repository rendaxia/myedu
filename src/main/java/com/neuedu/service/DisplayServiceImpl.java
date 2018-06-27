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

    @Override
    public ArrayList<Freelistenbook> getAllFreelistenbookByCondition(String openid) {
        ArrayList<Freelistenbook> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SorderMapper mapper = sqlSession.getMapper(SorderMapper.class);
        try {
            list = mapper.getAllFreelistenbookByCondition(openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean checkUser(String username, String userpassword) {
        boolean isOK = false;
        int result = 0;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.checkUser(username,userpassword);
            if (result > 0){
                isOK = true;
            }else {
                isOK = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public int getQidOfUser(String username, String userpassword) {
        int result = -1 ;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.getQidOfUser(username,userpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getTeacherAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.getTeacherAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getLessonAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            result = mapper.getLessonAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getFreelistenAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            result = mapper.getFreelistenAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public int getSorderAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SorderMapper mapper = sqlSession.getMapper(SorderMapper.class);
        try {
            result = mapper.getSorderAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getFreelistenbookAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        FreelistenbookMapper mapper = sqlSession.getMapper(FreelistenbookMapper.class);
        try {
            result = mapper.getFreelistenbookAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getMessagereplyAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            result = mapper.getMessagereplyAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getMessagelikeAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            result = mapper.getMessagelikeAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Enterprise getOneEnterprise(int qid){
        Enterprise result = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.getOneEnterprise(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getEnterpriseImgurl(int qid,String category){
        String result = "";
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.getEnterpriseImgurl(qid,category);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
