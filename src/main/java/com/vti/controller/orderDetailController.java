package com.vti.controller;

import com.vti.dto.orderDetailDto;
import com.vti.dto.supProDto;
import com.vti.entity.orderDetail;
import com.vti.entity.supPro;
import com.vti.form.createOrderDetailForm;
import com.vti.form.updateOrderDetailForm;
import com.vti.service.ISupProService;
import com.vti.service.IorderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("orderDetail")
@CrossOrigin("*")
public class orderDetailController {
    @Autowired
    private IorderDetailService orderDetailService;

    @GetMapping()
    public ResponseEntity<?> getAllOrderDetail(Pageable pageable) {
        return new ResponseEntity<>(orderDetailService.getAllOrderDetail(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOrderDetailById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(orderDetailService.getOrderDetailById(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOrderDetailById(@PathVariable(name = "id") short id) {
        orderDetailService.deleteOrderDetailById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateOrderDetailById(@PathVariable(name = "id") short id, @RequestBody updateOrderDetailForm form) throws Exception{
        orderDetailService.updateOrderDetailById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createOrderDetail(@RequestBody createOrderDetailForm form) throws Exception {
        orderDetailService.createOrderDetail(form);
        return new ResponseEntity<String>("Tao don hang chi tiet thanh cong", HttpStatus.OK);
    }
}
