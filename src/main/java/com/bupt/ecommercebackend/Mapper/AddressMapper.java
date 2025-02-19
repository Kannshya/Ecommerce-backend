package com.bupt.ecommercebackend.Mapper;

import com.bupt.ecommercebackend.pojo.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Insert("INSERT INTO address (user_id, receiver_name, phone_number, address, is_default) " +
            "VALUES (#{userId}, #{receiverName}, #{phoneNumber}, #{address}, #{isDefault})")
    void addAddress(Address address);

    @Select("select * from address where id = #{id}")
    Address findByIsDefault(Integer isDefault);

    @Update("update address set is_default=#{isDefault} where id=#{id}")
    void update(Address a);

    @Select("select * from address where user_id = #{userId}")
    List<Address> list(Long userId);
}
