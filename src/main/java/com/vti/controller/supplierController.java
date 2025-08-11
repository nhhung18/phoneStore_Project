package com.vti.controller;

import com.vti.dto.customerDto;
import com.vti.dto.supplierDto;
import com.vti.entity.customer;
import com.vti.entity.supplier;
import com.vti.service.ICustomerService;
import com.vti.service.ISupplierService;
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
@RequestMapping("supplier")
@CrossOrigin("*")
public class supplierController {

    @Autowired
    private ISupplierService supplierService;

    @GetMapping()
    public ResponseEntity<?> getAllCustomer() {
        List<supplier> entities = supplierService.getAllCustomer();
        List<supplierDto> dtos = new ArrayList<>();

        for (supplier sup : entities) {
            supplierDto dto = new supplierDto(sup.getId(),sup.getEmail(), sup.getName(), sup.getAndress(), sup.getPhoneNum(), sup.getCreateDate());
            dtos.add(dto);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
