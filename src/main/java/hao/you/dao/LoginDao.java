package hao.you.dao;

import hao.you.domain.Login;
import hao.you.domain.MessageRecordDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    @Insert("insert into login(user_id, user_name, login_status, login_time) values(#{userId}, #{userName}, #{status}, #{createTime})")
    public int addLoginInfo(Login login);

    @Select("select * from login where user_name = #{user_name}")
    public Login getLoginByName(String user_name);

    @Insert("insert into message_record(user_id, user_name, message_type, message_content,message_time) values(#{userId}, #{userName}, #{messageType}, #{content}, #{createTime})")
    public int addMessageRecord(MessageRecordDo messageRecordDo);
}
