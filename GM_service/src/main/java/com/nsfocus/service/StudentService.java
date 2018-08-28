package com.nsfocus.service;

import com.nsfocus.bean.Grade;
import com.nsfocus.bean.Student;
import com.nsfocus.bean.Teacher;
import com.nsfocus.bean.User;
import com.nsfocus.bo.ResultSet;
import mapper.GradeMapper;
import mapper.StudentMapper;
import mapper.TeacherMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    /*
    * 功能：实现学生对自己密码的更改功能
    * */
    public ResultSet repairPassword(User student) {
        userMapper.updateUser(student);
        ResultSet resultSet = new ResultSet();
        return resultSet;
    }

    /*
    * 功能:对个人备注信息的修改
    * */
    public void repairNote(Student student) {
        studentMapper.updateStudent(student);
    }

    /*
    *
    * */
    public List<Grade> queryGrade(Student student) {
        List<Grade> grade = gradeMapper.queryGrade(student);
        for (Grade g : grade) {
            Teacher teacher = teacherMapper.queryTeacher(g.getTeacher().getId());
            g.getTeacher().setTeachername(teacher.getTeachername());
        }
        return grade;
    }
}
