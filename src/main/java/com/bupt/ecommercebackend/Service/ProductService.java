package com.bupt.ecommercebackend.Service;

import com.bupt.ecommercebackend.pojo.Product;
import com.bupt.ecommercebackend.pojo.Result;

public interface ProductService {
    Result addProduct(Product product, String keyword);
    Product findById(Long id);
    Result deleteProduct(String token, Long id);
}
