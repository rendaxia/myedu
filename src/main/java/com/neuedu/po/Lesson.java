package com.neuedu.po;

public class Lesson {
    private int lid;
    private String lname;
    private String imgurl;
    private double lprice;
    private String ldesc;
    private String category;
    private int qid;
    private String pubtime;
    private Lessonbranch lessonbranch;

    public Lessonbranch getLessonbranch() {
        return lessonbranch;
    }

    public void setLessonbranch(Lessonbranch lessonbranch) {
        this.lessonbranch = lessonbranch;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public double getLprice() {
        return lprice;
    }

    public void setLprice(double lprice) {
        this.lprice = lprice;
    }

    public String getLdesc() {
        return ldesc;
    }

    public void setLdesc(String ldesc) {
        this.ldesc = ldesc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }
}
