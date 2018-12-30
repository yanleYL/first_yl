package com.itheima.controller;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Project:maven_Test
 * Package: com.itheima.controller
 * Author: yanle
 * Date: 2018/12/27
 * Version: 1.0
 * Time:9:38
 */
@Controller
@RequestMapping("/customer")
public class TestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/findAllCustomer")
    public String findAllCustomer(Model model) {
        List<Customer> customers = customerService.findAllCustomer();
        model.addAttribute("customers", customers);
        return "/list";
    }

    //根据id查询customer
    @RequestMapping("/findById")
    public String findById(Long custId, Model model ){
        Customer customer=customerService.findById(custId);
        model.addAttribute("customer",customer);
        return "/edit";
    }

    //修改
    @RequestMapping("/updateCustomer")
    public String updateCustomer(Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/customer/findAllCustomer";
    }

    //添加新增用户页面跳转
    @RequestMapping("/addUI")
    public  String  addUI(){
        return "add";
    }

    //添加新增用户
    @RequestMapping("/addCustomer")
    public String addCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/findAllCustomer";
    }

    //删除用户
    @RequestMapping("/deleteById")
    public  String deleteById(Long custId){
        customerService.deleteById(custId);
        return "redirect:/customer/findAllCustomer";
    }
}
