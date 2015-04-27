package com.ws.tutorial.ws_example;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface CalcService {

	int getSum(@WebParam(name="first") int a, @WebParam(name="second") int b);
	int getDiff(int a, int b);
}
