package com.juniper.consumer.payload.Responce;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AllCostsDto {

    private BigDecimal amount;

    private String cause;

    private Date createdDate;
}
