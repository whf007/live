package com.whf.springservice.config;

//import com.whf.springservice.interceptor.AuthInterceptor;
import com.whf.springservice.MemberFacade;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.cxf.jaxws.EndpointImpl;
import javax.xml.ws.Endpoint;

/**
 * Created by Raden-pc on 2019/1/19.
 */
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private MemberFacade memberFacade;

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, memberFacade);
//        endpoint.getInInterceptors().add(new AuthInterceptor());//添加校验拦截器
        endpoint.publish("/MemberFacade");

        return endpoint;
    }
}
