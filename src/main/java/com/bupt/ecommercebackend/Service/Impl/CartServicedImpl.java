package com.bupt.ecommercebackend.Service.Impl;

import com.bupt.ecommercebackend.Mapper.CartMapper;
import com.bupt.ecommercebackend.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServicedImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    public void addProduct(Long userId, Long productID, Integer quantity){
        cartMapper.addProduct(userId, productID, quantity);
    }
}
