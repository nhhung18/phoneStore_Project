package com.vti.service;

import com.vti.entity.product;
import com.vti.form.createProductForm;
import com.vti.form.updateProductForm;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IProductService {
    public Page<product> getAllProduct(Pageable pageable);

    product getProductById(short id);

    void deleteProductById(short id);

    void updateProductById(short id, updateProductForm form);

    void createProductById(createProductForm form);
}
