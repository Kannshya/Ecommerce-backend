package com.bupt.ecommercebackend.Service.Impl;

import com.bupt.ecommercebackend.Mapper.UserMapper;
import com.bupt.ecommercebackend.Service.UserService;
import com.bupt.ecommercebackend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;//注入接口

//    @Override
//    public User findById(int id) {
//        return usermapper.findById(id);
//    }

    @Override
    public User findByName(String name) {
        return usermapper.findByName(name);
    }

    @Override
    public void register(String name, String password, String phoneNumber, Integer type, String description){
        usermapper.register(name, password, phoneNumber, type, description);
    }


//    @Override
//    public void update(User user) {
//        usermapper.update(user);
//    }
//
//    @Override
//    public void changePsw(String newPsw, String name) {
//        usermapper.changePsw(newPsw, name);
//    }
}