package com.creditcardprocess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.creditcardprocess.dto.Payment;
import com.creditcardprocess.dto.PaymentStatus;

public class FilePaymentReader implements PaymentReader {
	
	private final String pathToFile;

	@Inject
	public FilePaymentReader(@Named("FilePaymentReader path") String pathToFile) {
		this.pathToFile = pathToFile;
	}

	public String getPathToFile() {
		return pathToFile;
	}

	public List<Payment> readPayments() throws Exception {
		List<Payment> paymentList = new LinkedList<Payment>();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		BufferedReader br = new BufferedReader(new FileReader(pathToFile));
		try {
			String line = br.readLine();

			while (line != null) {
				String[] fileLine = line.split(",");
				Payment payment = new Payment.PaymentBuilder()
						.ID(Integer.valueOf(fileLine[0]))
						.amount(Integer.valueOf(fileLine[1]))
						.date(format.parse(fileLine[2]))
						.status(PaymentStatus.valueOf(fileLine[3].toUpperCase()))
						.foreignKeyToCreditCard(Integer.valueOf(fileLine[4]))
						.build();

				paymentList.add(payment);
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		return paymentList;
	}
}
