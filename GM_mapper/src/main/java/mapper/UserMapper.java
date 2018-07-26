package mapper;

import com.nsfocus.bean.User;

import java.util.List;

public interface UserMapper {
    //根据不同的权限查询不同的数据
    List<User> queryUser(Integer role);

    //根据id查询不同权限的用户信息
    User getUser(int id);

    //更新用户信息
    void updateUser(User user);

    //插入用户信息
    void insertUser(User user);

    //删除用户信息
    void deleteUser(User user);
}
