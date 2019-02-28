package com.whf.springservice.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * Created by Raden-pc on 2019/2/19.
 */
@Getter
@Setter
@ToString
public class OrderInfo {
    private String courseId;
    private String courseName;
    private String memberId;

    private String courseTime ;
    private String courseEndTime ;
    private String teacherType;

    private String demo;

    private String name;
    private List<String> frees;
    private String orderStatus;// 预约状态
    private Date createTime  = new Date();

    private Date updateTime  = new Date();

}