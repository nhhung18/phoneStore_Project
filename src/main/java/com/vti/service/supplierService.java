package com.vti.service;

import com.vti.entity.supplier;
import com.vti.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class supplierService implements  ISupplierService{
    @Autowired
    private ISupplierRepository supplierRepository;
    @Override
    public List<supplier> getAllCustomer(){
        return supplierRepository.findAll();
    }

}
