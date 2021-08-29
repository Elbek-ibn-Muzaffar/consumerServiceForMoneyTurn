package com.juniper.consumer.controller;

import com.juniper.consumer.payload.Responce.AllCostsDto;
import com.juniper.consumer.payload.Responce.FromFinancier;
import com.juniper.consumer.payload.request.ConsumerDto;
import com.juniper.consumer.service.ConsumerService;
import com.juniper.consumer.service.ConsumerService2;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v2/consumerApp")
public class ConsumerResource {

    @Autowired
    ConsumerService2 consumerService;

    @Autowired
    ConsumerService consumerService2;

    @ApiOperation("barcha o'tkazmalarni olib kelish")
    @GetMapping("/getAllMoneyFinancier")
    public List<FromFinancier> getAllMoney()
    {
        return consumerService.getAllTransfer();
    }


    @ApiOperation("Barcha harajatlarni chiqarish")
    @GetMapping("/getAllCosts")
    public List<AllCostsDto> getAllCosts()
    {
        List<AllCostsDto> allCostsDtos=consumerService2.getAllCosts();
        return allCostsDtos;
    }


    @ApiOperation("Harajatlarni saqlash")
    @PostMapping("/saveCost")
    public ResponseEntity saveCost(@RequestBody ConsumerDto consumerDto)
    {
        ConsumerDto consumerDto1=consumerService2.saveCost(consumerDto);
        return ResponseEntity.ok(consumerDto1);
    }

    @ApiOperation("Harajat miqdorini o'zgartirish")
    @PutMapping("/updateCost")
    public ResponseEntity updateCost(@RequestParam long id, @RequestParam BigDecimal amount)
    {
        String response= consumerService2.updateCost(id, amount);
        return ResponseEntity.ok(response);
    }

    @ApiOperation("Jami harajat miqdorini chiqarish")
    @GetMapping("/getTotalCost")
    public ResponseEntity getTotalCosts()
    {
        return ResponseEntity.ok(consumerService2.getTotalCost());
    }


    @ApiOperation("Harajatni o'chirish")
    @DeleteMapping("/deleteCost/{id}")
    public ResponseEntity deleteCost(@PathVariable long id)
    {
        return ResponseEntity.ok(consumerService2.deleteCost(id));
    }



}
