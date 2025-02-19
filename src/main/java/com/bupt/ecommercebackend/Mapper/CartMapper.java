package com.bupt.ecommercebackend.Mapper;

import com.bupt.ecommercebackend.pojo.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

    @Insert("INSERT INTO cart (user_id, product_id, quantity) " +
            "VALUES (#{userId}, #{productId}, #{quantity})")
    void addProduct(Long userId, Long productId, Integer quantity);

    @Select("select * from cart where user_id=#{userId}")
    List<Cart> listProduct(Long userId);

}
