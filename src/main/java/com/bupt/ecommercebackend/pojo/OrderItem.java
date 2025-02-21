package com.bupt.ecommercebackend.pojo;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private Long id;               // 订单项ID
    //创建订单后返回id赋值到这里
    private Long orderId;          // 订单ID (FK)
    //从cartIds循环搜索商品并赋值
    private Long productId;        // 商品ID (FK)
    private Integer quantity;      // 数量
    private BigDecimal price;      // 商品单价
}

