package com.neuedu.mapper;

import com.neuedu.po.Address;
import com.neuedu.po.Enterprise;
import com.neuedu.po.Teacher;
import com.neuedu.po.User;
import com.sun.tools.javac.comp.Enter;
import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;

public interface CompanyMapper {
    public ArrayList<Teacher> getAllTeacher();

    public ArrayList<Address> getAllAddress();

    public ArrayList<Enterprise> getAllEnterprise();


    ///////////////////////////////////////////
    ///////////////////////////////////////////

    public int adminCheckUser(String username,String userpassword) throws Exception;

    public int adminGetQidOfUser(String username,String userpassword)throws Exception;

    public int adminGetTeacherAmount(int qid)throws Exception;

    public Enterprise adminGetOneEnterprise(int qid)throws  Exception;

    public String adminGetEnterpriseImgurl(int qid,String catogory)throws  Exception;

    public int adminSetEnterprise(Enterprise enterprise)throws  Exception;

    public int adminSetEnterpriseImgurl(String imgurl ,int qid)throws  Exception;

    public ArrayList<Address> adminGetAllAddress(int qid)throws Exception;

    public Address adminSelectOneAddress(int id)throws  Exception;

    public int adminGetAddressAmount(int qid)throws  Exception;

    public ArrayList<Address> adminGetSomeAddressInPage( int qid,int start,int n)throws  Exception;

    public int adminAddOneAddress(Address address)throws  Exception;

    public int adminSetOneAddress(Address address)throws  Exception;

    public int adminDeleteOneAddress(int id)throws  Exception;

    public ArrayList<Teacher> adminGetAllTeacher(int qid)throws Exception;

    public ArrayList<Teacher> adminGetSomeTeacherInPage(int qid,int start,int n)throws  Exception;

    public Teacher adminSelectOneTeacher(int tid)throws Exception;

    public int adminSetOneTeacher(Teacher teacher)throws  Exception;

    public int adminAddOneTeacher(Teacher teacher)throws  Exception;

    public  int adminDeleteOneTeacher(int tid)throws  Exception;

    public String adminGetTeacherImg(int qid) throws  Exception;

    public int adminSetTeacherImg(String goalUrl,int qid)throws Exception;


}
