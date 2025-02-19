package com.bupt.ecommercebackend.Service.Impl;

import com.bupt.ecommercebackend.Mapper.ProductMapper;
import com.bupt.ecommercebackend.pojo.Product;
import com.bupt.ecommercebackend.Service.ProductService;
import com.bupt.ecommercebackend.pojo.ProductKeyword;
import com.bupt.ecommercebackend.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Result addProduct(Product product, String keyword) {


        // 插入商品数据并获取商品ID
        productMapper.addProduct(product);
        System.out.println("我已经插入了商品,id:" + product.getId());

        // 创建 ProductKeyword 对象并插入
        if (keyword != null && !keyword.isEmpty()) {
            ProductKeyword pk = new ProductKeyword();
            Product p = this.findById(product.getId());
            System.out.println("找到的商品" + p);
            pk.setProductId(p.getId());
            pk.setKeyword(keyword);

            productMapper.insertKeyword(pk);

        }
        return Result.success();
    }

    @Override
    public Product findById(Long id){
        Product p = productMapper.findById(id);
        return p;
    }

    @Override
    public void deleteProduct(Long id){
        productMapper.deleteProduct(id);
    }
}
