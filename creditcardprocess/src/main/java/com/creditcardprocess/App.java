package com.creditcardprocess;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new CreditCardProcessModule());
		PaymentProcessor paymentProcessor = injector
				.getInstance(PaymentProcessor.class);
		try {
			paymentProcessor.processPayments();
		} catch (Exception a) {

		}
		System.out.println("processPayments successed");
	}
}