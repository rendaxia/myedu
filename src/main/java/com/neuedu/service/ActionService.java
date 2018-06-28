package com.neuedu.service;

import com.neuedu.po.Enterprise;

public interface ActionService {
    public Boolean freelistenBook(int fid, String username, String tel, String comment, String openid);

    public Boolean freelistenCancel(int fid, String openid);

    public Boolean addToCart(int lid, String openid, double total, String username, String tel);

    public Boolean paySorder(int lid, String openid, double actual);

    public Boolean refundSorder(int lid, String openid);

    public Boolean addMessagelike(int mid, String username);

    public Boolean addMessagereply(int mid, String username, String content);

    public Boolean removeMessagelike(int mid, String username);

    public Boolean removeMessagereply(int mid, String username);


    ///////////////////////////////////////////////////

    public int setEnterprise(Enterprise enterprise);
}
