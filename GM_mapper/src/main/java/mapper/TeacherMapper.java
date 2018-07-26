package mapper;

import com.nsfocus.bean.Teacher;
import com.nsfocus.bean.User;

public interface TeacherMapper {
   // public void updateTeacher( User teacher);
    public void deleteTeacher(User teacher);
    public void insertTeacher(User teacher);
}
