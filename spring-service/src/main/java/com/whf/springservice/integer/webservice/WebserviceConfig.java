package com.whf.springservice.integer.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebserviceConfig {
	
	@Bean(name = "clientFactory")
	public JaxWsProxyFactoryBean clientFactory() {
		return new JaxWsProxyFactoryBean();
	}
}
