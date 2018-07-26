package com.nsfocus.controller;

import com.nsfocus.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/isLogin.do")
    public void isLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String auth=request.getParameter("auth");
        int authh=Integer.valueOf(auth);
        boolean islogin=userService.isLogin(username,password,authh,session);
        if(islogin&&authh==1)
        {
            request.getRequestDispatcher(request.getContextPath()+"teacher/tmanager.jsp").forward(request,response);
            return;
        }
        if(islogin&&authh==2)
        {
            request.getRequestDispatcher(request.getContextPath()+"student/smanager.jsp").forward(request,response);
            return;
        }
        if(islogin&&authh==3)
        {
            request.getRequestDispatcher(request.getContextPath()+"manage/manager.jsp").forward(request,response);
            return;
        }
        response.sendRedirect(request.getContextPath()+"main/login.jsp");
    }
}
