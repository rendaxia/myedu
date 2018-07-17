package com.neuedu.service;

import com.neuedu.po.*;

public interface ActionService {
    public Boolean freelistenBook(int fid, String username, String tel, String comment, String openid);

    public Boolean freelistenCancel(int id);

    public Boolean addToCart(int lid, String openid, double total, String username, String tel);

    public Boolean paySorder(int lid, String openid);

    public Boolean refundSorder(int oid);

    public Boolean refundCart(int oid);

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

    public int adminAddOneLesson(Lesson lesson);

    public int adminAddOneLessonbranch(Lessonbranch lessonbranch);

    public int adminAddOneFreelisten(Freelisten freelisten);

    public int adminSetOneLesson(Lesson lesson);

    public int adminSetOneLessonbranch(Lessonbranch lessonbranch);

    public int adminSetOneFreelisten(Freelisten freelisten);

    public int adminDeleteOneLesson(int lid);

    public int adminDeleteOneLessonbranch(int id);

    public int adminDeleteOneFreelisten(int id);

    public int adminConfirmFreelistenbook(int id);

    public int adminRefundSorder(int oid);

    public int adminCAVSorder(int oid);

    public int adminAddOneMessage(Message message);

    public int adminAddOneMessageimg(Messageimg messageimg );

    public int adminDeleteOneMessage(int mid);

    public int adminDeleteAllMessagelikeOfOneMessage(int mid);

    public int adminDeleteOneMessagereplyOfOneMessage(int id);

    public int adminDeleteAllMessageimgOfOneMessage(int mid);

    public int adminDeleteAllMessagereplyOfOneMessage(int mid);

    public int adminSetMessageImg(String imgurl,int qid);

}
