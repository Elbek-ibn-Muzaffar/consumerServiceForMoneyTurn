package com.juniper.consumer.service;

import com.juniper.consumer.converters.Converter;
import com.juniper.consumer.domains.ConsumerEntity;
import com.juniper.consumer.payload.Responce.AllCostsDto;
import com.juniper.consumer.payload.Responce.FromFinancier;
import com.juniper.consumer.payload.request.ConsumerDto;
import com.juniper.consumer.repository.ConsumerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConsumerRepo consumerRepo;

    Converter converter=new Converter();


    // Financier app dan List da Barcha transferlarni olib keladi
//    public List<FromFinancier> getAllMoney()
//    {
//        ResponseEntity<FromFinancier[]> response =
//                restTemplate.getForEntity(
//                        "http://financier-app/api/v1/sendMoney/getAllTransfer",
//                        FromFinancier[].class);
//        FromFinancier[] fromFinanciers = response.getBody();
//        return Arrays.asList(fromFinanciers);
//    }


    //harajatni saqlash
    public ConsumerDto saveCost(ConsumerDto consumerDto)
    {
        ConsumerEntity consumerEntity= converter.dtoToConsumerEntity(consumerDto);
        consumerRepo.save(consumerEntity);
        return converter.entityToConsumerDto(consumerEntity);
    }

    //harajatni yangilash
    public String updateCost(long id, BigDecimal amount)
    {
        Optional<ConsumerEntity> consumerEntity=consumerRepo.findById(id);
        if (consumerEntity.isPresent())
        {
            consumerEntity.get().setAmount(amount);
            consumerRepo.save(consumerEntity.get());
        }
        else {
            return "Topilmadi";
        }

        return "O'zgartirildi";
    }


    //hamma harajatlarni chiqarish
    public List<AllCostsDto> getAllCosts()
    {
        List<ConsumerEntity> consumerEntities=consumerRepo.findAll();
        List<AllCostsDto> allCostsDtos=new ArrayList<>();

        for (int i=0;i<consumerEntities.size();i++)
        {
            allCostsDtos.add(converter.entityToAllCostsDto(consumerEntities.get(i)));
        }
        return allCostsDtos;

    }


    //Jami sarflangan harajatlar miqdorini chiqarish
    public BigDecimal getTotalCost()
    {
        List<ConsumerEntity> consumerEntities=consumerRepo.findAll();

        BigDecimal Sum=new BigDecimal(0);

        for (int i=0;i<consumerEntities.size();i++)
        {
            Sum=Sum.add(consumerEntities.get(i).getAmount());
        }
        return Sum;


    }

    public String deleteCost(long id)
    {
        Optional<ConsumerEntity> consumerEntity=consumerRepo.findById(id);
        if (consumerEntity.isPresent())
        {
            consumerRepo.deleteById(id);
            return "O'chirildi";
        }

        return "O'chmadi";
    }
}
