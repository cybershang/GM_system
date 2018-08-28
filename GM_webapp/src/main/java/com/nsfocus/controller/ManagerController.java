package com.nsfocus.controller;

import com.nsfocus.bean.Role;
import com.nsfocus.bean.Student;
import com.nsfocus.bean.Teacher;
import com.nsfocus.bean.User;
import com.nsfocus.bo.RePasswordBean;
import com.nsfocus.bo.ResultSet;
import com.nsfocus.service.ManagerService;
import com.nsfocus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
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
    @RequestMapping("selectStudent.do")
    public ModelAndView selectStudent(HttpServletRequest request)
    {
        List<User> studentList=managerService.queryStudent();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName(request.getContextPath()+"manage/slmsg.jsp");
        return modelAndView;
    }

    @RequestMapping("deleteStudent.do")
    public ModelAndView deleteStudent(HttpServletRequest request,HttpServletResponse response)
    {
        // String id=request.getParameter("id");
        User user=new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setUsername(request.getParameter("studentname"));
        managerService.deleteStudent(user);
        List<User> studentList=managerService.queryStudent();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName(request.getContextPath()+"manage/slmsg.jsp");
        return modelAndView;
    }
    @RequestMapping("addStudent.do")
    public ModelAndView addStudent(HttpServletRequest request,HttpServletResponse response)
    {
        String username=request.getParameter("studentname");
        String password=request.getParameter("studentpassword");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        Role role=new Role();
        role.setId(2);
        user.setRole(role);
        managerService.insertStudent(user);
        List<User> studentList=managerService.queryStudent();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName(request.getContextPath()+"manage/slmsg.jsp");
        return modelAndView;
    }
    //============================================================
    @RequestMapping("rePassword.do")
    public ModelAndView rePassword(HttpServletRequest request)
    {
        String username=request.getParameter("username");
        String oldPassword=request.getParameter("oldpassword");
        String newPassword=request.getParameter("newpassword");
        //调用service层完成数据的查找、校验、写入操作
        RePasswordBean rePasswordBean=new RePasswordBean();
        rePasswordBean.setUsername(username);
        rePasswordBean.setOldPassword(oldPassword);
        rePasswordBean.setNewPassword(newPassword);
        ResultSet resultSet=managerService.resetPassword(rePasswordBean);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("resultSet",resultSet);
        modelAndView.setViewName(request.getContextPath()+"common/msg.jsp");
        modelAndView.setViewName(request.getContextPath()+"common/msg.jsp");
        return modelAndView;
    }
}
