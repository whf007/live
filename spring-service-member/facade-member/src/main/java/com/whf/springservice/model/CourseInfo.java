package com.whf.springservice.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
/**
 * Created by Raden-pc on 2019/2/19.
 */
@Getter
@Setter
@ToString
public class CourseInfo {
    private String courseId;
    private String courseName;
    private String memberId;

    private Date courseTime ;
    private Date courseEndTime ;
    private String teacherType;

    private String demo;

    private String lable;

    private Date createTime  = new Date();

    private Date updateTime  = new Date();

}