package top.doperj.eshop.redis;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import top.doperj.eshop.redis.pojo.User;

public class JSONTests {
    User user;

    @Before
    public void initUser() {
        user = new User();
        user.setUeserName("root");
        user.setPassword("passwd");
        user.setUserId(1024);
    }

    @Test
    public void jsonTester() throws Exception {
        String s = JSON.toJSONString(user);
        System.out.println(s);
        User user = JSON.parseObject(s, User.class);
        System.out.println(user);
    }
}
