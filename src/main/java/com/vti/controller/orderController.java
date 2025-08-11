package com.vti.controller;

import com.vti.dto.orderDto;
import com.vti.dto.productDto;
import com.vti.entity.order;
import com.vti.entity.product;
import com.vti.service.IProductService;
import com.vti.service.IorderService;
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
@RequestMapping("order")
@CrossOrigin("*")
public class orderController {
    @Autowired
    private IorderService orderService;

    @GetMapping()
    public ResponseEntity<?> getAllProduct(){
        List<order> entities = orderService.getAllOrder();
        List<orderDto> dtos = new ArrayList<>();

        for(order od : entities){
            orderDto dto = new orderDto(od.getOrderId(), od.getCustomerId(), od.getCreateDate(), od.getPayingStatus(), od.getShipStatus());
            dtos.add(dto);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
