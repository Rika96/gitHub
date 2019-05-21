package com.restapi.sellNbuy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Employees")
@EntityListeners(AuditingEntityListener.class)

public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long paymentID;
	
	@NotBlank
	private String paymentMethod;
	
	@NotBlank
	private double fullAmount;
		
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date date;

	public Long getpaymentID() {
		return paymentID;
	}

	public void setpaymentId(Long paymentID) {
		this.paymentID = paymentID;
	}

	public String getpaymentMethod() {
		return paymentMethod;
	}

	public void setpaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getfullAmount() {
		return fullAmount;
	}

	public void setfullAmount(double fullAmount) {
		this.fullAmount = fullAmount;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setFullAmount(double getfullAmount) {
		// TODO Auto-generated method stub
		
	}

}