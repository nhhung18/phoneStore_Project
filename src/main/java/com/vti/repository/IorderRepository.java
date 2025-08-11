package com.vti.repository;

import com.vti.entity.order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.border.Border;

public interface IorderRepository extends JpaRepository<order, Short> {
}
