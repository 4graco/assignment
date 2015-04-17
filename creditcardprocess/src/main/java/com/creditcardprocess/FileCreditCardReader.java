package com.creditcardprocess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.creditcardprocess.dto.CreditCard;
import com.creditcardprocess.dto.CreditCardStatus;

public class FileCreditCardReader implements CreditCardReader {

	private final String pathToFile;

	@Inject
	public FileCreditCardReader(@Named("FileCreditCardReader path") String pathToFile) {
		this.pathToFile = pathToFile;
	}

	public String getPathToFile() {
		return pathToFile;
	}

	public Map<Integer, CreditCard> readCreditCards() throws Exception {
		Map<Integer, CreditCard> creditCardMap = new HashMap<Integer, CreditCard>();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		BufferedReader br = new BufferedReader(new FileReader(pathToFile));
		try {
			String line = br.readLine();

			while (line != null) {
				String[] fileLine = line.split(",");
				CreditCard creditCard = new CreditCard.CreditCardBuilder()
						.ID(Integer.valueOf(fileLine[0])).number(fileLine[1])
						.securityCode(Integer.valueOf(fileLine[2]))
						.expirationDate(format.parse(fileLine[3]))
						.ownerName(fileLine[4])
						.ownerZipCode(Integer.valueOf(fileLine[5]))
						.status(CreditCardStatus.valueOf(fileLine[6].toUpperCase())).build();

				creditCardMap.put(creditCard.getID(), creditCard);
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		return creditCardMap;
	}

}
