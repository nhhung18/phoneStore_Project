package com.vti.service;

import com.vti.entity.product;
import com.vti.form.updateProductForm;
import com.vti.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.AccessibleObject;
import java.util.List;

@Service
public class productService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public product getProductById(short id) {
        return productRepository.getById(id);
    }

    ;

    @Override
    public void deleteProductById(short id) {
        productRepository.deleteById(id);
    }

    ;

    @Override
    public void updateProductById(short id, updateProductForm form) {
        product product = productRepository.getById(id);
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setStockQuantity(form.getStock_quantity());
        product.setCapacity(form.getCapacity());
        product.setColor(form.getColor());
    }

    ;
}
