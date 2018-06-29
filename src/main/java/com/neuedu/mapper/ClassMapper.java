package com.neuedu.mapper;

import com.neuedu.po.Freelisten;
import com.neuedu.po.Lesson;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ClassMapper {
    public ArrayList<Lesson> getAllLessonByCondition(@Param("category")String type, @Param("branchid")int branchid);

    public ArrayList<Freelisten> getAllFreelistenByCondition(@Param("category")String type, @Param("branchid")int branchid);

    public Boolean freelistenBook(int fid, String username, String tel, String comment, String openid);

    public Boolean freelistenCancel(int fid, String openid);


    ///////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    public int adminGetLessonAmount(int qid) throws Exception;

    public int adminGetFreelistenAmount(int qid) throws Exception;
}
