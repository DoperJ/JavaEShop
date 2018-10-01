package top.doperj.user;

import top.doperj.user.domain.User;
import top.doperj.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.doperj.user.dao")
public class EShopUserApplicationTests {

    @Autowired
    UserService userService;

	@Test
	public void showUsers() {
	    List<User> userList = userService.findAllUser();
	    System.out.println("All the users found: " + userList);
	}

	@Test
    public void deleteUser() {
        List<User> userList = userService.findAllUser();
        System.out.println("All the users found: " + userList);
	    User user = userService.findUserByName("江城子");
	    userService.deleteUser(user);
	    userList = userService.findAllUser();
        System.out.println("All the users found: " + userList);
    }

	@Test
    public void registerUser() {
        List<User> userList = userService.findAllUser();
        System.out.println("All the users found: " + userList);
	    userService.register("DoperJ", "doperjzq@gmail.com", "zeroquest");
	    userList = userService.findAllUser();
        System.out.println("All the users found: " + userList);
    }

    @Test
    public void addLoginTicket() {
	    User user = userService.findUserByName("DoperJ");
	    userService.addLoginTicket(user.getUserId());
    }
}
