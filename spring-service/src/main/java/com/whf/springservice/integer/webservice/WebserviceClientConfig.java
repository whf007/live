package com.whf.springservice.integer.webservice;

import com.whf.springservice.MemberFacade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebserviceClientConfig extends WebserviceSupport{

	@Value("${member.service.wsUrl}")
	private String member; //tss_ws路径
	// 收银台
	// 凭证服务
//	@Value("${cashier.ws.url}")
//	private String cashierWsUrl; //voucher_ws路径
	@Bean
	public MemberFacade memberFacade() {
		return buildClient(MemberFacade.class, member + "/MemberFacade");
	}

//	@Bean
//	public CashierFacade cashierService() {
//		return buildClient(CashierFacade.class,cashierWsUrl + "/cashierService");
//	}
}
