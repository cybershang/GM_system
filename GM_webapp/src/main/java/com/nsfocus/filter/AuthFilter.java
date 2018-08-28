package com.nsfocus.filter;


import com.nsfocus.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        User user =(User) request.getSession().getAttribute("user");
        if(user==null && !(request.getServletPath().indexOf("login.jsp")>0)&&!(request.getServletPath().indexOf("isLogin.do")>0))
        {
            request.setAttribute("msg","请先登陆");
            response.sendRedirect("../"+request.getContextPath()+"main/login.jsp");
            return;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
