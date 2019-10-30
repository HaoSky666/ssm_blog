package hao.you.dao;

import hao.you.domain.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {
    @Insert("insert into userinfo(userinfo_id,userinfo_nickname,userinfo_icon,userinfo_profession,userinfo_description) values(replace(uuid(),'-',''), #{userinfo_nickname}, #{userinfo_icon},#{userinfo_profession},#{userinfo_description}")
    public int addUserInfo(UserInfo userInfo);

    @Delete("delete from userinfo where userinfo_id = #{userinfo_id}")
    public int deleteUserInfoById(int id);

    @Update("update userinfo set userinfo_nickname = #{userinfo_nickname}, userinfo_icon = #{userinfo_icon},userinfo_profession = #{userinfo_profession},userinfo_description = #{userinfo_description} where userinfo_id = #{userinfo_id}")
    public int update(UserInfo userInfo);

    @Select("select * from userinfo where userinfo_id = #{userinfo_id}")
    public UserInfo getUserInfoById(String id);

    @Select("select * from userinfo")
    public List<UserInfo> getAllUserInfo();
}
