package com.whf.springservice.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tm_course
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class TmCourse implements Serializable {
    /**
     * Database Column Remarks:
     *   课程id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_course.course_id
     *
     * @mbg.generated
     */
    private String courseId;

    private String courseName;
    /**
     * Database Column Remarks:
     *   会员ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_course.member_id
     *
     * @mbg.generated
     */
    private String memberId;

    /**
     * Database Column Remarks:
     *   课程时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_course.course_time
     *
     * @mbg.generated
     */
    private Date courseTime ;

    /**
     * Database Column Remarks:
     *   教学类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_course.teacher_type
     *
     * @mbg.generated
     */
    private String teacherType;

    /**
     * Database Column Remarks:
     *   课程介绍
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_course.demo
     *
     * @mbg.generated
     */
    private String demo;

    /**
     * Database Column Remarks:
     *   标签
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_course.lable
     *
     * @mbg.generated
     */
    private String lable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_course.create_time
     *
     * @mbg.generated
     */
    private Date createTime  = new Date();

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_course.update_time
     *
     * @mbg.generated
     */
    private Date updateTime  = new Date();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tm_course
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_course.course_id
     *
     * @return the value of tm_course.course_id
     *
     * @mbg.generated
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_course.course_id
     *
     * @param courseId the value for tm_course.course_id
     *
     * @mbg.generated
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_course.member_id
     *
     * @return the value of tm_course.member_id
     *
     * @mbg.generated
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_course.member_id
     *
     * @param memberId the value for tm_course.member_id
     *
     * @mbg.generated
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_course.course_time
     *
     * @return the value of tm_course.course_time
     *
     * @mbg.generated
     */
    public Date getCourseTime() {
        return courseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_course.course_time
     *
     * @param courseTime the value for tm_course.course_time
     *
     * @mbg.generated
     */
    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_course.teacher_type
     *
     * @return the value of tm_course.teacher_type
     *
     * @mbg.generated
     */
    public String getTeacherType() {
        return teacherType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_course.teacher_type
     *
     * @param teacherType the value for tm_course.teacher_type
     *
     * @mbg.generated
     */
    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_course.demo
     *
     * @return the value of tm_course.demo
     *
     * @mbg.generated
     */
    public String getDemo() {
        return demo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_course.demo
     *
     * @param demo the value for tm_course.demo
     *
     * @mbg.generated
     */
    public void setDemo(String demo) {
        this.demo = demo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_course.lable
     *
     * @return the value of tm_course.lable
     *
     * @mbg.generated
     */
    public String getLable() {
        return lable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_course.lable
     *
     * @param lable the value for tm_course.lable
     *
     * @mbg.generated
     */
    public void setLable(String lable) {
        this.lable = lable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_course.create_time
     *
     * @return the value of tm_course.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_course.create_time
     *
     * @param createTime the value for tm_course.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_course.update_time
     *
     * @return the value of tm_course.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_course.update_time
     *
     * @param updateTime the value for tm_course.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}