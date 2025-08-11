package com.vti.repository;

import com.vti.entity.supPro;
import com.vti.entity.supProID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupProRepository extends JpaRepository<supPro, supProID> {
}
