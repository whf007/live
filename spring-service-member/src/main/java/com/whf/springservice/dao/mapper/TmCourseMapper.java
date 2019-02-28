package com.whf.springservice.dao.mapper;

import com.whf.springcloud.common.dao.CrudMapper;
import com.whf.springservice.dao.entity.TmCourse;
import com.whf.springservice.dao.entity.TmCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TmCourseMapper extends CrudMapper<TmCourse> {
    public TmCourse selectOrderByDate();
}