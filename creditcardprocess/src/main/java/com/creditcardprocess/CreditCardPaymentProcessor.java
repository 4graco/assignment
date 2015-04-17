package com.creditcardprocess;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.creditcardprocess.dto.CreditCard;
import com.creditcardprocess.dto.Payment;
import com.creditcardprocess.dto.PaymentStatus;

public class CreditCardPaymentProcessor implements PaymentProcessor {

	private final Map<Integer, CreditCard> creditCardMap;
	private final PaymentReader paymentReader;

	@Inject
	public CreditCardPaymentProcessor(Map<Integer, CreditCard> creditCardMap,
			PaymentReader paymentReader) {
		this.creditCardMap = creditCardMap;
		this.paymentReader = paymentReader;
	}

	public CreditCard getCreditCard(int foreignKeyToCreditCard) {
		return creditCardMap.get(foreignKeyToCreditCard);
	}

	public PaymentStatus chargeCreditCard(CreditCard card, double amount) {
		return PaymentStatus.ERROR;
	}

	private boolean checkPaymentStatus(Payment paymant) {
		return (paymant.getStatus() == PaymentStatus.NEW)
				|| (paymant.getStatus() == PaymentStatus.ERROR);
	}

	public void processPayments() throws Exception {
		List<Payment> paymentList = paymentReader.readPayments();
		if (paymentList == null) {
			throw new Exception();
		}
		for (Payment paymant : paymentList) {
			if (checkPaymentStatus(paymant)) {
				CreditCard card = getCreditCard(paymant
						.getForeignKeyToCreditCard());
				if (card == null) {
					paymant.setStatus(PaymentStatus.ERROR);
				} else {
					paymant.setStatus(PaymentStatus.PENDING);
					PaymentStatus paymentStatus = chargeCreditCard(card,
							paymant.getAmount());
					paymant.setStatus(paymentStatus);
				}
			}
		}
	}

}
