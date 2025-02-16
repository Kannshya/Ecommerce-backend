package com.bupt.ecommercebackend.Controller;

import com.bupt.ecommercebackend.Service.UserService;
import com.bupt.ecommercebackend.pojo.Result;
import com.bupt.ecommercebackend.pojo.User;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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
                if (partnerId == null || partnerId.isEmpty()) {
                    return Result.error("注册商家必须提供 partnerId（商户号）");
                }
                if (appId == null || appId.isEmpty()) {
                    return Result.error("注册商家必须提供 appId（应用ID）");
                }
            }

            //后期添加核对验证码逻辑
//            if(verificationCode == null || verificationCode ！= ？？？) {
//                return Result.error("验证码错误，请重试");
//            }

            //没占用就注册
            System.out.println("——————————————————————\n注册用户\n——————————————————————");
            System.out.println("name:" + name + "\npassword:" + password + "\nphoneNumber:" + phoneNumber +
                    "\ntype:" + type + "\ndescription:" + description + "\npartnerId:" + partnerId + "\nappId:" + appId);
            userService.register(name, password, phoneNumber, type, description);
//            后期添加商家注册逻辑
//            merchantService.register(partnerId, appId, status);
            return Result.success();
        }
    }

}
