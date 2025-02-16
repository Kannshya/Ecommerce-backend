package com.bupt.ecommercebackend.Service;

import com.bupt.ecommercebackend.pojo.User;

public interface UserService {
//    User findById(int id);
    User findByName(String name);
    void register(String name, String password, String phoneNumber, Integer type, String description);
    //    void update(User user);
//    void changePsw(String newPsw, String name);
}
