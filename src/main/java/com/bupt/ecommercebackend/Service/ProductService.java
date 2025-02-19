package com.bupt.ecommercebackend.Service;

import com.bupt.ecommercebackend.pojo.Product;
import com.bupt.ecommercebackend.pojo.Result;

import java.math.BigDecimal;

public interface ProductService {
    Result addProduct(Product product, String keyword);
    Product findById(Long id);
    void deleteProduct(Long id);
}
