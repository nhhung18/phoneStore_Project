package com.vti.service;

import com.vti.dto.supplierDto;
import com.vti.entity.supplier;
import com.vti.form.createCustomerForm;
import com.vti.form.createSupplierForm;
import com.vti.form.updateCustomerForm;
import com.vti.form.updateSupplierForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISupplierService {
    Page<supplierDto> getAllSupplier(Pageable pageable);

    supplierDto getSupplierById(short id);

    void deleteSupplierById(short id);

    void updateSupplierById(short id, updateSupplierForm form) throws Exception;

    void createSupplier(createSupplierForm form) throws Exception;
}
