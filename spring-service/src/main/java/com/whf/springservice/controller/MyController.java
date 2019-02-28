package com.whf.springservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whf.springservice.common.req.LoginReq;
import com.whf.springservice.common.resp.RegisterResp;
import com.whf.springservice.common.resp.Response;
import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/my")
@Slf4j
public class MyController {
    // 注入Feign接口
	@RequestMapping("/info")
	public String info(){
		return "users/userInfo";
	}
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	@RequestMapping("/index-test")
	public String indextest(){
		return "index-test";
	}
	@RequestMapping("/index-new")
	public String indexnew(){
		return "index-new";
	}

	/**
	 * 上传文件。
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam(value = "file", required = true)MultipartFile file, HttpServletRequest request) throws IOException {
        String parameter = request.getParameter("accessToken");
        byte[] bytes = file.getBytes();
		File fileToSave = new File(file.getOriginalFilename());
		FileCopyUtils.copy(bytes, fileToSave);
		return fileToSave.getAbsolutePath();
	}
	@RequestMapping ("/getRemindOrders")
	@ResponseBody
	public String getRemindOrders (HttpServletResponse response, HttpServletRequest request){
		// 参数容器
		Map <String, Object> paraMap = new HashMap<String, Object>();
		// 返回数据的容器
		Map <String, Object> resultMap = new HashMap <String, Object> ();
		Long userid = 0L;
		// 获得用户id
		String useridStr = request.getParameter ("userid");
		if (!StringUtils.isBlank (useridStr))
		{
			userid = Long.parseLong (useridStr);
		}
		// 模拟数据,在获取分页参数失败的情况下代替
		int limit = 10;
		int offset = 0;
		try
		{
			if (!StringUtils.isBlank (request.getParameter ("offset")))
			{
				// 开始
				offset = Integer.parseInt (request.getParameter ("offset")) + 1;
			}
			if (!StringUtils.isBlank (request.getParameter ("limit")))
			{
				// 结束
				limit = offset + Integer.parseInt (request.getParameter ("limit")) - 1;
			}
			String name = request.getParameter ("name");
			String status = request.getParameter ("status");
			// 搜索开始时间
			String start = request.getParameter ("startTime");
			// 搜索结束时间
			String end = request.getParameter ("endTime");
			// 查询我的家人
//			if (StringUtils.isNotEmpty (useridStr))
//			{
//				userFamily.setUserId (userid);
//				// 查询认证过的家属相关信息
//				userFamily.setIsRealAuth ("1");
//			}
//			UserDto user = (UserDto) request.getSession ().getAttribute (LoginConstants.LOGIN_USER);
//			String identification = user.getPortalUserInfo ().getIdentification ();

			// 获取家人的相关信息
//			List <UserFamily> userFamilyList = userFamilyService.queryUserFimalyByPage (userFamily, 0, -1);
//			// 添加自己
//			userFamily.setIdentification (identification);
//			userFamilyList.add (userFamily);
			// 设置查询参数
//			remindOrder.setName (name != null ? name : "");
//			remindOrder.setOrderStatus (status != null ? status : "");
//			remindOrder.setStartTime (start != null ? start : "");
//			remindOrder.setEndTime (end != null ? end : "");
			paraMap.put ("startNumber", offset);
			paraMap.put ("endNumber", limit);
//			paraMap.put ("allFamily", userFamilyList);
//			paraMap.put ("remindOrder", remindOrder);
//			List <RemindOrder> list = null;
//			int count = 0;
//			count = remindOrderService.findRemindCountOfFamily (paraMap);
//			if (count != 0)
//			{
//				list = remindOrderService.findRemindByConditionOfFamilyWithPage (paraMap);
//			}
//			resultMap.put ("rows", list);
//			resultMap.put ("total", count);
		}
		catch (Exception e)
		{
			log.error ("查询数据失败!", e);
			resultMap.put ("rows", null);
			resultMap.put ("total", 0);
		}
//		JsonConfig config = new JsonConfig ();
//		config.registerJsonValueProcessor (Date.class, new JsonDateValueProcessor ("yyyy-MM-dd HH:mm:ss"));
		return JSON.toJSONString(resultMap);
	}
}
