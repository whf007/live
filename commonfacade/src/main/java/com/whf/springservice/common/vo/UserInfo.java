package com.whf.springservice.common.vo;

import com.whf.springservice.common.enums.MemberType;
import com.whf.springservice.common.enums.TeacherType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@ToString
public class UserInfo implements Serializable {
    private String memberId;
    private String identityId;//帐号
    private String identityType;//账户类型
    private String memberName;//名称（昵称或者真实姓名，不同系统不同定义）
    private String password; //密码;
    private String salt;//加密密码的盐
    private String state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    private Integer pid = 1;
    private String partnerId = "18888888888";
    private MemberType memberType;
    private TeacherType teacherType;
    private List<Role> roleList;// 一个用户具有多个角色

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.identityId+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}