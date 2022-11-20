package com.supershop.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supershop.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
