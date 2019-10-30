package hao.you.service;

import hao.you.domain.UserInfo;

import java.util.List;

public interface UserInfoService {
    public int addUserInfo(UserInfo userInfo);
    public int deleteUserInfoById(int id);
    public int update(UserInfo userInfo);
    public UserInfo getUserInfoById(String id);
    public List<UserInfo> getAllUserInfo();
}
