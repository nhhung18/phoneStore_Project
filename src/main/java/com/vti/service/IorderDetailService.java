package com.vti.service;

import com.vti.dto.orderDetailDto;
import com.vti.entity.orderDetail;
import com.vti.form.createOrderDetailForm;
import com.vti.form.updateOrderDetailForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IorderDetailService {
    Page<orderDetailDto> getAllOrderDetail(Pageable pageable);

    orderDetailDto getOrderDetailById(short id);

    void deleteOrderDetailById(short id);

    void updateOrderDetailById(short id, updateOrderDetailForm form) throws Exception;

    void createOrderDetail(createOrderDetailForm form) throws Exception;
}
