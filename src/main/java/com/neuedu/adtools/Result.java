package com.neuedu.adtools;

import java.io.Serializable;
public class Result<T> implements Serializable {
    /** 错误码. */
    private Integer errno;
    /** 具体的内容. */
    private String [] data;

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}