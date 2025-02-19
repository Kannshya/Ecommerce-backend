package com.bupt.ecommercebackend.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    @Insert("INSERT INTO cart (user_id, product_id, quantity) " +
            "VALUES (#{userId}, #{productId}, #{quantity})")
    void addProduct(Long userId, Long productId, Integer quantity);


}
