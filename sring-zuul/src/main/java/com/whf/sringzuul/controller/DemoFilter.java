package com.whf.sringzuul.controller;

import com.netflix.zuul.context.RequestContext;
import com.whf.springservice.common.Commons;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class DemoFilter extends ZuulFilter {
	private static Logger log = Logger.getLogger(DemoFilter.class);
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        //创建一个解析器工厂

        DiskFileItemFactory factory=new DiskFileItemFactory();

        //得到解析器

        ServletFileUpload upload=new ServletFileUpload(factory);

        upload.setHeaderEncoding("utf-8");
		//设置编码
		if(upload.isMultipartContent(request)) {
            try {
                Map<String, List<FileItem>> stringListMap = upload.parseParameterMap(request);
                Iterator<String> it = stringListMap.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    System.out.println(stringListMap.get(key) + "-----------" + key);
                }
                List<FileItem> accessToken = stringListMap.get("accessToken");
                for (FileItem item : accessToken) {
                    String string = item.getString();
                    System.out.println(string);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		Object accessToken = request.getSession().getAttribute(Commons.LOGIN_ADMIN_KEY);

//		if (accessToken == null) {
//			log.warn("access token is empty");
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseStatusCode(401);
//			return null;
//		}
		log.info("access token ok");
//		return null;
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		
		return "pre";
	}

}
