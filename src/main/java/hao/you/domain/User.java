package hao.you.domain;

import java.util.Date;

public class User {
    private String user_id;
    private String user_name;
    private String user_password;
    private String user_record_date;

    private Date loginDate;
    private Date logoutDate;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_record_date() {
        return user_record_date;
    }

    public void setUser_record_date(String user_record_date) {
        this.user_record_date = user_record_date;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_record_date='" + user_record_date + '\'' +
                ", loginDate=" + loginDate +
                ", logoutDate=" + logoutDate +
                '}';
    }
}
