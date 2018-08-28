package com.nsfocus.controller;

import com.nsfocus.bean.Grade;
import com.nsfocus.bean.Student;
import com.nsfocus.bean.User;
import com.nsfocus.bo.ResultSet;
import com.nsfocus.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("repairPassword.do")
    public ModelAndView resetPassword(HttpServletRequest request, HttpSession session) {
        String newPassword = request.getParameter("newPassword");
        User user = (User) session.getAttribute("user");
        user.setPassword(newPassword);
        studentService.repairPassword(user);
        ModelAndView modelAndView = new ModelAndView();
        ResultSet resultSet = new ResultSet();
        resultSet.setMsg("学生密码重置成功");
        modelAndView.addObject("resultSet", resultSet);
        modelAndView.setViewName(request.getContextPath() + "common/msg.jsp");
        return modelAndView;
    }

    @RequestMapping("repairNote.do")
    public ModelAndView repairNote(HttpServletRequest request, HttpSession session) {
        String note = request.getParameter("note");
        ModelAndView modelAndView = new ModelAndView();
        Student student = new Student();
        User user = (User) session.getAttribute("user");
        student.setStudentname(user.getUsername());
        student.setNote(note);
        studentService.repairNote(student);
        ResultSet resultSet = new ResultSet();
        resultSet.setMsg("修改个人备注信息成功");
        modelAndView.addObject(resultSet);
        modelAndView.setViewName(request.getContextPath() + "common/msg.jsp");
        return modelAndView;
    }

    @RequestMapping("queryGrade.do")
    public ModelAndView queryGrade(HttpServletRequest request, HttpSession session) {
        Student student = new Student();
        User user = (User) session.getAttribute("user");
        student.setStudentname(user.getUsername());
        List<Grade> grades = studentService.queryGrade(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("grades", grades);
        modelAndView.setViewName(request.getContextPath() + "student/rstu.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)  //感觉这些地方是需要加斜杠的
    public ModelAndView uploadImg(HttpServletRequest request, @RequestParam("file") MultipartFile myfile) throws IOException {
        String path = request.getServletContext().getRealPath("/upload");
        File dir = new File(path);
        String filePath = path + File.separator + myfile.getOriginalFilename();
        System.out.println(filePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        myfile.transferTo(new File(dir.getAbsolutePath() + "/" + myfile.getOriginalFilename()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "图片上传成功");
        modelAndView.setViewName(request.getContextPath() + "student/imgstu.jsp");
        return modelAndView;
    }
}

