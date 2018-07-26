package com.nsfocus.controller;

import com.nsfocus.bean.Role;
import com.nsfocus.bean.Teacher;
import com.nsfocus.bean.User;
import com.nsfocus.service.ManagerService;
import com.nsfocus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("selectTeacher.do")
    public ModelAndView selectTeacher(HttpServletRequest request, HttpServletResponse response)
    {
        List<User> teacherList=managerService.queryTeacher();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("teacherList",teacherList);
        modelAndView.setViewName(request.getContextPath()+"manage/ttmsg.jsp");
        return modelAndView;
    }
    @RequestMapping("deleteTeacher.do")
    public ModelAndView deleteTeacher(HttpServletRequest request,HttpServletResponse response)
    {
       // String id=request.getParameter("id");
        User user=new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setUsername(request.getParameter("teachername"));
        managerService.deleteTeacher(user);
        List<User> teacherList=managerService.queryTeacher();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("teacherList",teacherList);
        modelAndView.setViewName(request.getContextPath()+"manage/ttmsg.jsp");
        return modelAndView;
    }
    @RequestMapping("addTeacher.do")
    public ModelAndView addTeacher(HttpServletRequest request,HttpServletResponse response)
    {
         String username=request.getParameter("teachername");
         String password=request.getParameter("teacherpassword");
         User user=new User();
         user.setUsername(username);
         user.setPassword(password);
         Role role=new Role();
         role.setId(1);
         user.setRole(role);
         managerService.insertTeacher(user);
         List<User> teacherList=managerService.queryTeacher();
         ModelAndView modelAndView=new ModelAndView();
         modelAndView.addObject("teacherList",teacherList);
         modelAndView.setViewName(request.getContextPath()+"manage/ttmsg.jsp");
         return modelAndView;
    }
}
