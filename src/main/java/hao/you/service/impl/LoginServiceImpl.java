package hao.you.service.impl;

import hao.you.dao.LoginDao;
import hao.you.domain.Login;
import hao.you.domain.MessageRecordDo;
import hao.you.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public int addLoginInfo(Login login) {
        return loginDao.addLoginInfo(login);
    }

    @Override
    public Login getLoginByName(String user_name) {
        return loginDao.getLoginByName(user_name);
    }

    @Override
    public int addMessageRecord(MessageRecordDo messageRecordDo) {
        return loginDao.addMessageRecord(messageRecordDo);
    }
}
