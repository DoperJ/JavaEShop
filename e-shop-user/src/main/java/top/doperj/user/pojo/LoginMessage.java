package top.doperj.user.pojo;

public class LoginMessage {
    private boolean succeed;
    private String message;

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "succeed=" + succeed +
                ", message='" + message + '\'' +
                '}';
    }
}
