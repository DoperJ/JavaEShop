package top.doperj.user.service;


import top.doperj.user.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int addUser(User user);

    List<User> findAllUser();

    User findUserById(int userId);

    User findUserByName(String name);

    User findUserByEMail(String eMail);

    Map<String,String> register(String userName, String eMail, String password);

    Map<String,String> loginByEMail(String eMail, String password);

    Map<String,String> loginByName(String username, String password);

    void deleteUser(User user);

    String addLoginTicket(int userId);
}
