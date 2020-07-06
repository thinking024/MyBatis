package dao;

import pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudentAndTeacher();
    List<Student> getStudentAndTeacher2();
}
