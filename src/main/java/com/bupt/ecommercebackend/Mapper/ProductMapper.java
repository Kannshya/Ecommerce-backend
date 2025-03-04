package com.bupt.ecommercebackend.Mapper;

import com.bupt.ecommercebackend.pojo.Product;
import com.bupt.ecommercebackend.pojo.ProductKeyword;
import com.bupt.ecommercebackend.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductMapper {

    @Select("select * from product where id = #{id}")
    Product findById(Long id);

    @Insert("INSERT INTO product (merchant_user_id, name, description, price, stock_quantity, category, discount) " +
            "VALUES (#{merchantUserId}, #{name}, #{description}, #{price}, #{stockQuantity}, #{category}, #{discount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addProduct(Product product);


    @Insert("INSERT INTO product_keyword (product_id, keyword)" +
            "VALUES (#{productId}, #{keyword})")
    void insertKeyword(ProductKeyword keyword);

    @Update("update product set status= -1 where id=#{id}")
    void deleteProduct(Long id);

}
