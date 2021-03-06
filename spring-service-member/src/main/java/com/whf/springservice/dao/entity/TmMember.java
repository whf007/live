package com.whf.springservice.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tm_member
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class TmMember implements Serializable {
    /**
     * Database Column Remarks:
     *   会员ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.member_id
     *
     * @mbg.generated
     */
    private String memberId;

    /**
     * Database Column Remarks:
     *   登录名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.member_name
     *
     * @mbg.generated
     */
    private String memberName;

    /**
     * Database Column Remarks:
     *   1学生，2老师
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.type
     *
     * @mbg.generated
     */
    private String type;

    /**
     * Database Column Remarks:
     *   用户类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.pid_id
     *
     * @mbg.generated
     */
    private Integer pidId;

    /**
     * Database Column Remarks:
     *   真实姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.real_name
     *
     * @mbg.generated
     */
    private String realName;

    /**
     * Database Column Remarks:
     *   证件号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.cert_no
     *
     * @mbg.generated
     */
    private String certNo;

    /**
     * Database Column Remarks:
     *   教学类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.teacher_type
     *
     * @mbg.generated
     */
    private String teacherType;

    /**
     * Database Column Remarks:
     *   个人介绍
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.demo
     *
     * @mbg.generated
     */
    private String demo;

    /**
     * Database Column Remarks:
     *   微信号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.wechat
     *
     * @mbg.generated
     */
    private String wechat;

    /**
     * Database Column Remarks:
     *   支付宝账号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.alipay
     *
     * @mbg.generated
     */
    private String alipay;

    /**
     * Database Column Remarks:
     *   标签
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.lable
     *
     * @mbg.generated
     */
    private String lable;

    /**
     * Database Column Remarks:
     *   密码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.password
     *
     * @mbg.generated
     */
    private String password;
    private String salt;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.create_time
     *
     * @mbg.generated
     */
    private Date createTime ;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member.update_time
     *
     * @mbg.generated
     */
    private Date updateTime  ;

    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tm_member
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.member_id
     *
     * @return the value of tm_member.member_id
     *
     * @mbg.generated
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.member_id
     *
     * @param memberId the value for tm_member.member_id
     *
     * @mbg.generated
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.member_name
     *
     * @return the value of tm_member.member_name
     *
     * @mbg.generated
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.member_name
     *
     * @param memberName the value for tm_member.member_name
     *
     * @mbg.generated
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.type
     *
     * @return the value of tm_member.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.type
     *
     * @param type the value for tm_member.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.pid_id
     *
     * @return the value of tm_member.pid_id
     *
     * @mbg.generated
     */
    public Integer getPidId() {
        return pidId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.pid_id
     *
     * @param pidId the value for tm_member.pid_id
     *
     * @mbg.generated
     */
    public void setPidId(Integer pidId) {
        this.pidId = pidId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.real_name
     *
     * @return the value of tm_member.real_name
     *
     * @mbg.generated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.real_name
     *
     * @param realName the value for tm_member.real_name
     *
     * @mbg.generated
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.cert_no
     *
     * @return the value of tm_member.cert_no
     *
     * @mbg.generated
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.cert_no
     *
     * @param certNo the value for tm_member.cert_no
     *
     * @mbg.generated
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.teacher_type
     *
     * @return the value of tm_member.teacher_type
     *
     * @mbg.generated
     */
    public String getTeacherType() {
        return teacherType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.teacher_type
     *
     * @param teacherType the value for tm_member.teacher_type
     *
     * @mbg.generated
     */
    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.demo
     *
     * @return the value of tm_member.demo
     *
     * @mbg.generated
     */
    public String getDemo() {
        return demo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.demo
     *
     * @param demo the value for tm_member.demo
     *
     * @mbg.generated
     */
    public void setDemo(String demo) {
        this.demo = demo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.wechat
     *
     * @return the value of tm_member.wechat
     *
     * @mbg.generated
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.wechat
     *
     * @param wechat the value for tm_member.wechat
     *
     * @mbg.generated
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.alipay
     *
     * @return the value of tm_member.alipay
     *
     * @mbg.generated
     */
    public String getAlipay() {
        return alipay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.alipay
     *
     * @param alipay the value for tm_member.alipay
     *
     * @mbg.generated
     */
    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.lable
     *
     * @return the value of tm_member.lable
     *
     * @mbg.generated
     */
    public String getLable() {
        return lable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.lable
     *
     * @param lable the value for tm_member.lable
     *
     * @mbg.generated
     */
    public void setLable(String lable) {
        this.lable = lable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.password
     *
     * @return the value of tm_member.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.password
     *
     * @param password the value for tm_member.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.create_time
     *
     * @return the value of tm_member.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.create_time
     *
     * @param createTime the value for tm_member.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member.update_time
     *
     * @return the value of tm_member.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member.update_time
     *
     * @param updateTime the value for tm_member.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}