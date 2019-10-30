package hao.you.domain;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *在线用户仓库，存储在线用户
 */
@Component
public class ParticipantRepository {
    private Map<String, User> activeSessions = new ConcurrentHashMap<String, User>(); //在线用户map，键：用户名称，值：用户对象
    public Map<String, User> getActiveSessions() {
        return activeSessions;
    }

    public void setActiveSessions(Map<String, User> activeSessions) {
        this.activeSessions = activeSessions;
    }

    //添加在线人数
    public void add(String name, User user){
        activeSessions.put(name, user);
    }

    //删除在线人数
    public User remove(String name){
        return activeSessions.remove(name);
    }

    //在线人数是否已在集合中
    public boolean containsUserName(String name){
        return activeSessions.containsKey(name);
    }
}
