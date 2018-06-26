package com.neuedu.po;

public class Refund {
    private int oid;
    private String refundreason;
    private String refundtime;
    private String status;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getRefundreason() {
        return refundreason;
    }

    public void setRefundreason(String refundreason) {
        this.refundreason = refundreason;
    }

    public String getRefundtime() {
        return refundtime;
    }

    public void setRefundtime(String refundtime) {
        this.refundtime = refundtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
