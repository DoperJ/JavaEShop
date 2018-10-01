package top.doperj.user.service;

import top.doperj.user.dao.LoginTicketMapper;
import top.doperj.user.dao.UserMapper;
import top.doperj.user.domain.LoginTicket;
import top.doperj.user.domain.User;
import top.doperj.user.util.EShopUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDAO;

    @Autowired
    private LoginTicketMapper loginTicketDAO;

    @Override
    public int addUser(User user) {
        return userDAO.insertSelective(user);
    }

    @Override
    public List<User> findAllUser() {
        return userDAO.selectAllUser();
    }

    @Override
    public User findUserById(int userId) {
        return userDAO.selectByPrimaryKey(userId);
    }

    @Override
    public User findUserByName(String userName) {
        return userDAO.selectByName(userName);
    }

    @Override
    public User findUserByEMail(String eMail) {
        return userDAO.selectByEMail(eMail);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteByPrimaryKey(user.getUserId());
    }

    @Override
    public Map<String,String> register(String userName, String eMail, String password) {
        Map<String,String> map = new HashMap<>();
        Random random = new Random();
        if (StringUtils.isBlank(userName)){
            map.put("error","用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(eMail)){
            map.put("error","邮箱不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)){
            map.put("error","密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(userName);
        if (user != null){
            map.put("error","用户名已经被占用");
            return map;
        }

        user = userDAO.selectByEMail(eMail);
        if (user != null){
            map.put("error","邮箱已经被占用");
            return map;
        }

        user = new User();
        user.setUserName(userName);
        user.seteMail(eMail);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeadUrl(String.format("https://images.nowcoder.com/head/%dm.png",random.nextInt(1000)));
        user.setPassword(EShopUtil.MD5(password+user.getSalt()));
        user.setRole("ROLE_USER");
        userDAO.insert(user);
        System.out.println(user);

        user = userDAO.selectByName(userName);
        String ticket = addLoginTicket(user.getUserId());
        map.put("ticket",ticket);

        return map;
    }

    @Override
    public Map<String,String> loginByEMail(String eMail, String password) {
        Map<String,String> map = new HashMap<>();
        if (StringUtils.isBlank(eMail)){
            map.put("error","邮箱不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)){
            map.put("error","密码不能为空");
            return map;
        }

        User user = userDAO.selectByEMail(eMail);
        if (user == null){
            map.put("error","邮箱不存在");
            return map;
        }

        if (!EShopUtil.MD5(password + user.getSalt()).equals(user.getPassword())){
            map.put("error","密码错误");
            return map;
        }

        String ticket = addLoginTicket(user.getUserId());
        map.put("ticket",ticket);

        return map;
    }

    @Override
    public Map<String,String> loginByName(String username, String password) {
        Map<String,String> map = new HashMap<>();
        if (StringUtils.isBlank(username)){
            map.put("error","用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)){
            map.put("error","密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);
        if (user == null){
            map.put("error","用户名不存在");
            return map;
        }

        if (!EShopUtil.MD5(password + user.getSalt()).equals(user.getPassword())){
            map.put("error","密码错误");
            return map;
        }

        String ticket = addLoginTicket(user.getUserId());
        map.put("ticket",ticket);

        return map;
    }

    @Override
    public String addLoginTicket(int userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*30);
        loginTicket.setExpired(date);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));

        System.out.println(loginTicket);
        loginTicketDAO.insertLoginTicket(loginTicket);

        return loginTicket.getTicket();
    }
}
