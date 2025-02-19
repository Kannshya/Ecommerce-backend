package com.bupt.ecommercebackend.Controller;

import com.bupt.ecommercebackend.Service.CartService;
import com.bupt.ecommercebackend.Service.UserService;
import com.bupt.ecommercebackend.Utils.JwtUtil;
import com.bupt.ecommercebackend.pojo.Result;
import com.bupt.ecommercebackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    public UserService userService;
    @Autowired
    public CartService cartService;

    @PostMapping("/add")
    public Result addProduct(@RequestHeader(name = "Authorization") String token,
                             @RequestParam("productId") Long productId,
                             @RequestParam("quantity") Integer quantity) {
        //从token里解析用户名，从而获取用户id
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");
        User u = userService.findByName(username);

        if(u.getType() != 0){
            return Result.error("只有消费者用户可以添加商品");
        }

        cartService.addProduct(u.getId(), productId, quantity);
        return Result.success();
    }
}
