package com.whf.springservice.controller;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.whf.springservice.common.enums.ResponseCode;
import com.whf.springservice.common.exception.CommonException;
import com.whf.springservice.common.req.Request;
import com.whf.springservice.common.resp.Response;
import com.whf.springservice.dao.entity.TmMember;
import com.whf.springservice.dao.mapper.TmMemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Stopwatch.createStarted;
import static com.whf.springservice.common.resp.Response.of;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Controller
@Slf4j
public class UserController extends AbstractRouter<Request>{
	@Autowired
	TmMemberMapper tmMemberMapper;

	@RequestMapping("/save")
	@ResponseBody
	public String save(){
        List<TmMember> tmMembers = tmMemberMapper.selectAll();
        return "hello3";
	}
	@RequestMapping("/index")
	public String index(){

		return "index";
	}
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/recv", method = RequestMethod.POST)
	public  Response s (HttpServletRequest httpServletRequest,  @RequestBody Map<String, String> requestMap){
		final Stopwatch stopwatch = createStarted();
		Response response = null;
		try {
			// IP
			// String ipAddress = getIPAddress(httpServletRequest);
			checkCommonParameter(httpServletRequest, requestMap);
			response = process(requestMap);
			return response;
		} catch (CommonException e) {
			log.error("recv error: requst:{}, CommonException:{}", requestMap, e);
			return of(e);
//        } catch (ValidateException e) {
//            log.error("recv error: requst:{}, VerifyException:{}", requestMap, e);
//            return of(ResponseCode.ILLEGAL_ARGUMENT, e.getMessage());
		} catch (Throwable t) {
			log.error("recv error: requst:{}, exception:{} ", requestMap, t);
			return of(ResponseCode.SYSTEM_ERROR);
		} finally {
			log.info("recv, request:{} ,response:{}, costs {}ms", requestMap, response, stopwatch.elapsed(MILLISECONDS));
		}
	}
	/**
	 * 所有非空参数参与校验
	 *
	 * @param request
	 * @param requestMap
	 */
	private void checkCommonParameter(HttpServletRequest request, Map<String, String> requestMap) {
		Map<String, String> paramMap = Maps.newHashMap();
		for (String key : requestMap.keySet()) {
			String value = MapUtils.getString(requestMap, key);
			if (StringUtils.isEmpty(value)) {
				paramMap.put(key, value);
			}
		}
		log.info("request data filter result:{}", mapToString(requestMap));
		requestMap.put("basePath",request.getSession().getServletContext().getRealPath("/"));
	}
	private String mapToString(Map<String, String> requestMap) {
		StringBuffer sb = new StringBuffer();
		Set<Map.Entry<String, String>> entries = requestMap.entrySet();
		Iterator<Map.Entry<String, String>> iterator = entries.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> next = iterator.next();
			String key = next.getKey();
			String value = next.getValue();
			if (key.equalsIgnoreCase("identityId") || key.equalsIgnoreCase("mobile")) {
				if (value.length() > 4) {
					value = value.substring(0, value.length() - 4) + "***";
				}
			}
			sb.append(key + ":" + value + ",");
		}
		return sb.toString();
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
