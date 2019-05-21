package com.restapi.sellNbuy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.sellNbuy.dao.PaymentDAO;
import com.restapi.sellNbuy.model.Payment;

@RestController
@RequestMapping("/company")
public class PaymentController {
	
	@Autowired
	PaymentDAO paymentDAO;
	
	/* to save an payment*/
	@PostMapping("/payment")
	public Payment createPayment(@Valid @RequestBody Payment pay) {
		return paymentDAO.save(pay);
	}
	
	/*get all payment*/
	@GetMapping("/payment")
	public List<Payment> getAllPayment(){
		return paymentDAO.findAll();
	}
	
	/*get employee by payid*/
	@GetMapping("/payment/{paymentID}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value="paymentID") Long payid){
		
		Payment pay=paymentDAO.findOne(payid);
		
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pay);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/payment/{paymentID}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value="paymentID") Long payid,@Valid @RequestBody Payment payDetails){
		
		Payment pay=paymentDAO.findOne(payid);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		
		pay.setpaymentMethod(payDetails.getpaymentMethod());
		pay.setFullAmount(payDetails.getfullAmount());
		
		
		Payment updatePayment=paymentDAO.save(pay);
		return ResponseEntity.ok().body(updatePayment);
		
		
		
	}
	
	/*Delete an payment*/
	@DeleteMapping("/payment/{paymentID}")
	public ResponseEntity<Payment> deletePayment(@PathVariable(value="paymentID") Long payid){
		
		Payment pay=paymentDAO.findOne(payid);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		paymentDAO.delete(pay);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}