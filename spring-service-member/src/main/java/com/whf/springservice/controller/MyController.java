package com.whf.springservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/my")
public class MyController {


	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		
		return "hello3";
	}
	@RequestMapping("/login")
	public String index(){
		return "index";
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
	// 获取请求URL
	@RequestMapping("/provider/request/info")
	@ResponseBody
	public String requestInfo(HttpServletRequest request) {

		return request.getRequestURL().toString();
	}
}
