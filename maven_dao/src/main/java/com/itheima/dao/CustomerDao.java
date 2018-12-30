package com.itheima.dao;

import com.itheima.domain.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project:maven_Test
 * Package: com.itheima.dao
 * Author: yanle
 * Date: 2018/12/27
 * Version: 1.0
 * Time:10:26
 */
@Repository
public interface CustomerDao {

    //查询所有用户
    @Select("select * from cst_customer")
    @Results({
            @Result(id = true, column = "cust_id", property = "custId"),
            @Result(column = "cust_name", property = "custName"),
            @Result(column = "cust_source", property = "custSource"),
            @Result(column = "cust_industry", property = "custIndustry"),
            @Result(column = "cust_level", property = "custLevel"),
            @Result(column = "cust_address", property = "custAddress"),
            @Result(column = "cust_phone", property = "custPhone")
    })
    List<Customer> findAllCustomer();

    //根据id查询用户
    @Select("select * from cst_customer where cust_id=#{custId}")
    @Results({
            @Result(id = true, column = "cust_id", property = "custId"),
            @Result(column = "cust_name", property = "custName"),
            @Result(column = "cust_source", property = "custSource"),
            @Result(column = "cust_industry", property = "custIndustry"),
            @Result(column = "cust_level", property = "custLevel"),
            @Result(column = "cust_address", property = "custAddress"),
            @Result(column = "cust_phone", property = "custPhone")
    })
    Customer findById(Long custId);

    //根据id查询出来用户后进行修改用户信息
    @Update("update cst_customer set  cust_name=#{custName},cust_source=#{custSource}," +
            "cust_industry=#{custIndustry},cust_level=#{custLevel},cust_address=#{custAddress},cust_phone=#{custPhone}where cust_id=#{custId}")
    void updateCustomer(Customer customer);

    //添加新增用户
    @Insert("insert into cst_customer values(null,#{custName},#{custSource},#{custIndustry},#{custLevel},#{custAddress},#{custPhone})")
    void saveCustomer(Customer customer);

    //删除用户
    @Delete("delete from cst_customer where cust_id=#{custId}")
    void deleteById(Long custId);
}
