package com.sboot;

import com.sboot.test5.Course;
import com.sboot.test5.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private CourseMapper courseMapper;


    @Test
    public void test() throws Exception {
        String courseId = UUID.randomUUID().toString().replaceAll("-", "");
        Course course = new Course(courseId, "张三", 200.0, new Date());
        courseMapper.insert(course);

        List<Course> courseList = courseMapper.getCourseByCourseName("张三");
        System.out.println("---->>>>courseList.size=" + courseList.size());

        Course courseFromDB = courseMapper.getCourseByCourseId(courseList.get(0).getCourseId());
        System.out.println("---->>>course.courseName=" + course.getCourseName());
    }
}
