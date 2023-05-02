package com.khadri.soap.webservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class PaymentConfig {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> servletRegistrationBean(ApplicationContext context) {

		MessageDispatcherServlet dispatcherServlet = new MessageDispatcherServlet();
		dispatcherServlet.setApplicationContext(context);
		dispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(dispatcherServlet, "/ws/*");

	}

	@Bean(name = "paymentProducer")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema) {

		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("PaymentEndPoint");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.khadri.com/soap/webservice/xsd/classes");
		wsdl11Definition.setSchema(xsdSchema);

		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema xsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("Payment.xsd"));
	}

}
