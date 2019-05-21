package com.restapi.sellNbuy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.sellNbuy.model.Payment;
import com.restapi.sellNbuy.repository.PaymentRepository;

@Service
public class PaymentDAO {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	/*to save an payment*/
	
	public Payment save(Payment pay) {
		return paymentRepository.save(pay);
	}
	
/* search all payment*/
	
	public List<Payment> findAll(){
		return paymentRepository.findAll();
	}
	
	/*get an payment by id*/
	public Payment findOne(Long paymentId) {
		return paymentRepository.findOne(paymentId);
	}
	
	
	/*delete an payment*/
	
	public void delete(Payment pay) {
		paymentRepository.delete(pay);
	}
}