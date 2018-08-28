package mapper;

import com.nsfocus.bean.Grade;
import com.nsfocus.bean.Student;
import com.nsfocus.bean.Teacher;
import com.nsfocus.bean.User;

import java.util.List;

public interface GradeMapper {
    public List<Grade> queryGrade(Student student);
    public List<Grade> queryGradeByTeacher(Teacher teacher);
    public void updateGradeByGrade(Grade grade);
}
