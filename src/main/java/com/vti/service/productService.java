package com.vti.service;

import com.vti.entity.product;
import com.vti.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<product> getAllProduct() {
        return productRepository.findAll();
    }
}
