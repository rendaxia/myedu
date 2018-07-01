package com.neuedu.mapper;

import com.neuedu.po.Freelistenbook;

import java.util.ArrayList;

public interface FreelistenbookMapper {
    public ArrayList<Freelistenbook> getFreelistenbook() throws Exception;


    public ArrayList<Freelistenbook> getFreelistenbook(String openid) throws Exception;

    public boolean cancelFreelistenbook(String openid,int fid) throws Exception;

    public boolean freelistenbook(Freelistenbook fb) throws Exception;

    //////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////


    public  int adminGetFreelistenbookAmount(int qid)throws  Exception;

}
