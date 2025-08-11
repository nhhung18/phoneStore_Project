package com.vti.service;

import com.vti.entity.customer;
import com.vti.repository.ICustomerRepository;
import com.vti.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class customerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<customer> getAllCustomer(){
        return customerRepository.findAll();
    }
}
