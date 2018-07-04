package com.neuedu.service;

import com.neuedu.mapper.*;
import com.neuedu.myBatis.SqlSessionUtil;
import com.neuedu.po.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ActionServiceImpl implements ActionService{

    @Override
    public Boolean freelistenBook(int fid, String username, String tel, String comment, String openid) {
        Boolean isOK = false;
        Freelistenbook fb = new Freelistenbook();
        SqlSession sqlSession = SqlSessionUtil.getSession();
        FreelistenbookMapper mapper = sqlSession.getMapper(FreelistenbookMapper.class);
        try {
            fb.setComment(comment);
            fb.setFid(fid);
            fb.setOpenid(openid);
            fb.setTel(tel);
            fb.setUsername(username);
            isOK = mapper.freelistenbook(fb);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
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
        }finally {
            sqlSession.close();
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



    ////////////////////////////////////////////////////////////

    public int adminSetEnterprise(Enterprise enterprise){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminSetEnterprise(enterprise);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();

        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminSetEnterpriseImgurl(String url,int qid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminSetEnterpriseImgurl(url,qid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminAddOneAddress(Address address){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminAddOneAddress(address);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminSetOneAddress(Address address){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminSetOneAddress(address);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminDeleteOneAddress(int id){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminDeleteOneAddress(id);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminSetOneTeacher(Teacher teacher){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminSetOneTeacher(teacher);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminAddOneTeacher(Teacher teacher){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminAddOneTeacher(teacher);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public  int adminDeleteOneTeacher(int tid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminDeleteOneTeacher(tid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminSetTeacherImg(String goalUrl,int qid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            isOK = mapper.adminSetTeacherImg(goalUrl,qid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminAddOneLesson(Lesson lesson){

        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminAddOneLesson(lesson);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminAddOneLessonbranch(Lessonbranch lessonbranch){

        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminAddOneLessonbranch(lessonbranch);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminAddOneFreelisten(Freelisten freelisten){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminAddOneFreelisten(freelisten);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;

    }

    public int adminSetOneLesson(Lesson lesson){

        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminSetOneLesson(lesson);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminSetOneLessonbranch(Lessonbranch lessonbranch){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminSetOneLessonbranch(lessonbranch);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;

    }

    public int adminSetOneFreelisten(Freelisten freelisten){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminSetOneFreelisten(freelisten);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;

    }

    public int adminDeleteOneLesson(int lid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminDeleteOneLesson(lid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;

    }

    public int adminDeleteOneLessonbranch(int id){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminDeleteOneLessonbranch(id);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminDeleteOneFreelisten(int id){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminDeleteOneFreelisten(id);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }
    public int adminConfirmFreelistenbook(int id){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminConfirmFreelistenbook(id);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminRefundSorder(int oid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminRefundSorder(oid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }
    public int adminCAVSorder(int oid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            isOK = mapper.adminCAVSorder(oid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminAddOneMessage(Message message){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            isOK = mapper.adminAddOneMessage(message);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminAddOneMessageimg(Messageimg messageimg ){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            isOK = mapper.adminAddOneMessageimg(messageimg);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }
    public int adminDeleteOneMessage(int mid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            isOK = mapper.adminDeleteOneMessage(mid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminDeleteAllMessagelikeOfOneMessage(int mid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            isOK = mapper.adminDeleteAllMessagelikeOfOneMessage(mid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;

    }

    public int adminDeleteOneMessagereplyOfOneMessage(int id){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            isOK = mapper.adminDeleteOneMessagereplyOfOneMessage(id);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;

    }

    public int adminDeleteAllMessageimgOfOneMessage(int mid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            isOK = mapper.adminDeleteAllMessageimgOfOneMessage(mid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminDeleteAllMessagereplyOfOneMessage(int mid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            isOK = mapper.adminDeleteAllMessagereplyOfOneMessage(mid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

    public int adminSetMessageImg(String imgurl,int qid){
        int isOK = 0;

        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            isOK = mapper.adminSetMessageImg(imgurl,qid);
            sqlSession.commit();
        } catch (Exception e) {
            isOK = 0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return  isOK;
    }

}
