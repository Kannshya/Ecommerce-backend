package com.bupt.ecommercebackend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class User {
    private Long id;                // 用户ID（主键）
    private String name;            // 用户名
    private Integer type;           // 用户角色（0：消费者，1：商家，2：管理员）
    private String email;           // 邮箱
    private String phoneNumber;     // 联系方式
    private String description;     // 简介（个人/店铺）
    private Timestamp createdTime;  // 账户创建时间
    private Timestamp updatedTime;  // 账户信息更新时间
}