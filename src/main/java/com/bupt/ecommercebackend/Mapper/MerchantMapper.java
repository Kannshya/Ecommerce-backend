package com.bupt.ecommercebackend.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MerchantMapper {

    @Insert("INSERT INTO merchant (user_id, partner_id, app_id, status) " +
            "VALUES (#{userId}, #{partnerId}, #{appId}, #{status})")
    void register(Long userId, String partnerId, String appId, int status);

}
