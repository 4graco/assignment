package com.creditcardprocess;

public interface PaymentProcessor {

	/*
	 * Payment processor currently has only one implementation:
	 *  - CreditCardPaymentProcessor
	 */

	void processPayments() throws Exception;
}
