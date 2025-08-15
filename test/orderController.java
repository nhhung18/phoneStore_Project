package com.vti.controller;


import com.vti.dto.orderDto;
import com.vti.entity.order;
import com.vti.form.createOrderForm;
import com.vti.form.updateOrderForm;
import com.vti.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@RestController
@RequestMapping(value = "order")
@CrossOrigin("*")
public class orderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping()
    public ResponseEntity<?> getAllOrder(Pageable pageable) {
        return new ResponseEntity<>(orderService.getAllOrder(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable(name = "id") short id) {
        orderService.deleteOrderById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateOrderById(@PathVariable(name = "id") short id, @RequestBody updateOrderForm form){
        orderService.updateOrderById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createOrder(@RequestBody createOrderForm form){
        orderService.createOrder(form);
        return new ResponseEntity<String>("Tao san pham thanh cong", HttpStatus.OK);
    }
}
