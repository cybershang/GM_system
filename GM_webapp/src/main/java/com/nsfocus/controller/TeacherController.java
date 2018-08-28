package com.nsfocus.controller;

import com.nsfocus.bean.Grade;
import com.nsfocus.bean.User;
import com.nsfocus.bo.ResultSet;
import com.nsfocus.service.TeacherService;
import org.apache.commons.io.FileUtils;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("resetPassword.do")
    public ModelAndView resetPassword(HttpServletRequest request, HttpSession session) {
        String newPassword = request.getParameter("newPassword");
        User user = (User) session.getAttribute("user");
        user.setPassword(newPassword);
        teacherService.repairPassword(user);
        ModelAndView modelAndView = new ModelAndView();
        ResultSet resultSet = new ResultSet();
        resultSet.setMsg("老师密码重置成功");
        modelAndView.addObject("resultSet", resultSet);
        modelAndView.setViewName(request.getContextPath() + "common/msg.jsp");
        return modelAndView;
    }

    @RequestMapping("queryStudentGrade.do")
    public ModelAndView queryStudentGrade(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        ResultSet resultSet = teacherService.queryStudentGrade(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(request.getContextPath() + "teacher/mtea.jsp");
        modelAndView.addObject("grades", resultSet.getData());
        return modelAndView;
    }

    @RequestMapping("queryStudentMsg.do")
    public ModelAndView queryStudentMsg(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        ResultSet resultSet = teacherService.queryStduentMsg(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(request.getContextPath() + "teacher/rtea.jsp");
        modelAndView.addObject("grades", resultSet.getData());
        return modelAndView;
    }

    //这里有几种方法可以实现排序：
    //1 直接用list中自带的方法进行排序
    //2 通过数据库sql查询语句重新查找输出
    //这里选择第一种方法
    //本来是选择第一种的，但后台总是无法返回list参数，所以退而求其次，选择第二种
    @RequestMapping("sortGrade.do")
    public ModelAndView sortGrade(HttpServletRequest request,HttpSession session) {
        //List<Grade> gradeList = (List<Grade>) request.getAttribute("gradeList");
        //突然想起来，list好像有自己的排序函数
        /*for(int i=0;i<gradeList.size()-1;i++)
        {
            for(int j=1;j<gradeList.size()-i-1;j++)
            {
                if(gradeList.get(j).getScore()>gradeList.get(j+1).getScore()){
　　　　　　　　　　 Grade temp=gradeList.get(j);
　　　　　　　　　　gradeList.get(j)=gradeList.get(j+1);
　　　　　　　　　　gradeList.get(j+1)=temp;
　　　　　　　　}
            }
        }*/
        //1 获取User对象获取teacher id
        User teacher =(User)session.getAttribute("user");
        List<Grade> gradeList=teacherService.queryAndSortGradeByUser(teacher);
        //2 调用service获取排序后的grade集合信息
        //3 结果返回
       // List<Grade> gradeList=gradesVo.getGradeList();
        //Collections.sort(gradeList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(request.getContextPath() + "teacher/mtea.jsp");
        modelAndView.addObject("grades", gradeList);
        return modelAndView;
    }

    @RequestMapping("downloadgrade.do")
    public ModelAndView downLoadGrade(HttpServletRequest request, HttpServletResponse response, @RequestParam String fileName, HttpSession session) throws IOException {
        String path = request.getServletContext().getRealPath("upload") + "/" + fileName;
        teacherService.downloadGrade((User)session.getAttribute("user"),path);
        File file = new File(path);
        if (file.exists()) {
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            try {
                response.setContentType("application/octet-stream");
                if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                    fileName = URLEncoder.encode(fileName, "utf-8");
                } else {
                    fileName = URLDecoder.decode(fileName);
                }
                response.setHeader("Content-disposition", "attachment; filename="
                        + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
                os.write(FileUtils.readFileToByteArray(file));
                os.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (os != null) {
                    os.close();
                }
            }
        }
        return null;
    }
}
