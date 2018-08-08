package com.sboot.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao implements ICustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Customer customer) {
        return jdbcTemplate.update("insert into t_customer(customer_id,customer_name) values(?,?)", customer.getCustomerId(), customer.getCustomerName());
    }

    @Override
    public int update(Customer customer) {
        return jdbcTemplate.update("update t_customer set customer_name=? where customer_id=?", customer.getCustomerName(), customer.getCustomerId());
    }

    @Override
    public int delete(String id) {
        return jdbcTemplate.update("delete from t_customer where customer_id=?", id);
    }

    @Override
    public Customer findCustomerById(String id) {
        List<Customer> list = jdbcTemplate.query("select * from t_customer where customer_id = ?", new Object[]{id}, new BeanPropertyRowMapper(Customer.class));
        if (list != null && list.size() > 0) {
            Customer customer = list.get(0);
            return customer;
        } else {
            return null;
        }
    }

    @Override
    public List<Customer> findCustomerList() {
        List<Customer> list = jdbcTemplate.query("select * from t_customer", new Object[]{}, new BeanPropertyRowMapper(Customer.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
