package com.neuedu.test;

import com.neuedu.mapper.SorderMapper;
import com.neuedu.po.Sorder;
import com.neuedu.myBatis.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args){
        ArrayList<Sorder> list=null;
        boolean isOK;
        Sorder s = new Sorder();
        SqlSession session = SqlSessionUtil.getSession();
        SorderMapper mapper = session.getMapper(SorderMapper.class);
        try {
            s.setLid(2);
            s.setActual(100);
            s.setNickname("rty");
            s.setOpenid("124");
            s.setStatus("已付款");
            s.setTel("15804049843");
            isOK = mapper.addToCart(s);
            //session.commit();
            //list = mapper.getRefundingSorder("oC9yV5HNntbgqDyPEg2J0YSY8dC8");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if(list!=null){
//            for(Sorder s: list){
//                System.out.println(s.getNickname()+" "+s.getTel());
//            }
//
//        }
    }
}
