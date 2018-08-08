package com.sboot.test5;

import java.util.Date;

public class Course {

    private String courseId;
    private String courseName;
    private double coursePrice;
    private Date createTime;

    public Course(String courseId, String courseName, double coursePrice, Date createTime) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.createTime = createTime;
    }

    public Course(String courseName, double coursePrice, Date createTime) {
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.createTime = createTime;
    }

    public Course(String courseName, double coursePrice) {
        this.courseName = courseName;
        this.coursePrice = coursePrice;
    }

    public Course() {

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
