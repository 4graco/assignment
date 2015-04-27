package com.ws.tutorial.ws_example;

public class App {

	public static void main(String[] args) {

		CalcServiceService service = new CalcServiceService();
		CalcService client = service.getCalcServicePort();
		
		System.out.println("getDiff() = " + client.getDiff(5, 2));
		System.out.println("getSum() = " + client.getSum(5, 2));
		
	}

}
