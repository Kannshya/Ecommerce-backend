package com.bupt.ecommercebackend.Utils;

import com.bupt.ecommercebackend.Service.UserService;
import com.bupt.ecommercebackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserContext {

    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        UserContext.userService = userService;
    }

    /**
     * 从 JWT Token 中解析用户信息
     *
     * @param token JWT Token
     * @return 用户对象
     */
    public static User getUserFromToken(String token) {
        // 解析 Token
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");

        // 查询用户信息
        return userService.findByName(username);
    }
}