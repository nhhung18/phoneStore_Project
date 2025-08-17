package com.vti.controller;

import com.vti.repository.ICustomerRepository;
import com.vti.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
@CrossOrigin("*")
public class customerRegisterController {
    @Autowired
    private ICustomerService customerService;

}
