package top.doperj.eshop.redis.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.doperj.eshop.redis.pojo.User;

@Service
public class UserService {

    @Cacheable(value = "user", key = "'user_'+#userName")
    public User getUser(String userName) {
        System.out.println("go get " + userName);
        User user = new User();
        user.setUserId(1024);
        user.setUeserName(userName);
        user.setPassword("passwd");
        return user;
    }
}
