package com.whf.springservice.controller;

import com.whf.springservice.common.enums.ResponseCode;
import com.whf.springservice.common.util.IpUtil;
import com.whf.springservice.common.util.UserAgentUtil;
import com.whf.springservice.common.vo.UserInfo;
import com.whf.springservice.model.CourseInfo;
import com.whf.springservice.model.OrderInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @RequestMapping(value = "/free",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderInfo> free(HttpServletRequest request, Model model){
        //查询用户是否有空闲时间
        List<OrderInfo> courses = new ArrayList<>();
        OrderInfo info = new OrderInfo();
        info.setCourseId("1");
        info.setCourseName("化学");
        info.setOrderStatus("1");
        info.setCourseTime("201901021125");
        info.setName("122");
        List<String> list = new ArrayList<>();
        list.add("2019-02-26 11:20:15~2019-02-26 11:20:20");
        info.setFrees(list);
        courses.add(info);
        return courses;
    }

    @RequestMapping(value = "/resume",method = RequestMethod.GET)
    public String viewMyresume(){
        return "myresume";
    }

}
