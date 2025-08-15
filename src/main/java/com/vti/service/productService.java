package com.vti.service;

import com.vti.dto.productDto;
import com.vti.entity.product;
import com.vti.form.createProductForm;
import com.vti.form.updateProductForm;
import com.vti.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.lang.reflect.AccessibleObject;
import java.util.List;
import java.util.function.Function;

@Service
public class productService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<productDto> getAllProduct(Pageable pageable) {
        // Lấy dữ liệu theo phân trang
        Page<product> products = productRepository.findAll(pageable);
        Page<productDto> productDtos = products.map(new Function<product,productDto>() {
            @Override
            public productDto apply(product product) {
                productDto productDto = mapper.map(product, productDto.class);
                return productDto;
            }
        });
        return productDtos;
    }

    @Override
    public productDto getProductById(short id) {
        product entities = productRepository.getById(id);
        productDto dto = mapper.map(entities, productDto.class);
        return dto;
    }

    ;

    @Override
    public void deleteProductById(short id) {
        productRepository.deleteById(id);
    }

    ;

    @Override
    public void updateProductById(short id, updateProductForm form) throws Exception{
        product product = productRepository.findById(id).orElseThrow(() -> new Exception("San pham khong ton tai"));
        if (form.getName() != null) product.setName(form.getName());
        if (form.getPrice() != null) product.setPrice(form.getPrice());
        if (form.getStock_quantity() != null) product.setStockQuantity(form.getStock_quantity());
        if (form.getCapacity() != null) product.setCapacity(form.getCapacity());
        if (form.getColor() != null) product.setColor(form.getColor());
        productRepository.save(product);
    }

    @Override
    public void createProduct(createProductForm form) throws Exception{
        if (form.getName() == null || form.getName().trim().isEmpty())throw new Exception("Ten san pham khong duoc de trong");
        if (form.getPrice() == null || form.getPrice().doubleValue() < 0)throw new Exception("Gia phai lon hon hoac bang 0");
        if (form.getStock_quantity() == null || form.getStock_quantity() < 0) throw new Exception("So luong phai lon hon hoac bang 0");

        product product = new product();
        product.setName(form.getName());
        product.setPrice(form.getPrice());
        product.setStockQuantity(form.getStock_quantity());
        product.setCapacity(form.getCapacity());
        product.setColor(form.getColor());

        productRepository.save(product);

    };
}
