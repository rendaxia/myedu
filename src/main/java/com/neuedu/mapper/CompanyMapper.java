package com.neuedu.mapper;

import com.neuedu.po.Address;
import com.neuedu.po.Enterprise;
import com.neuedu.po.Teacher;
import com.neuedu.po.User;
import com.sun.tools.javac.comp.Enter;

import java.util.ArrayList;

public interface CompanyMapper {
    public ArrayList<Teacher> getAllTeacher();

    public ArrayList<Address> getAllAddress();

    public ArrayList<Enterprise> getAllEnterprise();


    ///////////////////////////////////////////
    ///////////////////////////////////////////

    public int checkUser(String username,String userpassword) throws Exception;

    public int getQidOfUser(String username,String userpassword)throws Exception;

    public int getTeacherAmount(int qid)throws Exception;

    public Enterprise getOneEnterprise(int qid)throws  Exception;

    public String getEnterpriseImgurl(int qid,String catogory)throws  Exception;

    public int setEnterprise(Enterprise enterprise)throws  Exception;
}
