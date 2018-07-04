package com.neuedu.service;


import com.neuedu.myBatis.SqlSessionUtil;
import com.neuedu.po.*;
import com.neuedu.mapper.*;
import com.neuedu.tools.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DisplayServiceImpl implements DisplayService{
    @Override
    public ArrayList<Lesson> getAllLessonByCondition(String type, String address) {
        int branchid=0;
        ArrayList<Lesson> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        CompanyMapper com_mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            branchid = com_mapper.getAddressid(address);
            //System.out.println(branchid);
            //System.out.println(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            list = mapper.getAllLessonByCondition(type,branchid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Freelisten> getAllFreelistenByCondition(String type, String address) {
        ArrayList<Freelisten> list=null;
        int branchid=0;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        CompanyMapper com_mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            branchid = com_mapper.getAddressid(address);
            //System.out.println(branchid);
            //System.out.println(type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            list = mapper.getAllFreelistenByCondition(type,branchid);
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
        ArrayList<Messageimg> imgList=null;
        ArrayList<Messagelike> likeList=null;
        ArrayList<Messagereply> replyList=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.getAllMessage();
            imgList = mapper.getAllMessageimg();
            likeList = mapper.getAllMessagelike();
            replyList = mapper.getAllMessagereply();
            list = mapper.getAllMessage();
            for(int i=0;i<list.size();i++){
                for(Messageimg img:imgList){
                    if(list.get(i).getMid()==img.getMid()){
                        list.get(i).getMessageimgs().add(img);

                    }
                }
                for(Messagelike like:likeList){
                    if(list.get(i).getMid()==like.getMid()){
                        list.get(i).getMessagelikes().add(like);
                    }
                }
                for(Messagereply reply:replyList){
                    if(list.get(i).getMid()==reply.getMid()){
                        list.get(i).getMessagereplies().add(reply);
                    }

                }
            }
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


    public ArrayList<Message> getAllMessagelikeByCondition(String nickname) {
        ArrayList<Message> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.getAllMessagelikeByCondition(nickname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Message> getAllMessagereplyByCondition(String nickname) {
        ArrayList<Message> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.getAllMessagereplyByCondition(nickname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Integer> getAllMessagelikeByMessage() {
        ArrayList<Integer> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.getAllMessagelikeByMessage();
            System.out.println(list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Integer> getAllMessagereplyByMessage() {
        ArrayList<Integer> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.getAllMessagereplyByMessage();
            System.out.println("reply:"+list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean adminCheckUser(String username, String userpassword) {
        boolean isOK = false;
        int result = 0;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.adminCheckUser(username,userpassword);
            if (result > 0){
                isOK = true;
            }else {
                isOK = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return isOK;
    }

    @Override
    public int adminGetQidOfUser(String username, String userpassword) {
        int result = -1 ;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.adminGetQidOfUser(username,userpassword);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int adminGetTeacherAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.adminGetTeacherAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int adminGetLessonAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            result = mapper.adminGetLessonAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int adminGetFreelistenAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            result = mapper.adminGetFreelistenAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }


    public int adminGetSorderAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        SorderMapper mapper = sqlSession.getMapper(SorderMapper.class);
        try {
            result = mapper.adminGetSorderAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int adminGetFreelistenbookAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        FreelistenbookMapper mapper = sqlSession.getMapper(FreelistenbookMapper.class);
        try {
            result = mapper.adminGetFreelistenbookAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int adminGetMessagereplyAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            result = mapper.adminGetMessagereplyAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int adminGetMessagelikeAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            result = mapper.adminGetMessagelikeAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public Enterprise adminGetOneEnterprise(int qid){
        Enterprise result = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.adminGetOneEnterprise(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public String adminGetEnterpriseImgurl(int qid,String category){
        String result = "";
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.adminGetEnterpriseImgurl(qid,category);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public ArrayList<Address> adminGetAllAddress(int qid){
        ArrayList<Address> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            list = mapper.adminGetAllAddress(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;

    }


    public Address adminSelectOneAddress(int id){
        Address address = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            address= mapper.adminSelectOneAddress(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return address;

    }

    public int adminGetAddressAmount(int qid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.adminGetAddressAmount(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public ArrayList<Address> adminGetSomeAddressInPage(int page,int qid){
        ArrayList<Address> list;
        SqlSession session=SqlSessionUtil.getSession();
        int x=(page-1)*AddressPages.N;

        try {
            CompanyMapper mapper=session.getMapper(CompanyMapper.class);
            list = mapper.adminGetSomeAddressInPage(qid,x,AddressPages.getN());
        } catch (Exception e) {
            list=null;
            e.printStackTrace();
        }finally{
            session.close();
        }
        return list;
    }

    public ArrayList<Teacher> adminGetAllTeacher(int qid){
        ArrayList<Teacher> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            list = mapper.adminGetAllTeacher(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    public ArrayList<Teacher> adminGetSomeTeacherInPage(int page,int qid){
        ArrayList<Teacher> list;
        SqlSession session=SqlSessionUtil.getSession();
        int x=(page-1)*TeacherPages.N;

        try {
            CompanyMapper mapper=session.getMapper(CompanyMapper.class);
            list = mapper.adminGetSomeTeacherInPage(qid,x,TeacherPages.getN());
        } catch (Exception e) {
            list=null;
            e.printStackTrace();
        }finally{
            session.close();
        }
        return list;
    }

    public Teacher adminSelectOneTeacher(int tid){
        Teacher teacher = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            teacher= mapper.adminSelectOneTeacher(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return teacher;
    }

    public String adminGetTeacherImg(int qid){
        String result = "";
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
        try {
            result = mapper.adminGetTeacherImg(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public ArrayList<Lesson> adminGetAllLessonByCondition(int qid,int branchid){
        ArrayList<Lesson> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            list = mapper.adminGetAllLessonByCondition(qid,branchid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    public ArrayList<Lesson> adminGetAllLessonByConditionInPage(int qid,int branchid,int page){

        ArrayList<Lesson> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        int x=(page-1)*AddressPages.N;
        try {
            list = mapper.adminGetAllLessonByConditionInPage(qid, branchid, x,AddressPages.getN());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    public int adminGetLessonByConditionAmount(int qid,int branchid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            result = mapper.adminGetLessonByConditionAmount(qid,branchid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;

    }


    public ArrayList<Freelisten> adminGetAllFreelistenByCondition(int qid,int branchid){
        ArrayList<Freelisten> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            list = mapper.adminGetAllFreelistenByCondition(qid,branchid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    public ArrayList<Freelisten> adminGetAllFreelistenByConditionInPage(int qid,int branchid,int page){

        ArrayList<Freelisten> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        int x=(page-1)*AddressPages.N;
        try {
            list = mapper.adminGetAllFreelistenByConditionInPage(qid, branchid, x,AddressPages.getN());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    public int adminGetFreelistenByConditionAmount(int qid,int branchid){
        int result = -1;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            result = mapper.adminGetFreelistenByConditionAmount(qid,branchid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public Lesson adminGetOneLesson(int lid){
        Lesson lesson = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            lesson= mapper.adminGetOneLesson(lid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return lesson;
    }

    public Freelisten adminGetOneFreelisten(int id){
        Freelisten freelisten = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            freelisten= mapper.adminGetOneFreelisten(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return freelisten;
    }
    public  Lesson adminGetOneLessonByLnameAndQidAndCategory(String lname,int qid,String category){
        Lesson lesson = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            lesson= mapper.adminGetOneLessonByLnameAndQidAndCategory(lname,qid,category);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return lesson;
    }

    public Address adminGetOneAddressByLid(int lid ){
        Address address = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            address= mapper.adminGetOneAddressByLid(lid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return address;
    }
    public Lessonbranch adminGetOneLessonbranch(int lid,int branchid){
        Lessonbranch lessonbranch = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        try {
            lessonbranch= mapper.adminGetOneLessonbranch(lid,branchid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return lessonbranch;
    }

    public ArrayList<Freelistenbook> adminGetAllFreelistenbookByCondition(int qid,int fid,String status,String username,String startTime,String endTime){

        ArrayList<Freelistenbook> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        //int x=(page-1)*AddressPages.N;
        try {
            list = mapper.adminGetAllFreelistenbookByCondition(qid, fid, status, username, startTime, endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    public ArrayList<Freelistenbook> adminGetAllFreelistenbookByConditionInPage(int qid,int fid,String status,String username,String startTime,String endTime,int page){
        ArrayList<Freelistenbook> list=null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        int x=(page-1)*AddressPages.N;
        try {
            list = mapper.adminGetAllFreelistenbookByConditionInPage(qid, fid, status, username, startTime, endTime,x,FreelistenbookPages.getN());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    public ArrayList<Sorder> adminGetAllSorderByCondition(int qid,int lid,String status,String nickname,String startTime,String endTime){
        ArrayList<Sorder> list = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        //int x=(page-1)*AddressPages.N;
        try {
            list = mapper.adminGetAllSorderByCondition(qid, lid, status, nickname, startTime, endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return  list;
    }

    public ArrayList<Sorder> adminGetAllSorderByConditionInPage(int qid,int lid,String status,String nickname,String startTime,String endTime,int page){
        ArrayList<Sorder> list = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
        int x=(page-1)*AddressPages.N;
        try {
            list = mapper.adminGetAllSorderByConditionInPage(qid, lid, status, nickname, startTime, endTime,x,SorderPages.getN());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return  list;
    }

    public ArrayList<Message> adminGetAllMessage(int qid){
        ArrayList<Message> list = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        //int x=(page-1)*AddressPages.N;
        try {
            list = mapper.adminGetAllMessage(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return  list;
    }

    public ArrayList<Message> adminGetAllMessageInPage(int qid,int page){
        ArrayList<Message> list = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        int x=(page-1)*AddressPages.N;
        try {
            list = mapper.adminGetAllMessageInPage(qid,x,MessagePages.getN());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return  list;
    }

    public ArrayList<Messagelike> adminGetSomeMessagelikeOfOneMessage(int mid){
        ArrayList<Messagelike> list = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.adminGetSomeMessagelikeOfOneMessage(mid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return  list;
    }

    public ArrayList<Messagereply> adminGetSomeMessagereplyOfOneMessage(int mid){
        ArrayList<Messagereply> list = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.adminGetSomeMessagereplyOfOneMessage(mid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return  list;
    }

    public ArrayList<Messageimg> adminGetSomeMessageimgOfOneMessage(int mid){
        ArrayList<Messageimg> list = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            list = mapper.adminGetSomeMessageimgOfOneMessage(mid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return  list;
    }


    public Message adminGetOneMessageByMtimeAndMtitle(String mtitle){
        Message message = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            message = mapper.adminGetOneMessageByMtimeAndMtitle(mtitle);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return message;
    }

    public String adminGetMessageImg(int qid){
        String imgurl  = null;
        SqlSession sqlSession = SqlSessionUtil.getSession();
        MessageMapper mapper = sqlSession.getMapper(MessageMapper.class);
        try {
            imgurl = mapper.adminGetMessageImg(qid);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return imgurl;
    }


}
