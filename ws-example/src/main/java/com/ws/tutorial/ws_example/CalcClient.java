package com.ws.tutorial.ws_example;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class CalcClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(CalcService.class);
		factory.setAddress("http://localhost:9000/calc");
		CalcService calc = (CalcService) factory.create();
		
		int sum = calc.getSum(5, 7);
		int diff = calc.getDiff(7, 5);

		System.out.println(sum + " " + diff);

	}

}
