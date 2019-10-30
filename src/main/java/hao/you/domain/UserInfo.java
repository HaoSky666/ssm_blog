package hao.you.domain;

public class UserInfo {
    private String userinfo_id;
    private String userinfo_nickname;
    private String userinfo_icon;
    private String userinfo_profession;
    private String userinfo_description;

    public String getUserinfo_id() {
        return userinfo_id;
    }

    public void setUserinfo_id(String userinfo_id) {
        this.userinfo_id = userinfo_id;
    }

    public String getUserinfo_nickname() {
        return userinfo_nickname;
    }

    public void setUserinfo_nickname(String userinfo_nickname) {
        this.userinfo_nickname = userinfo_nickname;
    }

    public String getUserinfo_icon() {
        return userinfo_icon;
    }

    public void setUserinfo_icon(String userinfo_icon) {
        this.userinfo_icon = userinfo_icon;
    }

    public String getUserinfo_profession() {
        return userinfo_profession;
    }

    public void setUserinfo_profession(String userinfo_profession) {
        this.userinfo_profession = userinfo_profession;
    }

    public String getUserinfo_description() {
        return userinfo_description;
    }

    public void setUserinfo_description(String userinfo_description) {
        this.userinfo_description = userinfo_description;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userinfo_id='" + userinfo_id + '\'' +
                ", userinfo_nickname='" + userinfo_nickname + '\'' +
                ", userinfo_icon='" + userinfo_icon + '\'' +
                ", userinfo_profession='" + userinfo_profession + '\'' +
                ", userinfo_description='" + userinfo_description + '\'' +
                '}';
    }
}
