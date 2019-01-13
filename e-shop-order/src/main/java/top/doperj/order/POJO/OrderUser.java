package top.doperj.order.POJO;

public class OrderUser {
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "OrderUser{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
