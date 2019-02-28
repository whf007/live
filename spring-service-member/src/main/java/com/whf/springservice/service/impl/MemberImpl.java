package com.whf.springservice.service.impl;

import com.whf.springservice.MemberFacade;
import com.whf.springservice.common.enums.MemberType;
import com.whf.springservice.common.vo.*;
import com.whf.springservice.dao.entity.*;
import com.whf.springservice.dao.entity.ext.MemberDetailInfo;
import com.whf.springservice.dao.entity.ext.RolePermissionMember;
import com.whf.springservice.dao.entity.ext.SysRoleMember;
import com.whf.springservice.dao.entity.ext.SysUserRoleMember;
import com.whf.springservice.dao.mapper.*;
import com.whf.springservice.model.MemberIdentity;
import com.whf.springservice.model.MemberInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Raden-pc on 2019/1/3.
 */
@Service
@WebService(serviceName = "MemberFacade", // 与接口中指定的name一致
        targetNamespace = "http://springservice.whf.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.whf.springservice.MemberFacade"// 接口地址
)
public class MemberImpl implements MemberFacade {
    @Autowired
    TmMemberIdentityMapper memberIdentityMapper;
    @Autowired
    TmMemberMapper tmMemberMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SequenceMapper sequenceMapper;
    @Override
    public MemberIdentity findOne(String identityId, String identityType) {
        TmMemberIdentity identity = new TmMemberIdentity();
        identity.setIdentityId(identityId);
        identity.setIdentityType(identityType);
        TmMemberIdentity tmMemberIdentity = memberIdentityMapper.selectOne(identity);
        if(tmMemberIdentity != null) {
            MemberIdentity memberIdentity = new MemberIdentity();
            BeanUtils.copyProperties(tmMemberIdentity,memberIdentity);
            return memberIdentity;
        }
        return null;
    }

    @Override
    public Boolean findMember(String memberId, String password) {
        TmMember memberInfo = new TmMember();
        memberInfo.setMemberId(memberId);
        memberInfo.setPassword(password);
        TmMember tmMember = tmMemberMapper.selectOne(memberInfo);
        if(tmMember !=null) {
            return true;
        }
        return false;
    }
    @Override
    public MemberInfo findMemberInfo(String memberId) {
        TmMember tmMember = new TmMember();
        tmMember.setMemberId(memberId);
        tmMember = tmMemberMapper.selectOne(tmMember);
        if(tmMember!=null) {
            MemberInfo member = new MemberInfo();
            BeanUtils.copyProperties(tmMember,member);
            return member;
        }
        return null;
    }


    @Override
    public UserInfo findMemberDetail(UserInfo userInfo) {
        // 查询用户信息和密码信息
        TmMemberIdentity identity = new TmMemberIdentity();
        identity.setIdentityId(userInfo.getIdentityId());
        identity.setIdentityType(userInfo.getIdentityType());
//        TmMemberIdentity tmMemberIdentity = memberIdentityMapper.selectOne(identity);
        MemberDetailInfo memberDetailInfo = memberIdentityMapper.selectMemberDetail(identity);
        if(memberDetailInfo != null) {

            TmMember memberInfo = new TmMember();
            memberInfo.setMemberId(memberDetailInfo.getMemberId());
            TmMember tmMember = tmMemberMapper.selectOne(memberInfo);
            userInfo.setPassword(tmMember.getPassword());
            userInfo.setState(tmMember.getStatus());
            userInfo.setMemberId(tmMember.getMemberId());
            userInfo.setMemberName(tmMember.getMemberName());
            userInfo.setSalt(tmMember.getSalt());
            return convertToMemberDetail(memberDetailInfo,userInfo);
        }
        return null;
    }

    @Override
    @Transactional
    public String saveUser(UserInfo userInfo) {
        TmMemberIdentity memberIdentity = new TmMemberIdentity();
        String memberId = sequenceMapper.nextval();
        memberIdentity.setIdentityType(userInfo.getIdentityType());
        memberIdentity.setIdentityId(userInfo.getIdentityId());
        memberIdentity.setPidId(userInfo.getPid());
        memberIdentity.setPartnerId(userInfo.getPartnerId());
        memberIdentity.setMemberId(memberId);
        memberIdentity.setCreateTime(new Date());
        int identityCount = memberIdentityMapper.insert(memberIdentity);
        if(identityCount == 1) {
            // 添加用户信息
            TmMember tmMember = new TmMember();
            tmMember.setMemberId(userInfo.getMemberId());
            tmMember.setPassword(userInfo.getPassword());
            tmMember.setSalt(userInfo.getSalt());
            tmMember.setMemberId(memberId);
            tmMember.setStatus("1");
            tmMember.setMemberName(userInfo.getMemberName());
            tmMember.setType(userInfo.getIdentityType());
            tmMember.setPidId(userInfo.getPid());
            tmMember.setTeacherType(userInfo.getTeacherType() !=null ? userInfo.getTeacherType().getCode():null);
            tmMember.setCreateTime(new Date());
            tmMemberMapper.insert(tmMember);
            // 权限插入
            List<Role> roleList = userInfo.getRoleList();
            for(Role role : roleList) {
                Integer id = role.getId();
                SysUserRole userRole = new SysUserRole();
                userRole.setMemberId(memberId);
                userRole.setRoleId(id);
                sysUserRoleMapper.insert(userRole);
            }

        }
        return memberId;
    }

    public UserInfo convertToMemberDetail(MemberDetailInfo memberIdentity,UserInfo userInfo) {
        List<Role> roles = new ArrayList<>();
        List<SysUserRoleMember> userRoleList = memberIdentity.getUserRoleList();
        for(SysUserRoleMember userRole: userRoleList){
            List<SysRoleMember> rolesList = userRole.getRoles();
            for(SysRoleMember sysRoleMember: rolesList) {
                Role role = new Role();
                role.setAvailable(sysRoleMember.getAvailable());
                role.setDescription(sysRoleMember.getDescription());
                role.setId(sysRoleMember.getId());
                role.setRole(sysRoleMember.getRole());
                // 用户权限信息
                List<RolePermissionMember> permissionMembers = sysRoleMember.getPermissionMembers();
                List<SysPermissionInfo> permissions = new ArrayList<>();
                for(RolePermissionMember rolePermissionMember : permissionMembers) {
                    SysPermissionInfo sysPermissionInfo = new SysPermissionInfo();
                    for(SysPermission sysPermission : rolePermissionMember.getPermissions()) {
                        sysPermissionInfo.setAvailable(sysPermission.getAvailable());
                        sysPermissionInfo.setId(sysPermission.getId());
                        sysPermissionInfo.setName(sysPermission.getName());
                        sysPermissionInfo.setParentId(sysPermission.getParentId());
                        sysPermissionInfo.setParentIds(sysPermission.getParentIds());
                        sysPermissionInfo.setPermission(sysPermission.getPermission());
                        sysPermissionInfo.setResourceType(sysPermission.getResourceType());
                        sysPermissionInfo.setUrl(sysPermission.getUrl());
                        permissions.add(sysPermissionInfo);
                    }
                }
                role.setPermissions(permissions);
                roles.add(role);
            }
        }
        userInfo.setRoleList(roles);
        return userInfo;
    }
}