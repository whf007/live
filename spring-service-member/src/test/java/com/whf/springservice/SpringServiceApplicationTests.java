package com.whf.springservice;

import com.whf.springservice.common.util.RandomNumberUtils;
import com.whf.springservice.common.vo.UserInfo;
import com.whf.springservice.dao.entity.TmCourse;
import com.whf.springservice.model.CourseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringServiceApplicationTests {
	@Autowired
	MemberFacade memberFacade;
	@Autowired
	CourseFacade courseFacade;
	@Test
	public void contextLoads() {
	}
	@Test
	public void test(){
		UserInfo userInfo = new UserInfo();
		userInfo.setIdentityId("test1");
		userInfo.setIdentityType("1");
		memberFacade.findMemberDetail(userInfo);
	}
	@Test
	public void addCourse(){
	    for(int i  = 0;i<100;i++) {
            new Thread(new Course(courseFacade,i)).run();
        }
    }
}
class Course implements Runnable{
    private CourseFacade courseFacade;
    private int count;
    public Course(CourseFacade courseFacade,int count){
        this.courseFacade = courseFacade;
        this.count = count;
    }
    @Override
    public void run() {
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setMemberId("1000000001");
        courseInfo.setCourseName("测试客车给");
        courseInfo.setCourseTime(new Date());
        courseInfo.setLable("测试" + count);
        courseInfo.setTeacherType("1");
        String s = courseFacade.addCourse(courseInfo);
        System.out.println(s + "---" + count);
    }
}
