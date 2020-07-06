package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IUserDaoTest {

    static Logger logger = Logger.getLogger(IUserDaoTest.class);

    @Test
    public void test_getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test_getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void test_addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        System.out.println(mapper.addUser(new User(4,"d","800")));
        //sqlSession.commit(); // 增删改需要提交事务

        sqlSession.close();
    }

    @Test
    public void test_log4j() {
        //会将logger的日志信息都追加到日志文件中
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
    }

    @Test
    public void test_getUserListLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        HashMap<String, Integer> map = new HashMap<>();

        //map传入两个参数
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userListLimit = mapper.getUserListLimit(map);
        for (User user : userListLimit) {
            System.out.println(user);
        }

        sqlSession.close();

    }
}
