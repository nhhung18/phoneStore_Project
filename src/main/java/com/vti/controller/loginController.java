package com.vti.controller;

import com.vti.dto.loginDto;
import com.vti.entity.customer;
import com.vti.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("login")
@CrossOrigin("*")
public class loginController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> login(Principal principal){
        String username = principal.getName();
        customer entity = customerService.getLoginByUsername(username);
        loginDto dto = new loginDto(entity.getId(), entity.getFullname());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
