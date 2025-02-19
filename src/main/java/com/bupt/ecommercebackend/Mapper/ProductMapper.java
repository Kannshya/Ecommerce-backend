package com.bupt.ecommercebackend.Mapper;

import com.bupt.ecommercebackend.pojo.Product;
import com.bupt.ecommercebackend.pojo.ProductKeyword;
import com.bupt.ecommercebackend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

    @Select("select * from product where id = #{id}")
    Product findById(Long id);

//    @Insert("INSERT INTO product (merchant_user_id, name, description, price, stock_quantity, category, discount) " +
//            "VALUES (#{merchantId}, #{name}, #{description}, #{price}, #{stockQuantity}, #{category}, #{discount})")
//    void addProduct(Product product);

    @Insert("INSERT INTO product (merchant_user_id, name, description, price, stock_quantity, category, discount) " +
            "VALUES (#{merchantId}, #{name}, #{description}, #{price}, #{stockQuantity}, #{category}, #{discount})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addProduct(Product product);


    @Insert("INSERT INTO product_keyword (product_id, keyword)" +
            "VALUES (#{productId}, #{keyword})")
    void insertKeyword(ProductKeyword keyword);
}
