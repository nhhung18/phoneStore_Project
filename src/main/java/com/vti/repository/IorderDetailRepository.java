package com.vti.repository;

import com.vti.entity.orderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IorderDetailRepository extends JpaRepository<orderDetail, Short> {
}
