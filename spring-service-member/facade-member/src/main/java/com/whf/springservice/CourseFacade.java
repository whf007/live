package com.whf.springservice;

import com.whf.springservice.model.CourseInfo;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Raden-pc on 2019/1/3.
 */
@WebService(name = "CourseFacade",
        targetNamespace = "http://springservice.whf.com")
public interface CourseFacade {
    // 添加课程
    @WebMethod
    public String addCourse(CourseInfo courseInfo);
    //查询课程
    @WebMethod
    public CourseInfo queryCourse(CourseInfo courseInfo);


}
