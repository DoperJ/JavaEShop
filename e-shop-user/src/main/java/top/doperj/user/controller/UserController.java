package top.doperj.user.controller;

import top.doperj.user.domain.User;
import top.doperj.user.service.UserService;
import top.doperj.user.util.EShopUtil;
import org.json.JSONObject;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(HttpServletRequest request, HttpSession session) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                System.out.println(cookie.getValue());
            }
        }
        System.out.println("home mapping...");
        System.out.println(session.getId());
        return "home";
    }

    @GetMapping("/api/login_user")
    @ResponseBody
    public String login_user(HttpServletRequest request, HttpSession session) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return "请登录";
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                if (cookie.getValue().equals(session.getId())) {
                    String username = (String) session.getAttribute("username");
                    String password = (String) session.getAttribute("password");
                    User user = userService.findUserByName(username);
                    if (username != null && user != null && EShopUtil.MD5(password + user.getSalt()).equals(user.getPassword())) {
                        System.out.println(username);
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("username", username);
                        jsonObject.put("head_url", user.getHeadUrl());
                        System.out.println(jsonObject.toString());
                        return jsonObject.toString();
                    }
                }
                System.out.println(cookie.getValue());
            }
        }
        System.out.println("login user looking for...");
        System.out.println(session.getId());
        return "请登录";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/api/login")
    @ResponseBody
    public String loginPost(@RequestParam("email") String eMail, @RequestParam("password") String password, HttpSession session) {
        System.out.println(eMail + ": " + password);
        Map<String, String> map = userService.loginByEMail(eMail, password);
        if (map.containsKey("error")) {
            return map.get("error");
        }
        User user = userService.findUserByEMail(eMail);
        session.setAttribute("username", user.getUserName());
        session.setAttribute("password", password);
        return "登录成功";
    }

    @GetMapping("/api/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("password");
        return null;
    }

    @PostMapping("/api/register")
    @ResponseBody
    public String verify(String username, @RequestParam("email") String eMail, String password, HttpSession session) {
        session.setAttribute("username", username);
        Map<String, String> map = userService.register(username, eMail, password);
        if (map.containsKey("error")) {
            return map.get("error");
        }
        User user = userService.findUserByEMail(eMail);
        session.setAttribute("username", user.getUserName());
        session.setAttribute("password", password);
        return "用户注册成功";
    }

    @GetMapping(value = "/api/users", produces = "application/json")
    @ResponseBody
    public List<User> getUser() {
        System.out.println("mapping users");
        System.out.println(userService.findAllUser());
        return userService.findAllUser();
    }
}
