package com.bupt.ecommercebackend.Service.Impl;

import com.bupt.ecommercebackend.Mapper.AddressMapper;
import com.bupt.ecommercebackend.Service.AddressService;
import com.bupt.ecommercebackend.pojo.Address;
import com.bupt.ecommercebackend.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Result addAddress(Address address) {
        String message = "已创建地址";
        if(address.getIsDefault() == 1){
            message = "已创建地址并设为默认";
            Address a = addressMapper.findByIsDefault(1);
            System.out.println("\n当前默认地址:" + a);
            if(a != null){
                a.setIsDefault(0);
                addressMapper.update(a);
                message = "已将默认地址更改为此新地址";
            }
        }
        addressMapper.addAddress(address);
        return Result.success(message);
    }
}
