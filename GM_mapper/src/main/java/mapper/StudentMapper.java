package mapper;

import com.nsfocus.bean.Student;
import com.nsfocus.bean.User;

public interface StudentMapper {
    //public void updatePassword(Student student);
   // public void updateNote(Student student);
    public void deleteStudent(User student);
    public void insertStudent(User student);
}
