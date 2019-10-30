package hao.you.service;

import hao.you.domain.Login;
import hao.you.domain.MessageRecordDo;

public interface LoginService {
    public int addLoginInfo(Login login);

    public Login getLoginByName(String user_name);

    public int addMessageRecord(MessageRecordDo messageRecordDo);
}
