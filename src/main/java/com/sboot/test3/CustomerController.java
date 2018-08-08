package com.sboot.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerDao customerDao;


    @RequestMapping(value = "/addCustomer")
    public String addCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId("123");
        customer.setCustomerName("qinyupeng");

        customerDao.add(customer);

        return "add success";
    }


    @RequestMapping(value = "/listCustomers")
    public String listCustomers() {
        List<Customer> customers = customerDao.findCustomerList();
        return "共" + customers.size() + "条记录~";
    }


    /**
     * http://localhost:8081/123
     *
     * @param customerId 将url路径中的123绑定到customerId参数中，根据customerId进行查询
     */
    @RequestMapping(value = "/{id}")
    public String getCustomer(@PathVariable("id") String customerId) {
        Customer customer = customerDao.findCustomerById(customerId);
        return customer.getCustomerName();
    }

    /**
     * http://localhost:8081/deleteCustomer?customerId=123
     *
     * @param customerId 查询字符串和参数绑定
     */
    @RequestMapping(value = "/deleteCustomer")
    public String delete(String customerId) {
        int delete = customerDao.delete(customerId);
        return delete > 0 ? "删除成功" : "删除失败";
    }
}
