package top.doperj.user;

import top.doperj.user.domain.User;
import top.doperj.user.service.AddressService;
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
@MapperScan("top.doperj.user.dao")
public class EShopUserApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @Test
    public void findAddressByUsername() {
        System.out.println(addressService.findAddressesByUserName("doperj"));
    }

    //@Test
    public void addAddress() throws Exception {
        addressService.addAddressByInfo(
                "doperj",
                515300,
                "广东省",
                "揭阳市",
                "普宁县",
                "流沙东街道",
                false
        );
/*        addressService.addAddressByInfo(
                "doperj",
                510641,
                "广东省",
                "广州市",
                "天河区",
                "华南理工大学北区",
                true
        );*/
    }

    @Test
    public void findAllAddresses() throws Exception {
        System.out.println(addressService.findAllAddresses());
    }

	@Test
	public void showUsers() {
	    List<User> userList = userService.findAllUser();
	    System.out.println("All the users found: " + userList);
	}

	@Test
    public void deleteUser() {
        List<User> userList = userService.findAllUser();
        System.out.println("All the users found: " + userList);
	    User user = userService.findUserByName("doperj");
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
