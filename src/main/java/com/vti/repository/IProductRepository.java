package com.vti.repository;


import com.vti.entity.product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface IProductRepository extends JpaRepository<product, Short> {
    product findByNameContainingIgnoreCase(String name);
}
