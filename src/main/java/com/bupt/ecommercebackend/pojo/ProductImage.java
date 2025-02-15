package com.bupt.ecommercebackend.pojo;

import lombok.Data;

@Data
public class ProductImage {
    private Long productId;        // 商品ID (FK)
    private String imageUrl;       // 图片链接
}

