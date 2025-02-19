package com.bupt.ecommercebackend.Mapper;

import com.bupt.ecommercebackend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from user where userID = #{id}")
    User findById(int id);

    @Select("select * from user where name = #{name}")
    User findByName(String name);

    @Insert("INSERT INTO user (name, password, phone_number, type, description) " +
            "VALUES (#{name}, #{password}, #{phoneNumber}, #{type}, #{description})")
    void register(String name, String password, String phoneNumber, Integer type, String description);

    void update(User user);
}
