package top.doperj.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.doperj.user.pojo.CartItem;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    @GetMapping("")
    public List<CartItem> getCart(HttpSession session) {
        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cart");
        return cartItemList;
    }

    @GetMapping("/addItem")
    @ResponseBody
    public void addItem(@RequestParam("skuId") Integer skuId, HttpSession session) {
        List<CartItem> cartItemList = (List<CartItem>) session.getAttribute("cart");
        if (cartItemList == null) {
            cartItemList = new LinkedList<CartItem>();
            System.out.println("new cart!");
        }
        Iterator<CartItem> cartItemIterator = cartItemList.iterator();
        boolean isSkuAdded = false;
        while (cartItemIterator.hasNext()) {
            CartItem cartItem = cartItemIterator.next();
            if (cartItem.getSkuId() == skuId) {
                cartItem.setSkuNum(cartItem.getSkuNum() + 1);
                isSkuAdded = true;
            }
        }
        if (!isSkuAdded) {
            cartItemList.add(new CartItem(skuId, 1));
        }
        session.setAttribute("cart", cartItemList);
    }
}
