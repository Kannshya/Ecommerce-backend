package com.bupt.ecommercebackend.Controller;

import com.bupt.ecommercebackend.Mapper.AddressMapper;
import com.bupt.ecommercebackend.Service.AddressService;
import com.bupt.ecommercebackend.Service.UserService;
import com.bupt.ecommercebackend.Utils.JwtUtil;
import com.bupt.ecommercebackend.Utils.UserContext;
import com.bupt.ecommercebackend.pojo.Address;
import com.bupt.ecommercebackend.pojo.Result;
import com.bupt.ecommercebackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressMapper addressMapper;

    @PostMapping("/add")
    public Result addAddress(@RequestHeader(name = "Authorization") String token,
                             @RequestBody Address address) {
        User u = UserContext.getUserFromToken(token);
        address.setUserId(u.getId());
        System.out.println("接收到的地址：" + address);

        return addressService.addAddress(address);
    }

    @GetMapping("/list")
    public Result listAddress(@RequestHeader(name = "Authorization") String token) {
        User u = UserContext.getUserFromToken(token);

        List<Address> a = addressMapper.list(u.getId());
        return Result.success(a);
    }
}
