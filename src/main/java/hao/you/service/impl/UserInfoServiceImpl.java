package hao.you.service.impl;

import hao.you.dao.UserInfoDao;
import hao.you.domain.UserInfo;
import hao.you.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public int deleteUserInfoById(int id) {
        return userInfoDao.deleteUserInfoById(id);
    }

    @Override
    public int update(UserInfo userInfo) {
        return userInfoDao.update(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return userInfoDao.getUserInfoById(id);
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoDao.getAllUserInfo();
    }
}
