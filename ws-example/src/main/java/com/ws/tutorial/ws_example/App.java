package com.ws.tutorial.ws_example;

import javax.xml.ws.Endpoint;

public class App {

	public static void main(String[] args) throws Exception {

		CalcServiceImpl calcServiceImpl = new CalcServiceImpl();
		Endpoint.publish("http://localhost:9000/calc", calcServiceImpl);

	}
}
