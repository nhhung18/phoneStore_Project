package com.vti.repository;

import com.vti.entity.supplier;
import com.vti.service.ISupplierService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepository extends JpaRepository<supplier, Short> {
}
