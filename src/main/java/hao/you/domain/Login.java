package hao.you.domain;

import java.util.Date;

public class Login {
    private Integer login_id;
    private String user_id;
    private String user_name;
    private Integer login_status;
    private Date login_time;

    public Login() {
    }

    public Login(Integer login_id, String user_id, String user_name, Integer login_status, Date login_time) {
        this.login_id = login_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.login_status = login_status;
        this.login_time = login_time;
    }

    public static LoginInfoBuilder builder(){
        return new LoginInfoBuilder();
    }

    public static class LoginInfoBuilder{
        private Integer login_id;
        private String user_id;
        private String user_name;
        private Integer login_status;
        private Date login_time;

        public LoginInfoBuilder id(Integer login_id) {
            this.login_id = login_id;
            return this;
        }

        public LoginInfoBuilder userId(String user_id) {
            this.user_id = user_id;
            return this;
        }

        public LoginInfoBuilder userName(String user_name) {
            this.user_name = user_name;
            return this;
        }

        public LoginInfoBuilder status(Integer login_status) {
            this.login_status = login_status;
            return this;
        }

        public LoginInfoBuilder createTime(Date login_time) {
            this.login_time = login_time;
            return this;
        }

        public Login build(){
            return new Login(login_id, user_id, user_name, login_status, login_time);
        }
    }

    public Integer getId() {
        return login_id;
    }

    public void setId(Integer login_id) {
        this.login_id = login_id;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public Integer getStatus() {
        return login_status;
    }

    public void setStatus(Integer login_status) {
        this.login_status = login_status;
    }

    public Date getCreateTime() {
        return login_time;
    }

    public void setCreateTime(Date login_time) {
        this.login_time = login_time;
    }

    @Override
    public String toString() {
        return "Login{" +
                "login_id=" + login_id +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", login_status=" + login_status +
                ", login_time=" + login_time +
                '}';
    }
}
