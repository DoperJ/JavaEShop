package top.doperj.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @GetMapping("/shop.html")
    public String shoppingPage(@RequestParam("category") String category, Model model) {
        model.addAttribute("category", category);
        return "/templates/essence/shop.html";
    }
}
