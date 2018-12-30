package com.itheima.service;

import com.itheima.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:maven_Test
 * Package: com.itheima.service
 * Author: yanle
 * Date: 2018/12/27
 * Version: 1.0
 * Time:10:18
 */

public interface CustomerService {


    List<Customer> findAllCustomer();

    Customer findById(Long custId);

    void updateCustomer(Customer customer);

    void saveCustomer(Customer customer);

    void deleteById(Long custId);
}
