package com.supershop.service;

import java.util.List;

import com.supershop.dto.CheckOutDto;
import com.supershop.dto.PaymentDto;
import com.supershop.exception.CartException;
import com.supershop.exception.PaymentException;
import com.supershop.exception.ProductException;
import com.supershop.exception.UserException;
import com.supershop.model.Payment;

public interface PaymentService {

	PaymentDto createPayment(CheckOutDto checkOutDto)
			throws UserException, CartException, ProductException, PaymentException;

	PaymentDto getPaymentById(Integer paymentId) throws UserException, CartException, ProductException;

	List<Payment> getAllPayments() throws UserException, CartException, ProductException;

	PaymentDto updatePayment(Integer paymentId) throws UserException, CartException, ProductException;

}
