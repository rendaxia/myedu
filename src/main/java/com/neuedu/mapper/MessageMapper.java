package com.neuedu.mapper;

import com.neuedu.po.*;

import java.util.ArrayList;

public interface MessageMapper {
    public ArrayList<Message> getAllMessage();

    public ArrayList<Messageimg> getAllMessageimg();

    public ArrayList<Messagereply> getAllMessagereply();

    public ArrayList<Messagelike> getAllMessagelike();

    public Boolean addMessagelike(Messagelike ml);

    public Boolean addMessagereply(Messagereply mr);

    public Boolean removeMessagelike(Messagelike ml);

    public Boolean removeMessagereply(Messagereply mr);

    public ArrayList<Message> getAllMessagelikeByCondition(String nickname);

    public ArrayList<Message> getAllMessagereplyByCondition(String nickname);

    public ArrayList<Integer> getAllMessagelikeByMessage();

    public ArrayList<Integer> getAllMessagereplyByMessage();

    ////////////////////////////////////////////////
    ////////////////////////////////////////////////

    public int adminGetMessagelikeAmount(int qid)throws Exception;

    public int adminGetMessagereplyAmount(int qid)throws  Exception;

    public ArrayList<Message> adminGetAllMessage(int qid)throws  Exception;

    public ArrayList<Message> adminGetAllMessageInPage(int qid,int start,int n)throws  Exception;

    public ArrayList<Messagelike> adminGetSomeMessagelikeOfOneMessage(int mid)throws  Exception;

    public ArrayList<Messagereply> adminGetSomeMessagereplyOfOneMessage(int mid)throws  Exception;

    public ArrayList<Messageimg> adminGetSomeMessageimgOfOneMessage(int mid)throws  Exception;

    public int adminAddOneMessage(Message message)throws  Exception;

    public int adminAddOneMessageimg(Messageimg messageimg )throws Exception;

    public Message adminGetOneMessageByMtimeAndMtitle(String mtitle)throws  Exception;

    public int adminDeleteOneMessage(int mid)throws Exception;

    public int adminDeleteAllMessagelikeOfOneMessage(int mid)throws Exception;

    public int adminDeleteOneMessagereplyOfOneMessage(int id)throws Exception;

    public int adminDeleteAllMessageimgOfOneMessage(int mid)throws Exception;

    public int adminDeleteAllMessagereplyOfOneMessage(int mid)throws Exception;

    public String adminGetMessageImg(int qid)throws  Exception;

    public int adminSetMessageImg(String imgurl,int qid)throws  Exception;


}
