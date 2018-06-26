package com.neuedu.mapper;

import com.neuedu.po.Sorder;

import java.util.ArrayList;

public interface SorderMapper {


    public ArrayList<Sorder> getSorder(String openid) throws Exception;//获得已付款订单

    public ArrayList<Sorder> getRefundingSorder(String openid) throws Exception;//获得退款中订单

    public ArrayList<Sorder> getRefundedSorder(String openid) throws Exception;//获得已退款订单

    public ArrayList<Sorder> getUsedSorder(int openid) throws Exception;//获得已使用订单

    //将课程添加至购物车（待付款）
    public boolean addToCart(Sorder s)throws Exception;

    public boolean paySorder(int lid, int openid,int actual)throws Exception;//付款

    public boolean refundSorder(int lid, int openid) throws Exception;//申请退款

    //我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王我爱颜王

    //caonima////////



}
