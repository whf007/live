package com.whf.springservice.service.impl;

import com.whf.springservice.CourseFacade;
import com.whf.springservice.common.util.OrderNoGenerator;
import com.whf.springservice.common.util.RandomNumberUtils;
import com.whf.springservice.dao.entity.*;
import com.whf.springservice.dao.mapper.*;
import com.whf.springservice.model.CourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;

/**
 * Created by Raden-pc on 2019/1/3.
 */
@Service
@WebService(serviceName = "CourseFacade", // 与接口中指定的name一致
        targetNamespace = "http://springservice.whf.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.whf.springservice.CourseFacade"// 接口地址
)
@Slf4j
public class CourseImpl implements CourseFacade {
    @Autowired
    TmCourseMapper tmCourseMapper;
    @Autowired
    TmMemberMapper tmMemberMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;
    @Autowired
    SequenceMapper sequenceMapper;
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public String addCourse(CourseInfo courseInfo) {
        TmCourse course = new TmCourse();
        BeanUtils.copyProperties(courseInfo,course);
        // 生成课程id
        OrderNoGenerator generator = new OrderNoGenerator(200, 6);
        String randomRecordNumber = RandomNumberUtils.getRandomRecordNumber(generator.generatorOrderNo());
        course.setCourseId(randomRecordNumber );
        int insert =0;
        try {
            insert = tmCourseMapper.insert(course);
        } catch (DuplicateKeyException e){
            log.error("课程创建订单号重复异常:{}",e);
            // 可能时订单号重复，重新生成新订单号
            generator = new OrderNoGenerator(200, 6);
            randomRecordNumber = RandomNumberUtils.getRandomRecordNumber( generator.generatorOrderNo());
            course.setCourseId(randomRecordNumber + course.getMemberId());
            insert = tmCourseMapper.insert(course);
        } catch (Exception e){
            log.error("课程创建异常:{}",e);
        }
        if(insert == 1) {
            return randomRecordNumber.substring(0,12);
        }
        return null;
    }

    @Override
    public CourseInfo queryCourse(CourseInfo courseInfo) {
        TmCourse course = new TmCourse();
        course.setCourseId(courseInfo.getCourseId());
        TmCourse tmCourse = tmCourseMapper.selectByPrimaryKey(course);
        BeanUtils.copyProperties(tmCourse,courseInfo);
        return courseInfo;
    }


}