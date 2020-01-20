package com.example.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Ejemplo;
import com.example.service.ExampleService;

@Service
public class ExampleImpl implements ExampleService{
	
	private static Logger log = LoggerFactory.getLogger(ExampleImpl.class);
			
	private RestTemplate restTemplate = new RestTemplate();
	
	private final String cppHost= "${app.cpp.micro.host}";
	private final String cppPort= "${app.cpp.micro.port}";
	
	@Override
	public Ejemplo ex(Ejemplo orders) throws Exception {
		Ejemplo dhOrders =null;
		try{
			String url = String.format("http://%s:%s//v1/ivmero/api/", cppHost,cppPort);
            dhOrders =restTemplate.postForObject(url, orders, Ejemplo.class);     
        }catch (Exception ex){
        	log.info(ex.getMessage());
        }
		return dhOrders;
	}

}
