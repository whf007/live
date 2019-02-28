//package com.whf.springservice.service;
//
//import com.whf.springservice.common.req.Request;
//import com.whf.springservice.common.resp.Response;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
///**
// * @FeignClient("MICROSERVICE-SERVICE-PROVIDER")
// * MICROSERVICE-SERVICE-PROVIDER:是一个服务提供者的实例名称
// * 用于标记一个可用的服务的名称，同时创建一个Ribbon负载均衡器
// *
// * 该接口用于实现与服务提供者进行交互，接口中的方法与服务提供者需要暴露的方法一一对应
// */
//@FeignClient("compute-service-member")
//public interface ServiceProviderConsumerFeignService {
//
//	/**
//	 * 获取请求URL，对应着服务提供者中的方法
//	 * @return
//	 */
//	@RequestMapping(value = "/recv", method = RequestMethod.POST, consumes = "application/json")
//	public <T extends Request> String requestInfo(T t) ;
//}
