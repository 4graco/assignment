package com.creditcardprocess;

import java.util.List;

import com.creditcardprocess.dto.Payment;

public interface PaymentReader {

	/*
	 * Payment reader can have multiple sources. Currently supported sources 
	 * - Database payment reader 
	 * - File payment reader 
	 * - Service payment reader
	 */
	
	List<Payment> readPayments() throws Exception;
}
