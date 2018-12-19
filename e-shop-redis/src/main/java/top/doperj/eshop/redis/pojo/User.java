package top.doperj.eshop.redis.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int userId;
    private String ueserName;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUeserName() {
        return ueserName;
    }

    public void setUeserName(String ueserName) {
        this.ueserName = ueserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", ueserName='" + ueserName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
