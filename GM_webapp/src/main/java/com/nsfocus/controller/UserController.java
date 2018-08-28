package com.nsfocus.controller;

import com.nsfocus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("isLogin.do")
    public void isLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String auth=request.getParameter("auth");
        System.out.println(request.getContextPath());
        System.out.println(request.getServletContext().getRealPath(""));
        int authh=Integer.valueOf(auth);
        boolean islogin=userService.isLogin(username,password,authh,session);
        if(islogin&&authh==1)
        {
            //String path="http://"+request.getHeader("host")+"/teacher/teacher.jsp";
            String path=request.getContextPath()+"teacher/teacher.jsp";
            request.getRequestDispatcher(path).forward(request,response);
            System.out.println(path);
            return;
        }
        if(islogin&&authh==2)
        {
            String path="http://"+request.getHeader("host")+"/student/student.jsp";
            response.sendRedirect(path);
            //request.getRequestDispatcher(path).forward(request,response);
            System.out.println(path);
            return;
        }
        if(islogin&&authh==3)
        {
            String path=request.getContextPath()+"manage/manager.jsp";
            request.getRequestDispatcher(path).forward(request,response);
            System.out.println(path);
            return;
        }
        response.sendRedirect(request.getContextPath()+"main/login.jsp");
    }

    @RequestMapping("logout.do")
    public void logout(HttpSession session,HttpServletResponse response,HttpServletRequest request)
    {
        session.invalidate();
        try {
            response.sendRedirect(request.getContextPath()+"main/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
