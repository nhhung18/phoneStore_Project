package com.vti.controller;


import com.vti.dto.orderdetailDto;
import com.vti.entity.orderdetail;
import com.vti.form.createOrderDetailForm;
import com.vti.form.updateOrderDetailForm;
import com.vti.service.IOrderDetailService;
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
@RequestMapping(value = "orderdetail")
@CrossOrigin("*")
public class orderdetailController {

    @Autowired
    private IOrderDetailService orderdetailService;

    @GetMapping()
    public ResponseEntity<?> getAllOrderDetail(Pageable pageable) {
        return new ResponseEntity<>(orderdetailService.getAllOrderDetail(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOrderDetailById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(orderdetailService.getOrderDetailById(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOrderDetailById(@PathVariable(name = "id") short id) {
        orderdetailService.deleteOrderDetailById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateOrderDetailById(@PathVariable(name = "id") short id, @RequestBody updateOrderDetailForm form){
        orderdetailService.updateOrderDetailById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createOrderDetail(@RequestBody createOrderDetailForm form){
        orderdetailService.createOrderDetail(form);
        return new ResponseEntity<String>("Tao san pham thanh cong", HttpStatus.OK);
    }
}
