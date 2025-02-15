package com.bupt.ecommercebackend.pojo;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private Long id;               // 订单项ID
    private Long orderId;          // 订单ID (FK)
    private Long productId;        // 商品ID (FK)
    private Integer quantity;      // 数量
    private BigDecimal price;      // 商品单价
}

