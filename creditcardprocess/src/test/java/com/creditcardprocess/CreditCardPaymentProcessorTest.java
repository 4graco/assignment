package com.creditcardprocess;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Test;

import com.creditcardprocess.dto.CreditCard;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.ProvisionException;

public class CreditCardPaymentProcessorTest extends AbstractModule {

	private final CreditCardReader creditCardReader = mock(CreditCardReader.class);
	private final PaymentReader paymentReader = mock(PaymentReader.class);

	@Override
	protected void configure() {
		bind(PaymentProcessor.class).to(CreditCardPaymentProcessor.class);
		bind(PaymentReader.class).toInstance(paymentReader);

		bind(CreditCardReader.class).toInstance(creditCardReader);

	}

	@Provides
	Map<Integer, CreditCard> getCreditCardMap() throws Exception {
		Injector injector = Guice.createInjector(this);
		CreditCardReader creditCardReader = injector
				.getInstance(CreditCardReader.class);
		return creditCardReader.readCreditCards();
	}

	@Test(expected = ProvisionException.class)
	public void provideCreditCardProvisionExceptionTest() {
		Injector injector = Guice.createInjector(this);
		CreditCardReader creditCardReader = injector
				.getInstance(CreditCardReader.class);

		try {
			when(creditCardReader.readCreditCards()).thenReturn(null);
		} catch (Exception e) {

		}
		injector.getInstance(PaymentProcessor.class);
	}

	@Test(expected = Exception.class)
	public void readCreditCardsExceptionTest() {
		Injector injector = Guice.createInjector(this);
		CreditCardReader creditCardReader = injector
				.getInstance(CreditCardReader.class);
		try {
			when(creditCardReader.readCreditCards()).thenThrow(new Exception());
		} catch (Exception e) {

		}
		injector.getInstance(PaymentProcessor.class);
	}
}
