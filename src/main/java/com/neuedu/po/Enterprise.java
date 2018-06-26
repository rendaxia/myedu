package com.neuedu.po;

public class Enterprise {
    private int qid;
    private String name;
    private String videopath;
    private String introduction;
    private String jczs;

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJczs() {
        return jczs;
    }

    public void setJczs(String jczs) {
        this.jczs = jczs;
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
