package com.bupt.ecommercebackend.Service;

public interface MerchantService {
    void register(Long userId, String partnerId, String appId, int status);
}
