package com.whf.springservice.controller;

import com.whf.springservice.common.enums.ResponseCode;
import com.whf.springservice.common.util.IpUtil;
import com.whf.springservice.common.util.UserAgentUtil;
import com.whf.springservice.common.vo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haozz
 * @date 2018/6/19 16:57
 * @description
 */
@Controller
@RequestMapping(value = "/err")
public class ErrorController {

    @RequestMapping(value = "/error")
    public String error(){
        int a = 1/0;
        return "abcdefg";
    }
}
