package com.bupt.ecommercebackend.pojo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long id;               // 订单ID
    //从token里解析
    private Long userId;           // 订单所属用户（消费者）
    //直接接收
    private String userAddressId;    // 收货地址
    private String paymentMethod;  // 支付方式
    //后端计算/填写
    private BigDecimal totalAmount; // 订单总金额
    private Integer status;        // 订单状态
    //创建时不填写
    private String trackingNumber; // 运单号
    private LocalDateTime createdTime;  // 创建时间
    private LocalDateTime updatedTime;  // 信息更新时间
}

