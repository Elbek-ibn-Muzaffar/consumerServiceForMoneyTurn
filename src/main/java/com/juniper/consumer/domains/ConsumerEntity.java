package com.juniper.consumer.domains;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class ConsumerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;

    private String cause;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdDate;
}
