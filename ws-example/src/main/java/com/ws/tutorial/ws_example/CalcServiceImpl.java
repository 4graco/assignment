package com.ws.tutorial.ws_example;

import javax.jws.WebService;

@WebService(endpointInterface = "com.ws.tutorial.ws_example.CalcService", serviceName = "CalcService")
public class CalcServiceImpl implements CalcService {

	public int getSum(int a, int b) {
		return a + b;
	}

	public int getDiff(int a, int b) {
		return a - b;
	}

}
