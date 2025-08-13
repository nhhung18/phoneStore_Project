package com.vti.service;

import com.vti.entity.product;
import com.vti.form.createProductForm;
import com.vti.form.updateProductForm;
import com.vti.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.lang.reflect.AccessibleObject;
import java.util.List;

@Service
public class productService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
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
        if (form.getName() != null) product.setName(form.getName());
        if (form.getPrice() != null) product.setPrice(form.getPrice());
        if (form.getStock_quantity() != null) product.setStockQuantity(form.getStock_quantity());
        if (form.getCapacity() != null) product.setCapacity(form.getCapacity());
        if (form.getColor() != null) product.setColor(form.getColor());
        productRepository.save(product);
    }

    @Override
    public void createProductById(createProductForm form){
        product product = new product();
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setStockQuantity(form.getStock_quantity());
        product.setCapacity(form.getCapacity());
        product.setColor(form.getColor());
        productRepository.save(product);

    };
}
