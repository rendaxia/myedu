package com.neuedu.po;

import java.util.ArrayList;

public class Message {
    private int mid;
    private String mtitle;
    private String mtime;
    private int qid;
    private ArrayList<Messageimg> img;
    private ArrayList<Messagelike> like;

    public void setImg(ArrayList<Messageimg> img) {
        this.img = img;
    }

    public void setLike(ArrayList<Messagelike> like) {
        this.like = like;
    }

    public ArrayList<Messageimg> getImg() {
        return img;
    }

    public ArrayList<Messagelike> getLike() {
        return like;
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
