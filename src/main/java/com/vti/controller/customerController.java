package com.vti.controller;

import com.vti.dto.customerDto;
import com.vti.dto.productDto;
import com.vti.entity.customer;
import com.vti.form.createCustomerForm;
import com.vti.form.createProductForm;
import com.vti.form.updateCustomerForm;
import com.vti.form.updateProductForm;
import com.vti.service.ICustomerService;
import com.vti.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin("*")
public class customerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> getAllCustomer(Pageable pageable) {
        return new ResponseEntity<>(customerService.getAllCustomer(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable(name = "id") short id) {
        customerService.deleteCustomerById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable(name = "id") short id, @RequestBody updateCustomerForm form) throws Exception{
        customerService.updateCustomerById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createCustomerById(@RequestBody createCustomerForm form) throws Exception{
        customerService.createCustomer(form);
        return new ResponseEntity<String>("Tao khach hang thanh cong", HttpStatus.OK);
    }

}
