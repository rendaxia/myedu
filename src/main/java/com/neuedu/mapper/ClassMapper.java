package com.neuedu.mapper;

import com.neuedu.po.Freelisten;
import com.neuedu.po.Lesson;

import java.util.ArrayList;

public interface ClassMapper {
    public ArrayList<Lesson> getAllLessonByCondition(String type, String address);

    public ArrayList<Freelisten> getAllFreelistenByCondition(String type, String address);

    public Boolean freelistenBook(int fid, String username, String tel, String comment, String openid);

    public Boolean freelistenCancel(int fid, String openid);


    ///////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

    public int getLessonAmount(int qid) throws Exception;

    public int getFreelistenAmount(int qid) throws Exception;
}
