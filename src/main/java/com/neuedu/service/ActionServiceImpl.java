package com.neuedu.service;

import com.neuedu.mapper.ClassMapper;
import com.neuedu.mapper.MessageMapper;
import com.neuedu.mapper.SorderMapper;
import com.neuedu.myBatis.SqlSessionUtil;
import com.neuedu.po.Lesson;
import com.neuedu.po.Messagelike;
import com.neuedu.po.Messagereply;
import com.neuedu.po.Sorder;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActionServiceImpl implements ActionService{

    @Override
    public Boolean freelistenBook(int fid, String username, String tel, String comment, String openid) {
        Boolean isOK = false;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.freelistenBook(fid,username,tel,comment,openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public Boolean freelistenCancel(int fid, String openid) {
        Boolean isOK = false;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.freelistenCancel(fid,openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public Boolean addToCart(int lid, String openid, double total, String username, String tel) {
        Boolean isOK = false;
        Sorder s = new Sorder();
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SorderMapper mapper = sqlSession.getMapper(SorderMapper.class);
        try {
            s.setTel(tel);
            s.setOpenid(openid);
            s.setNickname(username);
            s.setLid(lid);
            s.setTotal(total);
            isOK = mapper.addToCart(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public Boolean paySorder(int lid, String openid,double actual) {
        Boolean isOK = false;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SorderMapper mapper = sqlSession.getMapper(SorderMapper.class);
        try {
            isOK = mapper.paySorder(lid,openid,actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public Boolean refundSorder(int lid, String openid) {
        Boolean isOK = false;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SorderMapper mapper = sqlSession.getMapper(SorderMapper.class);
        try {
            isOK = mapper.refundSorder(lid,openid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public Boolean addMessagelike(int mid, String username) {
        Boolean isOK = false;
        Messagelike ml = new Messagelike();
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            ml.setMid(mid);
            ml.setNickname(username);
            isOK = mapper.addMessagelike(ml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public Boolean addMessagereply(int mid, String username, String content) {
        Boolean isOK = false;
        Messagereply mr = new Messagereply();
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            mr.setMid(mid);
            mr.setContent(content);
            mr.setNickname(username);
            isOK = mapper.addMessagereply(mr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public Boolean removeMessagelike(int mid, String username) {
        Boolean isOK = false;
        Messagelike ml = new Messagelike();
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            ml.setMid(mid);
            ml.setNickname(username);
            isOK = mapper.removeMessagelike(ml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }
    @Override
    public Boolean removeMessagereply(int mid, String username) {
        Boolean isOK = false;
        Messagereply mr = new Messagereply();
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            mr.setNickname(username);
            mr.setMid(mid);
            isOK = mapper.removeMessagereply(mr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOK;
    }
}
