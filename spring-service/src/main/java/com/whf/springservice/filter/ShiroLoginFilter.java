package com.whf.springservice.filter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whf.springservice.common.resp.Response;
import com.whf.springservice.common.util.HttpServletRequestReader;
import com.whf.springservice.wapped.WrappedHttpServletRequest;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static org.bouncycastle.asn1.ua.DSTU4145NamedCurves.params;

public class ShiroLoginFilter extends FormAuthenticationFilter {


    @Override
    protected boolean onLoginSuccess(AuthenticationToken token,
                                     Subject subject, ServletRequest request, ServletResponse response)
            throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (!"XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"))) {// 不是ajax请求
            issueSuccessRedirect(request, response);
        } else {
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.println("{success:true,msg:'登录成功'}");
            out.flush();
            out.close();
        }
        return false;

    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e, ServletRequest request,
                                     ServletResponse response) {
        if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {// 不是ajax请求
            setFailureAttribute(request, e);
            return true;
        }
        try {
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            if("IncorrectCredentialsException".equals(e.getClass().getSimpleName())) {
                out.println("{success:false,msg:'"+e.getMessage()+"'}");
            }else{
                out.println("{success:false,msg:'登录失败！'}");
            }
            out.flush();
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }
    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     * @param request
     * @param response
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        WrappedHttpServletRequest req = new WrappedHttpServletRequest(httpServletRequest);

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (isAjax(request)) {
            // 判断用户是否时登陆请求
            String loginPath = httpServletRequest.getServletPath();
            String loginParam = HttpServletRequestReader.ReadAsChars(req);
            Map<String,String> loginMap =  JSON.parseObject(loginParam,Map.class);

            if(loginPath.endsWith("login")) {
                //4、生成无状态Token
                UsernamePasswordToken token = new UsernamePasswordToken(loginMap.get("username"), loginMap.get("password"));
                getSubject(request, response).login(token);
                return true;
            }
//            httpServletResponse.setCharacterEncoding("UTF-8");
//            httpServletResponse.setContentType("application/json");
//            Response resultData = new Response();
//            resultData.setCode(403);
//            resultData.setMessage("登录认证失效，请重新登录!");
//            httpServletResponse.getWriter().write(JSONObject.toJSON(resultData).toString());
        } else {
            //saveRequestAndRedirectToLogin(request, response);
            /**
             * @Mark 非ajax请求重定向为登录页面
             */
            httpServletResponse.sendRedirect("/login");
        }
        return false;
    }

    private boolean isAjax(ServletRequest request){
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(header)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}