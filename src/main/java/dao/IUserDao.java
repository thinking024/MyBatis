package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {

    //@Select("select * from user")
    List<User> getUserList();

    //@Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    //@Insert("insert into user (id,name,password) values (#{id},#{name},#{password})") // 引用类型参数无需使用@Param
    int addUser(User user);

    List<User> getUserListLimit(Map<String,Integer> map);
}
