package top.doperj.user.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.doperj.user.domain.User;
import top.doperj.user.service.UserService;
import top.doperj.user.util.EShopUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    UserService userService;

    @GetMapping("/shop")
    public String shoppingPage(@RequestParam("category") String category, Map<String, Object> map) {
    //public String shoppingPage() {
        map.put("category", category);
        return "shop";
    }

    @GetMapping("/search")
    public String shoppingPage() {
        //public String shoppingPage() {
        return "search";
    }

    @GetMapping("/checkout")
    public String checkoutPage(HttpSession httpSession, Map<String, Object> map) {
        //public String shoppingPage() {
        String username = (String) httpSession.getAttribute("username");
        System.out.println("get username: " + username);
        String password = (String) httpSession.getAttribute("password");
        User user = userService.findUserByName(username);
        if (username != null && user != null && EShopUtil.MD5(password + user.getSalt()).equals(user.getPassword())) {
            System.out.println(username);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", username);
            jsonObject.put("head_url", user.getHeadUrl());
            System.out.println("user: " + jsonObject.toString());
            map.put("username", username);
            return "checkout";
        } else {
            httpSession.setAttribute("last-access", "checkout");
            System.out.println("last-access is " + httpSession.getAttribute("last-access"));
            return "login";
        }
    }

    @GetMapping("/orderInfo")
    public String orderInfoPage(HttpSession httpSession, Map<String, Object> map) {
        String username = (String) httpSession.getAttribute("username");
        System.out.println("get username in order info: " + username);
        String password = (String) httpSession.getAttribute("password");
        User user = userService.findUserByName(username);
        if (username != null && user != null && EShopUtil.MD5(password + user.getSalt()).equals(user.getPassword())) {
            System.out.println(username);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", username);
            jsonObject.put("head_url", user.getHeadUrl());
            System.out.println("user: " + jsonObject.toString());
            map.put("username", username);
            return "orderInfo";
        } else {
            httpSession.setAttribute("last-access", "orderInfo");
            System.out.println("last-access is " + httpSession.getAttribute("last-access"));
            return "login";
        }
    }
}
