package com.bupt.ecommercebackend.pojo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Address {
    private Long id;               // 地址ID (PK)
    private Long userId;           // 用户ID (FK)
    private String address;        // 详细地址
    private Boolean isDefault;     // 是否默认
    private LocalDateTime createdTime;  // 创建时间
    private LocalDateTime updatedTime;  // 信息更新时间
}
