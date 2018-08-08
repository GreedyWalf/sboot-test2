package com.sboot.test5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl {

    @Autowired
    private CourseMapper courseMapper;

    /**
     * springBoot支持声明式事务，直接在service中使用@Transaction注解即可
     */
    @Transactional
    public void transfer(){
        Course course = courseMapper.getCourseByCourseName("张三").get(0);
        course.setCoursePrice(10000);
        courseMapper.update(course);
        int i = 1/0;
        course.setCoursePrice(10000+1);
        courseMapper.update(course);
    }
}
