package com.sboot.test5;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CourseMapper {

    int insert(Course course);

    int insert(@Param("courseName") String courseName, @Param("coursePrice") double coursePrice,
               @Param("createTime") Date createTime);

    /**
     * 如果数据库字段和实体属性名不一致，查询时需要指定属性和字段名之间映射关系，否则返回的结果集对象中就没有对应属性值了。
     */
    @Select("SELECT * FROM t_course WHERE course_name=#{courseName}")
    @Results({
            @Result(property = "courseId", column = "course_id", javaType = String.class),
            @Result(property = "courseName", column = "course_name", javaType = String.class),
            @Result(property = "coursePrice", column = "course_price", javaType = Double.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class)
    })
    List<Course> getCourseByCourseName(String courseName);

    Course getCourseByCourseId(String courseId);

    int delete(String courseId);

    @Update("UPDATE t_course set course_name=#{courseName},course_price=#{coursePrice},create_time=#{createTime} " +
            "WHERE course_id=#{courseId}")
    int update(Course course);
}
