package com.zking.ssm.service;

import com.zking.ssm.model.Customer;
import com.zking.ssm.model.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ICustomerMapperServiceTest extends BaseTestCase {
    @Autowired
    private ICustomerMapperService customerMapperService;

    private Customer customer;
    @Override
    public void before() {
        super.before();
        customer = new Customer();
    }

    @Test
    public void add()throws Exception {
    }

    @Test
    public void del() throws Exception{
    }

    @Test
    public void edit() throws Exception{
    }

    @Test
    public void load() throws Exception{
        customer.setCustomerId(4);
        Customer c = customerMapperService.load(customer);
//        Customer c = customerMapperService.loadCasecode(customer);
        System.out.println(c);

        for (Order o:c.getOrderList()){
            System.out.println(o);
        }
    }

    @Test
    public void list() throws Exception{
    }
}