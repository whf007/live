package com.whf.springservice.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tm_member_identity
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class TmMemberIdentity implements Serializable {
    /**
     * Database Column Remarks:
     *   会员ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member_identity.member_id
     *
     * @mbg.generated
     */
    private String memberId;

    /**
     * Database Column Remarks:
     *   登录名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member_identity.identity_id
     *
     * @mbg.generated
     */
    private String identityId;

    /**
     * Database Column Remarks:
     *   登录名类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member_identity.identity_type
     *
     * @mbg.generated
     */
    private String identityType;

    /**
     * Database Column Remarks:
     *   用户类型，1学生，2老师
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member_identity.pid_id
     *
     * @mbg.generated
     */
    private Integer pidId;

    /**
     * Database Column Remarks:
     *   代理方
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member_identity.partner_id
     *
     * @mbg.generated
     */
    private String partnerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tm_member_identity.create_time
     *
     * @mbg.generated
     */
    private Date createTime = new Date();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tm_member_identity
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member_identity.member_id
     *
     * @return the value of tm_member_identity.member_id
     *
     * @mbg.generated
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member_identity.member_id
     *
     * @param memberId the value for tm_member_identity.member_id
     *
     * @mbg.generated
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member_identity.identity_id
     *
     * @return the value of tm_member_identity.identity_id
     *
     * @mbg.generated
     */
    public String getIdentityId() {
        return identityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member_identity.identity_id
     *
     * @param identityId the value for tm_member_identity.identity_id
     *
     * @mbg.generated
     */
    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member_identity.identity_type
     *
     * @return the value of tm_member_identity.identity_type
     *
     * @mbg.generated
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member_identity.identity_type
     *
     * @param identityType the value for tm_member_identity.identity_type
     *
     * @mbg.generated
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member_identity.pid_id
     *
     * @return the value of tm_member_identity.pid_id
     *
     * @mbg.generated
     */
    public Integer getPidId() {
        return pidId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member_identity.pid_id
     *
     * @param pidId the value for tm_member_identity.pid_id
     *
     * @mbg.generated
     */
    public void setPidId(Integer pidId) {
        this.pidId = pidId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member_identity.partner_id
     *
     * @return the value of tm_member_identity.partner_id
     *
     * @mbg.generated
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member_identity.partner_id
     *
     * @param partnerId the value for tm_member_identity.partner_id
     *
     * @mbg.generated
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tm_member_identity.create_time
     *
     * @return the value of tm_member_identity.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tm_member_identity.create_time
     *
     * @param createTime the value for tm_member_identity.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}