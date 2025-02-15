package com.bupt.ecommercebackend.pojo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AfterSales {
    private Long id;               // 售后申请ID
    private Long orderId;          // 关联订单ID
    private Long userId;           // 消费者ID
    private Long merchantId;       // 商家ID
    private String requestType;    // 售后申请类型
    private String reason;         // 申请原因
    private Integer status;        // 售后状态
    private Long processedBy;      // 处理人ID (管理员ID)
    private LocalDateTime processedTime; // 处理时间
    private LocalDateTime createdTime;   // 申请时间
    private LocalDateTime updatedTime;   // 信息更新时间
}
