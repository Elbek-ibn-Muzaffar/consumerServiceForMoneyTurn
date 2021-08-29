package com.juniper.consumer.repository;

import com.juniper.consumer.domains.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepo extends JpaRepository<ConsumerEntity,Long> {

}
