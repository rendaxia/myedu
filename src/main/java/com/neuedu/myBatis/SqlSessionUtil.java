package com.neuedu.myBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    public static SqlSession sqlSession;


    private static SqlSessionFactory ssf = null;

    static {
        // 加载Mybatis的主配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 创建生产session的工厂类 session不是作用域 -- 相当于connection
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        ssf = sfb.build(is);
    }

    public static SqlSession getSession() {
        return ssf.openSession();
    }

}
