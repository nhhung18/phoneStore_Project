package com.vti.controller;

import com.vti.dto.orderDto;
import com.vti.dto.productDto;
import com.vti.entity.order;
import com.vti.entity.product;
import com.vti.form.createOrderForm;
import com.vti.form.updateOrderForm;
import com.vti.service.IProductService;
import com.vti.service.IorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin("*")
public class orderController {
    @Autowired
    private IorderService orderService;

    @GetMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> getAllOrder(Pageable pageable) {
        return new ResponseEntity<>(orderService.getAllOrder(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<?> getOrderById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> deleteOrderById(@PathVariable(name = "id") short id) {
        orderService.deleteOrderById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> updateOrderById(@PathVariable(name = "id") short id, @RequestBody updateOrderForm form) throws Exception{
        orderService.updateOrderById(id, form);
        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> createOrder(@RequestBody createOrderForm form) throws Exception{
        orderService.createOrder(form);
        return new ResponseEntity<String>("Tao don hang thanh cong", HttpStatus.OK);
    }
}
