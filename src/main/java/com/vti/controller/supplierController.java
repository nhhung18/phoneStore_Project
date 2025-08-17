package com.vti.controller;

import com.vti.dto.customerDto;
import com.vti.dto.supplierDto;
import com.vti.entity.customer;
import com.vti.entity.supplier;
import com.vti.form.createCustomerForm;
import com.vti.form.createSupplierForm;
import com.vti.form.updateCustomerForm;
import com.vti.form.updateSupplierForm;
import com.vti.service.ICustomerService;
import com.vti.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("supplier")
@CrossOrigin("*")
public class supplierController {

    @Autowired
    private ISupplierService supplierService;

    @GetMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getAllSupplier(Pageable pageable) {
        return new ResponseEntity<>(supplierService.getAllSupplier(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getSupplierById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(supplierService.getSupplierById(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> deleteSupplierById(@PathVariable(name = "id") short id) {
        supplierService.deleteSupplierById(id);
        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> updateSupplierById(@PathVariable(name = "id") short id, @RequestBody updateSupplierForm form) throws Exception{
        supplierService.updateSupplierById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> createCustomerById(@RequestBody createSupplierForm form) throws Exception{
        supplierService.createSupplier(form);
        return new ResponseEntity<String>("Tao nha cung cap thanh cong", HttpStatus.OK);
    }

}
