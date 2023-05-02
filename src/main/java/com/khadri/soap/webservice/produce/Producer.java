package com.khadri.soap.webservice.produce;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.khadri.soap.webservice.xsd.classes.PaymentRequest;
import com.khadri.soap.webservice.xsd.classes.PaymentResponse;

@Service
public class Producer {

	public PaymentResponse invokePayment(PaymentRequest request) {

		PaymentResponse response = new PaymentResponse();
		response.setStatus("Success");
		response.setTicket(BigInteger.valueOf(12345));

		return response;
	}
}
