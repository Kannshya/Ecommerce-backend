package com.bupt.ecommercebackend.pojo;
import lombok.Data;

@Data
public class ProductKeyword {
    private Long productId;        // 商品ID (FK)
    private String keyword;        // 关键词
}
