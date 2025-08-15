package com.vti.service;

import com.vti.dto.supplierDto;
import com.vti.entity.product;
import com.vti.entity.supplier;
import com.vti.form.createCustomerForm;
import com.vti.form.createSupplierForm;
import com.vti.form.updateCustomerForm;
import com.vti.form.updateSupplierForm;
import com.vti.repository.ISupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class supplierService implements  ISupplierService{
    @Autowired
    private ISupplierRepository supplierRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<supplierDto> getAllSupplier(Pageable pageable){
        Page<supplier> suppliers = supplierRepository.findAll(pageable);
        Page<supplierDto> supplierDtos = suppliers.map(new Function<supplier, supplierDto>(){
            @Override
            public supplierDto apply(supplier supplier){
                supplierDto supplierDto = mapper.map(supplier, supplierDto.class);
                return supplierDto;
            };
        });
        return supplierDtos;
    };

    @Override
    public supplierDto getSupplierById(short id){
        supplier supplier = supplierRepository.getById(id);
        supplierDto dto = mapper.map(supplier, supplierDto.class);
        return dto;
    };

    @Override
    public void deleteSupplierById(short id){
        supplierRepository.deleteById(id);
    };

    public void updateSupplierById(short id, updateSupplierForm form) throws Exception {
        supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new Exception("Nha cung cap khong ton tai"));
        if (form.getAddress() != null) supplier.setAddress(form.getAddress());
        if (form.getPhone_num() != null) supplier.setPhoneNum(form.getPhone_num());
        supplierRepository.save(supplier);
    };

    public void createSupplier(createSupplierForm form) throws Exception{
        if (form.getEmail() == null || form.getName() == null || form.getPhone_num() == null) {
            throw new Exception("Thieu thong tin bat buoc");
        }
        supplier supplier = new supplier();
        supplier.setEmail(form.getEmail());
        supplier.setName(form.getName());
        supplier.setAddress(form.getAddress());
        supplier.setPhoneNum(form.getPhone_num());
        supplierRepository.save(supplier);
    };

}
