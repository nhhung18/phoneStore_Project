package com.vti.controller;

import com.vti.form.*;
import com.vti.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("customer")
@CrossOrigin("*")
public class customerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<?> getAllCustomer(Pageable pageable) {
        return new ResponseEntity<>(customerService.getAllCustomer(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getCustomerById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> deleteCustomerById(@PathVariable(name = "id") short id) {
        customerService.deleteCustomerById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<?> updateProductById(@PathVariable(name = "id") short id, @RequestBody updateCustomerForm form) throws Exception{
        customerService.updateCustomerById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> createCustomerById(@RequestBody createCustomerForm form) throws Exception{
        customerService.createCustomer(form);
        return new ResponseEntity<String>("Tao khach hang thanh cong", HttpStatus.OK);
    }

    @PostMapping(value = "register")
    public ResponseEntity<?> RegisterAccount(@RequestBody customerFormForRegister form) throws Exception {
        customerService.registerCustomer(form);
        return new ResponseEntity<>("Dang ky thanh cong", HttpStatus.OK);
    }

}
