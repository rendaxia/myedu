package com.neuedu.po;

import java.util.ArrayList;

public class Message {
    private int mid;
    private String mtitle;
    private String mtime;
    private int qid;
    private ArrayList<Messageimg> imgs;
    private ArrayList<Messagelike> likes;

    public void setImg(ArrayList<Messageimg> imgs) {
        this.imgs = imgs;
    }

    public void setLike(ArrayList<Messagelike> likes) {
        this.likes = likes;
    }

    public ArrayList<Messageimg> getImgs() {
        return imgs;
    }

    public ArrayList<Messagelike> getLikes() {
        return likes;
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
