package com.whf.springservice.integer.webservice;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class WebserviceSupport {

	@Autowired
	private JaxWsProxyFactoryBean clientFactory;

	@SuppressWarnings("unchecked")
	protected final <T> T buildClient(Class<T> clazz, String serviceURL) {
		clientFactory.setServiceClass(clazz);
		clientFactory.setAddress(serviceURL);
		return (T) clientFactory.create();
	}

}