package com.juniper.consumer.payload.request;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class ConsumerDto {

    private BigDecimal amount;

    private String cause;
}
