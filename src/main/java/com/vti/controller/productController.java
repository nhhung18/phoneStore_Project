package com.vti.controller;


import com.vti.dto.productDto;
import com.vti.entity.product;
import com.vti.form.updateProductForm;
import com.vti.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "product")
@CrossOrigin("*")
public class productController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public ResponseEntity<?> getAllProduct() {
        List<product> entities = productService.getAllProduct();
        List<productDto> dtos = new ArrayList<>();

        for (product pro : entities) {
            productDto dto = new productDto(pro.getId(), pro.getName(), pro.getPrice(), pro.getStockQuantity(), pro.getCapacity(), pro.getColor());
            dtos.add(dto);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") short id) {
//        if(id < 1){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
//        }
        product product = productService.getProductById(id);
        productDto dto = new productDto(product.getId(), product.getName(), product.getPrice(), product.getStockQuantity(), product.getCapacity(), product.getColor());

        return new ResponseEntity<productDto>(dto, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable(name = "id") short id) {
        productService.deleteProductById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable(name = "id") short id, @RequestBody updateProductForm form){
        productService.updateProductById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }
}
