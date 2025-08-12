package com.vti.service;

import com.vti.entity.product;
import com.vti.form.updateProductForm;

import java.util.List;

public interface IProductService {
    public List<product> getAllProduct();

    product getProductById(short id);

    void deleteProductById(short id);

    void updateProductById(short id, updateProductForm form);
}
