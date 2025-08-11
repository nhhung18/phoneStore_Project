package com.vti.controller;


import com.vti.dto.productDto;
import com.vti.entity.product;
import com.vti.service.IProductService;
import com.vti.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "product")
@CrossOrigin("*")
public class productController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public ResponseEntity<?> getAllProduct(){
        List<product> entities = productService.getAllProduct();
        List<productDto> dtos = new ArrayList<>();

        for(product pro : entities){
            productDto dto = new productDto(pro.getId(), pro.getName(), pro.getPrice(), pro.getStockQuantity(), pro.getCapacity(), pro.getColor());
            dtos.add(dto);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }



}
