package com.vti.repository;
import com.vti.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository là một interface có sẵn của Spring Data JPA,
// cung cấp sẵn hàng loạt hàm CRUD và query, ví dụ:
//        findAll()
//        findById(ID id)

public interface ICustomerRepository extends JpaRepository<customer, Short> {
    public customer findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
