package com.neuedu.mapper;

import com.neuedu.po.Enterprise;
import com.neuedu.po.Message;
import com.neuedu.po.Messagelike;
import com.neuedu.po.Messagereply;

import java.util.ArrayList;

public interface MessageMapper {
    public ArrayList<Message> getAllMessage();

    public Boolean addMessagelike(Messagelike ml);

    public Boolean addMessagereply(Messagereply mr);

    public Boolean removeMessagelike(Messagelike ml);

    public Boolean removeMessagereply(Messagereply mr);

    ////////////////////////////////////////////////
    ////////////////////////////////////////////////

    public int getMessagelikeAmount(int qid);

    public int getMessagereplyAmount(int qid);
}
