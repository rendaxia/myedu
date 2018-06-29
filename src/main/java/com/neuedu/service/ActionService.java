package com.neuedu.service;

import com.neuedu.po.Address;
import com.neuedu.po.Enterprise;
import com.neuedu.po.Teacher;

public interface ActionService {
    public Boolean freelistenBook(int fid, String username, String tel, String comment, String openid);

    public Boolean freelistenCancel(int fid, String openid);

    public Boolean addToCart(int lid, String openid, double total, String username, String tel);

    public Boolean paySorder(int lid, String openid, double actual);

    public Boolean refundSorder(int lid, String openid);

    public Boolean addMessagelike(int mid, String username);

    public Boolean addMessagereply(int mid, String username, String content);

    public Boolean removeMessagelike(int mid, String username);

    public Boolean removeMessagereply(int mid, String username);


    ///////////////////////////////////////////////////

    public int adminSetEnterprise(Enterprise enterprise);

    public int adminSetEnterpriseImgurl(String imgurl,int qid);

    public int adminAddOneAddress(Address address);

    public int adminSetOneAddress(Address address);

    public int adminDeleteOneAddress(int id);

    public int adminSetOneTeacher(Teacher teacher);

    public int adminAddOneTeacher(Teacher teacher);

    public  int adminDeleteOneTeacher(int tid);

    public int adminSetTeacherImg(String goalUrl,int qid);
}
