package com.whf.springservice.controller;

import com.whf.springservice.common.enums.ResponseCode;
import com.whf.springservice.common.util.IpUtil;
import com.whf.springservice.common.util.UserAgentUtil;
import com.whf.springservice.common.vo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
@RequestMapping("/live")
public class DemoController {

    @RequestMapping(value = "/room",method = RequestMethod.GET)
    public String hello(HttpServletRequest request, Model model){
        //根据用户ip判断用户是否访问过本站
        String ip = IpUtil.getIp(request);
        Random random = new Random(20);
        HttpSession session = request.getSession();
        UserInfo principal = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        if (principal == null){
            //用户未访问过，提示用户登陆
            model.addAttribute(ResponseCode.USER_NOT_LOGIN.getCode());
        }
        //System.out.println("ip="+ip+"name="+user.getRandomName());
        //判断用户是手机还是电脑端
        if (UserAgentUtil.JudgeIsMoblie(request)){
            //移动端访问
            return "/live/live_m";
        }else {
            model.addAttribute("online_guests",1);
            model.addAttribute("history_guests",1);
            return "/live/live";
        }

    }

    @RequestMapping(value = "/resume",method = RequestMethod.GET)
    public String viewMyresume(){
        return "myresume";
    }

}
