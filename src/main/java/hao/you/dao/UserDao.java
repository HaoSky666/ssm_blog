package hao.you.dao;

import hao.you.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Insert("insert into user(user_id,user_name,user_password,user_record_date) values(replace(uuid(),'-',''), #{user_name}, #{user_password},#{user_record_date})")
    public int addUser(User user);

    @Delete("delete from user where user_id = #{user_id}")
    public int deleteUserById(int id);

    @Update("update user set user_name = #{user_name}, user_password = #{user_password},user_record_date = #{user_record_date} where user_id = #{user_id}")
    public int update(User user);

    @Select("select * from user where user_id = #{user_id}")
    public User getUserById(String id);

    @Select("select * from user where user_name = #{user_name}")
    public User getUserByName(String name);

    @Select("select * from user order by user_record_date desc")
    public List<User> getAllUser();
}
