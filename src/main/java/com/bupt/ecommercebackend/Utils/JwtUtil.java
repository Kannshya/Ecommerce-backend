package com.bupt.ecommercebackend.Utils;

//网上抄的
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bupt.ecommercebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    private static final String KEY = "itheima";

    @Autowired
    private UserService userService;

    // 接收业务数据，生成token并返回
    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256(KEY));
    }

    // 接收token，校验token，并返回数据
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
