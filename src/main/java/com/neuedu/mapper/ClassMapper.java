package com.neuedu.mapper;

import com.neuedu.po.*;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ClassMapper {
    public ArrayList<Lesson> getAllLessonByCondition(@Param("category")String type, @Param("branchid")int branchid);

    public ArrayList<Freelisten> getAllFreelistenByCondition(@Param("category")String type, @Param("branchid")int branchid);

    public Boolean freelistenCancel(int fid, String openid);


    ///////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    public int adminGetLessonAmount(int qid) throws Exception;

    public int adminGetFreelistenAmount(int qid) throws Exception;

    public ArrayList<Lesson> adminGetAllLessonByCondition(@Param("qid")int qid,@Param("branchid")int branchid) throws Exception;

    public ArrayList<Lesson> adminGetAllLessonByConditionInPage(@Param("qid")int qid,@Param("branchid")int branchid,@Param("start")int start,@Param("n")int n) throws Exception;

    public int adminGetLessonByConditionAmount(@Param("qid")int qid,@Param("branchid")int branchid) throws Exception;

    public ArrayList<Freelisten> adminGetAllFreelistenByCondition(@Param("qid")int qid,@Param("branchid")int branchid) throws Exception;

    public ArrayList<Freelisten> adminGetAllFreelistenByConditionInPage(@Param("qid")int qid,@Param("branchid")int branchid,@Param("start")int start,@Param("n")int n) throws Exception;

    public int adminGetFreelistenByConditionAmount(@Param("qid")int qid,@Param("branchid")int branchid) throws Exception;

    public Lesson adminGetOneLesson(int lid)throws  Exception;

    public Freelisten adminGetOneFreelisten(int id)throws  Exception;

    public int adminAddOneLesson(Lesson lesson)throws Exception;

    public int adminAddOneLessonbranch(Lessonbranch lessonbranch)throws Exception;

    public int adminAddOneFreelisten(Freelisten freelisten)throws  Exception;

    public int adminSetOneLesson(Lesson lesson)throws Exception;

    public int adminSetOneLessonbranch(Lessonbranch lessonbranch)throws  Exception;

    public int adminSetOneFreelisten(Freelisten freelisten)throws  Exception;

    public int adminDeleteOneLesson(int lid) throws  Exception;

    public int adminDeleteOneLessonbranch(int id)throws Exception;

    public int adminDeleteOneFreelisten(int id)throws  Exception;

    public Lesson adminGetOneLessonByLnameAndQidAndCategory(String lname,int qid,String category)throws  Exception;

    public Address adminGetOneAddressByLid(int lid)throws Exception;

    public Lessonbranch adminGetOneLessonbranch(int lid,int branchid) throws  Exception;

    public ArrayList<Freelistenbook> adminGetAllFreelistenbookByCondition(@Param("qid")int qid,@Param("fid")int fid,@Param("status")String status,@Param("username")String username,@Param("startTime")String startTime,@Param("endTime")String endTime)throws  Exception;

    public ArrayList<Freelistenbook> adminGetAllFreelistenbookByConditionInPage(@Param("qid")int qid,@Param("fid")int fid,@Param("status")String status,@Param("username")String username,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("start")int start,@Param("n")int n)throws  Exception;

    public int adminConfirmFreelistenbook(int id)throws  Exception;

    public ArrayList<Sorder> adminGetAllSorderByCondition(@Param("qid")int qid,@Param("lid")int lid,@Param("status")String status,@Param("nickname")String nickname,@Param("startTime")String startTime,@Param("endTime")String endTime)throws  Exception;

    public ArrayList<Sorder> adminGetAllSorderByConditionInPage(@Param("qid")int qid,@Param("lid")int lid,@Param("status")String status,@Param("nickname")String nickname,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("start")int start,@Param("n")int n)throws  Exception;

    public int adminRefundSorder(int oid)throws  Exception;

    public int adminCAVSorder(int oid)throws  Exception;

}
