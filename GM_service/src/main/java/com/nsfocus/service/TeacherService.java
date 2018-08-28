package com.nsfocus.service;

import com.nsfocus.bean.Grade;
import com.nsfocus.bean.Teacher;
import com.nsfocus.bean.User;
import com.nsfocus.bo.ResultSet;
import com.nsfocus.util.TeacherUtil;
import mapper.GradeMapper;
import mapper.TeacherMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    /*
    * 教师对自己密码进行修改
    * */
    public ResultSet repairPassword(User teacher)
    {
        userMapper.updateUser(teacher);
        ResultSet resultSet=new ResultSet();
        resultSet.setMsg("更改密码成功");
        return resultSet;
    }

    /*
    * 教师对学生成绩的查看和修改
    * */
    public ResultSet queryStudentGrade(User teacher)
    {
        Teacher teacher1=teacherMapper.queryTeacherByUser(teacher);
        List<Grade> gradeList=gradeMapper.queryGradeByTeacher(teacher1);
        ResultSet resultSet=new ResultSet();
        resultSet.setMsg("查询结果成功");
        resultSet.setData(gradeList);
        resultSet.setBool(true);
        return resultSet;
    }
    /*
    * 教师查看所在学生的学生个人信息情况
    * */
    public ResultSet queryStduentMsg(User teacher)
    {
        Teacher teacher1=teacherMapper.queryTeacherByUser(teacher);
        List<Grade> gradeList=gradeMapper.queryGradeByTeacher(teacher1);
        ResultSet resultSet=new ResultSet();
        resultSet.setBool(true);
        resultSet.setData(gradeList);
        resultSet.setMsg("查询结果成功");
        return resultSet;
    }
    /*
    *  功能：根据User teacher信息查询对应所有学生成绩信息并排序
    * */
    public List<Grade> queryAndSortGradeByUser(User teacher)
    {
        Teacher teacher1=teacherMapper.queryTeacherByUser(teacher);
        List<Grade> gradeList=gradeMapper.queryGradeByTeacher(teacher1);
        Collections.sort(gradeList);
        return  gradeList;
    }
    /*
    * 实现学生成绩信息的下载功能
    * */
    public boolean downloadGrade(User teacher,String outPath)
    {
        TeacherUtil teacherUtil=new TeacherUtil();
        Teacher teacher1=teacherMapper.queryTeacherByUser(teacher);
        List<Grade> gradeList=gradeMapper.queryGradeByTeacher(teacher1);
        return teacherUtil.isProduct(gradeList,outPath);
    }
}
