package com.bupt.ecommercebackend.Service;

import com.bupt.ecommercebackend.pojo.Cart;

import java.util.List;

public interface CartService {
    void addProduct(Long userId, Long productID, Integer quantity);
    List<Cart> listProduct(Long userID);
//    void removeProduct(Long userId, Long productID);
}
