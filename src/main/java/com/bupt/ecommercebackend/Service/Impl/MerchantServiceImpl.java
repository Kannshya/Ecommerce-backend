package com.bupt.ecommercebackend.Service.Impl;

import com.bupt.ecommercebackend.Mapper.MerchantMapper;
import com.bupt.ecommercebackend.Service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public void register(Long userId, String partnerId, String appId, int status){
        merchantMapper.register(userId, partnerId, appId, status);
    }
}
