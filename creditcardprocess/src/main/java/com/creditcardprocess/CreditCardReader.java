package com.creditcardprocess;

import java.util.Map;

import com.creditcardprocess.dto.CreditCard;

public interface CreditCardReader {

	Map<Integer, CreditCard> readCreditCards() throws Exception;

}
