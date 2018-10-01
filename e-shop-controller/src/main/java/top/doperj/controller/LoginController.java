package top.doperj.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.doperj.service.Service.User.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Reference(version = "1.0.0")
    private UserService userService;
}
