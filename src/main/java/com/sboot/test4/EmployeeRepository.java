package com.sboot.test4;

import com.sboot.test3.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findByEmployeeName(String empName);

}
