package com.bupt.ecommercebackend.Service.Impl;

import com.bupt.ecommercebackend.Mapper.CartMapper;
import com.bupt.ecommercebackend.Service.CartService;
import com.bupt.ecommercebackend.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartServicedImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addProduct(Long userId, Long productID, Integer quantity){
        cartMapper.addProduct(userId, productID, quantity);
    }

    @Override
    public List<Cart> listProduct(Long userID){
        List<Cart> carlist = cartMapper.listProduct(userID);
        List<Cart> l =  mergeDuplicateProducts(carlist);
        return l;
    }
    /**
     * 合并购物车中重复的商品
     */
    private List<Cart> mergeDuplicateProducts(List<Cart> cartList) {
        // 使用 Map 来合并重复商品
        Map<Long, Cart> productMap = new HashMap<>();

        for (Cart cart : cartList) {
            Long productId = cart.getProductId();
            if (productMap.containsKey(productId)) {
                // 如果商品已存在，增加数量
                Cart existingCart = productMap.get(productId);
                existingCart.setQuantity(existingCart.getQuantity() + cart.getQuantity());
            } else {
                // 如果商品不存在，添加到 Map 中
                productMap.put(productId, cart);
            }
        }

        // 返回合并后的购物车列表
        return new ArrayList<>(productMap.values());
    }

}
