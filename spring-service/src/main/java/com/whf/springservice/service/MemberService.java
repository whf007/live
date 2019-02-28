//package com.whf.springservice.service;
//
//import com.alibaba.fastjson.JSON;
//import com.whf.springservice.common.enums.ResponseCode;
//import com.whf.springservice.common.req.Request;
//import com.whf.springservice.common.resp.Response;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by Raden-pc on 2019/1/17.
// */
//@Service
//@Slf4j
//public class MemberService<R extends Response,T extends Request> {
//    @Autowired
//    private ServiceProviderConsumerFeignService feignService;
//    public R member(T t,R r){
//        try{
//            log.info("[service-->memberService]会员接口查询:{}",t);
//            String response= feignService.requestInfo(t);
//            log.info("[memberService-->service]会员接口查询返回值:{}",response);
//            return JSON.parseObject(response, (Class<R>) r.getClass());
//        } catch (Exception e){
//            log.error("[memberService-->service]会员接口查询异常:{}",e);
//        }
//        return (R)Response.of(ResponseCode.SYSTEM_ERROR);
//
//    }
//}