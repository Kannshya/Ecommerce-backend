package com.bupt.ecommercebackend.Service;

public interface CartService {
    void addProduct(Long userId, Long productID, Integer quantity);
    void removeProduct(Long userId, Long productID);
}
