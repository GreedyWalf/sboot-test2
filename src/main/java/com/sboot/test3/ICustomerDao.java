package com.sboot.test3;

import java.util.List;

public interface ICustomerDao {
    int add(Customer customer);

    int update(Customer customer);

    int delete(String id);

    Customer findCustomerById(String id);

    List<Customer> findCustomerList();
}
