package com.vti.controller;

import com.vti.dto.orderDetailDto;
import com.vti.dto.supProDto;
import com.vti.entity.orderDetail;
import com.vti.entity.supPro;
import com.vti.service.ISupProService;
import com.vti.service.IorderDetailService;
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
@RequestMapping("orderDetail")
@CrossOrigin("*")
public class orderDetailController {
    @Autowired
    private IorderDetailService orderDetailService;

    @GetMapping()
    public ResponseEntity<?> getOrderDetail() {
        List<orderDetail> entities = orderDetailService.getSupPro();
        List<orderDetailDto> dtos = new ArrayList<>();

        for (orderDetail oD: entities) {
            orderDetailDto dto = new orderDetailDto(oD.getOrderDetailId(), oD.getOrder(), oD.getProduct(), oD.getQuantity(), oD.getPrice(), oD.getTotalPrice());
            dtos.add(dto);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
