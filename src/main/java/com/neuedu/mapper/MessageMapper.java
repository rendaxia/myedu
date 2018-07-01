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

    public int adminGetMessagelikeAmount(int qid);

    public int adminGetMessagereplyAmount(int qid);



}
