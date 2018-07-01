package com.neuedu.po;

import java.util.ArrayList;

public class Message {
    private int mid;
    private String mtitle;
    private String mtime;
    private int qid;
    private ArrayList<Messageimg> messageimgs = new ArrayList<>();
    private ArrayList<Messagelike> messagelikes = new ArrayList<>();
    private ArrayList<Messagereply> messagereplies = new ArrayList<>();

    public void setMessageimgs(ArrayList<Messageimg> messageimgs) {
        this.messageimgs = messageimgs;
    }

    public void setMessagelikes(ArrayList<Messagelike> messagelikes) {
        this.messagelikes = messagelikes;
    }

    public void setMessagereplies(ArrayList<Messagereply> messagereplies) {
        this.messagereplies = messagereplies;
    }

    public ArrayList<Messageimg> getMessageimgs() {
        return messageimgs;
    }

    public ArrayList<Messagelike> getMessagelikes() {
        return messagelikes;
    }

    public ArrayList<Messagereply> getMessagereplies() {
        return messagereplies;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }
}
