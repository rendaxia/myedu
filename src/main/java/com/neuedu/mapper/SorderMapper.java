package com.neuedu.mapper;

import com.neuedu.po.Freelisten;
import com.neuedu.po.Freelistenbook;
import com.neuedu.po.Sorder;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface SorderMapper {


//    public ArrayList<Sorder> getSorder(String openid) throws Exception;//获得已付款订单
//
//    public ArrayList<Sorder> getRefundingSorder(String openid) throws Exception;//获得退款中订单
//
//    public ArrayList<Sorder> getRefundedSorder(String openid) throws Exception;//获得已退款订单
//
//    public ArrayList<Sorder> getUsedSorder(int openid) throws Exception;//获得已使用订单

    //将课程添加至购物车（待付款）
    public boolean addToCart(Sorder s)throws Exception;

    public boolean paySorder(@Param("oid")int oid, @Param("openid")String openid)throws Exception;//付款

    public boolean refundSorder(int oid) throws Exception;//申请退款

    public boolean refundCart(int oid) throws Exception;//移出购物车

    public ArrayList<Sorder> getAllSorderByCondition(@Param("openid")String openid, @Param("status") String status);
    //////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    public int adminGetSorderAmount(int qid) throws Exception;


}
