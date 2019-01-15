package top.doperj.user.pojo;

public class AddressUser {
    private String userName;
    private Integer orderId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "AddressUser{" +
                "userName='" + userName + '\'' +
                ", orderId=" + orderId +
                '}';
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
