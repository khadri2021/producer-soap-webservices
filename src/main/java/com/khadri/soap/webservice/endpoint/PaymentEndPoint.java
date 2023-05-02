package com.khadri.soap.webservice.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.khadri.soap.webservice.produce.Producer;
import com.khadri.soap.webservice.xsd.classes.PaymentRequest;
import com.khadri.soap.webservice.xsd.classes.PaymentResponse;

@Endpoint
public class PaymentEndPoint{

	
	@Autowired
	private Producer producer;
	
	
	@PayloadRoot(namespace = "http://www.khadri.com/soap/webservice/xsd/classes",localPart = "PaymentRequest")
	@ResponseBody
	public JAXBElement<PaymentResponse> doPayment(@RequestBody JAXBElement<PaymentRequest> paymentRequest) {
		System.out.println("doPayment Invoked");
		
		QName qname = new QName("ResponseElement"); 
		
		return new JAXBElement<>(qname, PaymentResponse.class, producer.invokePayment(paymentRequest.getValue()));
		
		
	}

 
}
