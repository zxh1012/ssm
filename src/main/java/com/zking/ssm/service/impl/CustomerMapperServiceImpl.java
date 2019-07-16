package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.CustomerMapper;
import com.zking.ssm.model.Customer;
import com.zking.ssm.service.ICustomerMapperService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerMapperServiceImpl implements ICustomerMapperService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public int add(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public int del(Customer customer) {
        return customerMapper.deleteByPrimaryKey(customer.getCustomerId());
    }

    @Override
    public int edit(Customer customer) {
        return customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public Customer load(Customer customer) {
        return customerMapper.selectByPrimaryKey(customer.getCustomerId());
    }

    @Override
    public Customer loadCasecode(Customer customer) {
        return customerMapper.loadCasecode(customer.getCustomerId());
    }


    @Override
    public List<Customer> list(Customer customer, PageBean pageBean) {
        return customerMapper.list(customer);
    }
}
