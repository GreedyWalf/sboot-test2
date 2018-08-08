package com.sboot.test4;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "t_employee")
@Entity
public class Employee {

    @Id
    @GenericGenerator(name = "my-uuid", strategy = "uuid")
    @GeneratedValue(generator = "my-uuid")
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    public Employee() {
    }

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
