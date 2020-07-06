package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import pojo.Teacher;
import utils.MybatisUtils;

import java.util.List;

public class S_T_Test {

    @Test
    public void test_getTeacherById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void test_getStudentAndTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentAndTeacherList = mapper.getStudentAndTeacher();
        for (Student studentAndTeacher : studentAndTeacherList) {
            System.out.println(studentAndTeacher);
        }

        sqlSession.close();
    }

    @Test
    public void test_getStudentAndTeacher2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentAndTeacherList = mapper.getStudentAndTeacher2();
        for (Student studentAndTeacher : studentAndTeacherList) {
            System.out.println(studentAndTeacher);
        }

        sqlSession.close();
    }
}
