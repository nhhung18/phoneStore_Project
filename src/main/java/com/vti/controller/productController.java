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
        return new ResponseEntity<>(productService.getAllProduct(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable(name = "id") short id) {
        productService.deleteProductById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable(name = "id") short id, @RequestBody updateProductForm form)throws Exception{
        productService.updateProductById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody createProductForm form) throws Exception{
        productService.createProduct(form);
        return new ResponseEntity<String>("Tao san pham thanh cong", HttpStatus.OK);
    }
}
