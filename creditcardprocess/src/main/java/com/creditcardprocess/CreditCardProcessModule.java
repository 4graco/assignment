package com.creditcardprocess;

import java.util.Map;

import com.creditcardprocess.dto.CreditCard;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class CreditCardProcessModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(PaymentProcessor.class).to(CreditCardPaymentProcessor.class);
		bind(PaymentReader.class).to(FilePaymentReader.class);
		bind(CreditCardReader.class).to(FileCreditCardReader.class);
		bind(String.class).annotatedWith(Names.named("FilePaymentReader path"))
				.toInstance("C:\\Users\\gg\\Downloads\\payments.txt");
		bind(String.class).annotatedWith(
				Names.named("FileCreditCardReader path")).toInstance(
				"C:\\Users\\gg\\Downloads\\creditCards.txt");
	}

	@Provides
	Map<Integer, CreditCard> provideCreditCardMap() throws Exception {
		Injector injector = Guice.createInjector(new CreditCardProcessModule());
		CreditCardReader creditCardReader = injector
				.getInstance(CreditCardReader.class);
		Map<Integer, CreditCard> creditCardMap = creditCardReader
				.readCreditCards();
		return creditCardMap;
	}
}
