package com.juniper.consumer.payload.Responce;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class FromFinancier {

    private BigDecimal amount;

    private Timestamp date;
}
