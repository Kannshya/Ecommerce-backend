package com.bupt.ecommercebackend.pojo;
import lombok.Data;

@Data
public class Merchant {
    private Long userId;            // 用户ID (FK)
    private String partnerId;       // 商户号
    private String appId;           // 应用ID
    private String businessLicense; // 营业执照文件路径
    private Integer status;         // 审核状态: 0-待审核, 1-已通过, 2-已拒绝
}
