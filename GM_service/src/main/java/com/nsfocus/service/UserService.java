package com.nsfocus.service;

import com.nsfocus.bean.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /*
    * 根据各自的权限不同实现不同权限的用户登录
    * */
    public boolean isLogin(String username, String password, int role,HttpSession session)
    {
        List<User> userList=userMapper.queryUser(role);
        for(User user:userList)
        {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password))
            {
                session.setAttribute("user",user);
                return true;
            }
        }
        return false;
    }
}
