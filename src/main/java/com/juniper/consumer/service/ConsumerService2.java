package com.juniper.consumer.service;

import com.juniper.consumer.payload.Responce.FromFinancier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//finansier app uchun contract

@FeignClient("financier-app")
public interface ConsumerService2 {

    @GetMapping("api/v1/sendMoney/getAllTransfer")
    List<FromFinancier> getAllTransfer();
}
