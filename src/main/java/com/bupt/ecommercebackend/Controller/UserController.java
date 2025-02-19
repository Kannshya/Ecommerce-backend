package com.bupt.ecommercebackend.Controller;

import com.bupt.ecommercebackend.Service.MerchantService;
import com.bupt.ecommercebackend.Service.UserService;
import com.bupt.ecommercebackend.Utils.JwtUtil;
import com.bupt.ecommercebackend.Utils.UserContext;
import com.bupt.ecommercebackend.pojo.Result;
import com.bupt.ecommercebackend.pojo.User;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MerchantService merchantService;

    //POST是浏览器给我数据
    @PostMapping("/register")
    public Result register(String name,
                           //校验密码格式，防止前端不干活
                           @Pattern(regexp = "^(?=(.*\\d.*){2,})(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,}$",
                                   message = "密码至少6位，必须包含两个数字，并且不能全为大写或小写字母") String password,
                           String phoneNumber,
//                         String verificationCode,
                           int type,
                           @RequestParam(required = false)String description,
                           @RequestParam(required = false)String partnerId,
                           @RequestParam(required = false)String appId) {

        //判断类型是否为商家，如果是，则必须提供partnerId和appId

        //看看用户名重复不重复
        User u = userService.findByName(name);

        if (u != null) {
            //占用的话报错
            System.out.println("——————————————————————\n检测到用户名已存在\n——————————————————————");

            Result result = Result.error("用户名已存在，请重新输入");
            System.out.println("code: " + result.getCode());
            System.out.println("message: " + result.getMessage());
            System.out.println("data: " + result.getData()); // 打印 Result 对象

            return Result.error("用户名已存在，请重新输入");
        }else {


            // 如果是商家，则必须提供 partnerId 和 appId
            if (type == 1) {
                System.out.println("——————————————————————\n校验商家信息\n——————————————————————");
                if (partnerId == null || partnerId.isEmpty()) {
                    return Result.error("注册商家必须提供 partnerId（商户号）");
                }
                if (appId == null || appId.isEmpty()) {
                    return Result.error("注册商家必须提供 appId（应用ID）");
                }
                System.out.println("——————————————————————\n注册商家信息\n——————————————————————");
                userService.register(name, password, phoneNumber, type, description);
                User user = userService.findByName(name);
                Long id = user.getId();
                merchantService.register(id, partnerId, appId, 0);
                System.out.println(user);
                return Result.success();
            }

            //后期添加核对验证码逻辑
//            if(verificationCode == null || verificationCode ！= ？？？) {
//                return Result.error("验证码错误，请重试");
//            }

            //普通用户注册
            System.out.println("——————————————————————\n注册用户信息\n——————————————————————");
//            System.out.println("name:" + name + "\npassword:" + password + "\nphoneNumber:" + phoneNumber +
//                    "\ntype:" + type + "\ndescription:" + description + "\npartnerId:" + partnerId + "\nappId:" + appId);
            userService.register(name, password, phoneNumber, type, description);
            User user = userService.findByName(name);
            System.out.println(user);
            return Result.success();
        }
    }

    @PostMapping("/login")
    public Result login(String username,
                        @Pattern(regexp = "^(?=(.*\\d.*){2,})(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,}$",
                                message = "密码格式错误，请重新输入") String password){
        User u = userService.findByName(username);
        if (u != null) {
            if(password.equals(u.getPassword())){
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", u.getId());
                claims.put("username", u.getName());
                String token = JwtUtil.genToken(claims);
                return Result.success(token);
            }
            return Result.error("用户名或密码错误，请重新输入");
        }
        return Result.error("用户不存在，请重新输入");
    }

    @GetMapping("/userinfo")
    public Result<User> userinfo(@RequestHeader(name = "Authorization") String token){
        User u = UserContext.getUserFromToken(token);
        return Result.success(u);
    }

    @PutMapping("/update")
    public Result update(@RequestHeader(name = "Authorization") String token, @RequestBody User user){

        User u = UserContext.getUserFromToken(token);
        user.setId(u.getId());

        //新用户名不能重复
        User b = userService.findByName(user.getName());
        if (b != null) {
            return Result.error("用户名已存在或与之前相同，请重新输入");
        }

        System.out.println("——————————————————————\n接收到的用户信息\n——————————————————————");
        System.out.println(user);
        userService.update(user);
        return Result.success();
    }

}
