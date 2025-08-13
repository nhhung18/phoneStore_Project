package com.vti.controller;


import com.vti.dto.productDto;
import com.vti.entity.product;
import com.vti.form.createProductForm;
import com.vti.form.updateProductForm;
import com.vti.service.IProductService;
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
@RequestMapping(value = "product")
@CrossOrigin("*")
public class productController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public ResponseEntity<?> getAllProduct(Pageable pageable) {
//        Page<product> entities = productService.getAllProduct(pageable);
        Page<product> entities =  productService.getAllProduct(pageable);
        Page<productDto> dtoPage = entities.map(new Function<product, productDto>(){
            @Override
            public productDto apply(product product){

                productDto dto = new productDto(product.getId(), product.getName(),product.getPrice(), product.getStockQuantity(), product.getCapacity(), product.getColor());
                return dto;
            }
        });

        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
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

    @PostMapping()
    public ResponseEntity<?> createProductById(@RequestBody createProductForm form){
        productService.createProductById(form);

        return new ResponseEntity<String>("Tao san pham thanh cong", HttpStatus.OK);
    }
}
