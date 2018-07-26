package com.nsfocus.service;

import com.nsfocus.bean.Teacher;
import com.nsfocus.bean.User;
import mapper.StudentMapper;
import mapper.TeacherMapper;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;

    /*
    * 功能：查询所有的老师信息
    * */
    public List<User> queryTeacher()
    {
       List<User> teacherList=userMapper.queryUser(1);
       return teacherList;
    }

    /*
    * 功能：查询所有的学生信息
    * */
    public List<User> queryStudent()
    {
        List<User> studentList=userMapper.queryUser(2);
        return studentList;
    }

    /*
    * 功能：修改老师信息(密码)
    * */

    public User queryTeacher(int id)
    {
        return userMapper.getUser(id);
    }
    public void updateTeacher(User teacher)
    {
        //1 根据老师id查询老师的基本信息
        //2 修改老师基本信息并构造老师对象
        //3 更新user表中老师信息
        userMapper.updateUser(teacher);
    }
    /*
    * 功能：修改学生信息
    * */
    public void updateStudent(User student){
        userMapper.updateUser(student);
    }

    /*
   * 功能：插入老师信息
   * */
    public void insertTeacher(User teacher)
    {
       userMapper.insertUser(teacher);
       teacherMapper.insertTeacher(teacher);
    }

    /*
   * 功能：插入学生信息
   * */
    public void insertStudent(User student)
    {
       userMapper.insertUser(student);
       studentMapper.insertStudent(student);
    }

    /*
  * 功能：删除老师信息
  * */
    public void deleteTeacher(User teacher)
    {
        //1 删除user表中信息
        userMapper.deleteUser(teacher);

        //2 删除teacher表中信息
        teacherMapper.deleteTeacher(teacher);


    }

    /*
  * 功能：删除学生信息
  * */
    public void deleteStudent(User student)
    {
        //1 删除user表中信息
        userMapper.deleteUser(student);
        //2 删除teacher表中信息
        studentMapper.deleteStudent(student);
    }
}
