package com.vti.repository;


import com.vti.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<product, Short> {

}
