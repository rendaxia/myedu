package com.neuedu.tools;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminInterceptor implements  HandlerInterceptor{



    @Override
    public void afterCompletion(HttpServletRequest httpRequest,
                                HttpServletResponse httpResponse, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {


    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {
        HttpSession session = request.getSession();
        if (session!= null){
            if (session.getAttribute("isLogin")!=null){
                if (session.getAttribute("isLogin").equals("Yes")){
                    return  true;
                }
            }
        }

        request.getRequestDispatcher("/back/admin_login.jsp").forward(request,response);
        return false;


    }

}