package com.bupt.ecommercebackend.pojo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Cart {
    private Long id;               // 购物车ID（主键）
    private Long userId;           // 用户ID
    private Long productId;        // 商品ID
    private Integer quantity;      // 商品数量
    private LocalDateTime createTime;  // 添加到购物车的时间
    private LocalDateTime updateTime;  // 信息更新时间
}
