package com.vti.controller;

import com.vti.dto.customerDto;
import com.vti.dto.productDto;
import com.vti.entity.customer;
import com.vti.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin("*")
public class customerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> getAllCustomer() {
        List<customer> entities = customerService.getAllCustomer();
        List<customerDto> dtos = new ArrayList<>();

        for (customer cus : entities) {
            customerDto dto = new customerDto(cus.getId(), cus.getEmail(), cus.getUsername(), cus.getFullname(), cus.getAndress(), cus.getPhone_num(), cus.getCreateDate());
            dtos.add(dto);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
