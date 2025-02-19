package com.bupt.ecommercebackend.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO order (user_id, merchant_id, total_amount, user_address_id," +
            " payment_method, tracking_number, status) " +
            "VALUES (#{userId}, #{merchantId}, #{totalAmount}, #{userAddressId},"+
            " #{paymentMethod}, #{trackingNumber}, #{status})")
    void createOrder(Long userId, Long merchantId, BigDecimal totalAmount, String userAddressId,
                     String paymentMethod, String trackingNumber, Integer status);

    @Insert("INSERT INTO order_item (order_id, product_id, quantity, price)" +
            "VALUES (#{orderId}, #{productId}, #{quantity}, #{price})")
    void addItem(Long orderId, Long productId, Integer quantity, BigDecimal price);
}