package com.bupt.ecommercebackend.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    private Long id;               // 商品ID
    private Long merchantUserId;       // 商家ID
    private String name;           // 商品名称
    private String description;    // 商品描述
    private BigDecimal price;      // 价格
    private BigDecimal discount;   // 折扣
    private Integer stockQuantity; // 库存数量
    private String category;       // 商品类别
    private Integer status;        // 状态
    private LocalDateTime createdTime;  // 创建时间
    private LocalDateTime updatedTime;  // 信息更新时间
}
