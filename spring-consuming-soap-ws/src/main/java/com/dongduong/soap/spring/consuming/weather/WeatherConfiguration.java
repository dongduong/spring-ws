package com.dongduong.soap.spring.consuming.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WeatherConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.dongduong.soap.spring.consuming.weather.wsdl");
		return marshaller;
	}

	@Bean
	public WeatherClient weatherClient(Jaxb2Marshaller marshaller) {
		WeatherClient client = new WeatherClient();
		client.setDefaultUri("http://ws.cdyne.com/WeatherWS");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
