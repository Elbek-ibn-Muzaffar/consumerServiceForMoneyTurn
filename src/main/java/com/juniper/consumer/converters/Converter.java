package com.juniper.consumer.converters;

import com.juniper.consumer.domains.ConsumerEntity;
import com.juniper.consumer.payload.Responce.AllCostsDto;
import com.juniper.consumer.payload.request.ConsumerDto;
import org.modelmapper.ModelMapper;

import java.util.List;

public class Converter {

    ModelMapper modelMapper=new ModelMapper();

    public ConsumerEntity dtoToConsumerEntity(ConsumerDto consumerDto)
    {
        ConsumerEntity consumerEntity=modelMapper.map(consumerDto,ConsumerEntity.class);
        return consumerEntity;
    }

    public ConsumerDto entityToConsumerDto(ConsumerEntity consumerEntity)
    {
        ConsumerDto consumerDto=modelMapper.map(consumerEntity,ConsumerDto.class);
        return consumerDto;
    }

    public AllCostsDto entityToAllCostsDto(ConsumerEntity consumerEntity)
    {
        AllCostsDto allCostsDto=modelMapper.map(consumerEntity,AllCostsDto.class);
        return allCostsDto;
    }

}
