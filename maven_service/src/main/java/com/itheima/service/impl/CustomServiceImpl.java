package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:maven_Test
 * Package: com.itheima.service.impl
 * Author: yanle
 * Date: 2018/12/27
 * Version: 1.0
 * Time:10:19
 */
@Service
public class CustomServiceImpl implements CustomerService {
    @Autowired
   private CustomerDao customerDao;
    @Override
    public List<Customer> findAllCustomer() {

        return customerDao.findAllCustomer();
    }

    @Override
    public Customer findById(Long custId) {

        return customerDao.findById(custId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public void deleteById(Long custId) {
        customerDao.deleteById(custId);
    }
}
