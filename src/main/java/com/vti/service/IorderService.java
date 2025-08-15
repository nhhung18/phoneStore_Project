package com.vti.service;

import com.vti.dto.orderDto;
import com.vti.entity.order;
import com.vti.form.createOrderForm;
import com.vti.form.updateOrderForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IorderService {
    Page<orderDto> getAllOrder(Pageable pageable);

    orderDto getOrderById(short id);

    void deleteOrderById(short id);

    void updateOrderById(short id, updateOrderForm form) throws Exception;

    void createOrder(createOrderForm form) throws Exception;
}
