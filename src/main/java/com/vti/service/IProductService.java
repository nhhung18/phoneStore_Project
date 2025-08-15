package com.vti.service;

import com.vti.dto.productDto;
import com.vti.entity.product;
import com.vti.form.createProductForm;
import com.vti.form.updateProductForm;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IProductService {
    public Page<productDto> getAllProduct(Pageable pageable);

    productDto getProductById(short id);

    void deleteProductById(short id);

    void updateProductById(short id, updateProductForm form) throws Exception;

    void createProduct(createProductForm form) throws Exception;
}
