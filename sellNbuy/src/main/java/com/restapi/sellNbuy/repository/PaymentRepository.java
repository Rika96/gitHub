 package com.restapi.sellNbuy.repository;

import com.restapi.sellNbuy.model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;


 public interface PaymentRepository extends JpaRepository<Payment, Long> {

 }