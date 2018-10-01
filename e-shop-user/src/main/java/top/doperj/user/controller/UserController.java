package top.doperj.user.controller;

import top.doperj.user.domain.User;
import top.doperj.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = "application/json")
    public List<User> getUser() {
        System.out.println(userService.findAllUser());
        return userService.findAllUser();
    }
}
