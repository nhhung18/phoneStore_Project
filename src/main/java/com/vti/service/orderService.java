package com.vti.service;

import com.vti.dto.orderDto;
import com.vti.entity.customer;
import com.vti.entity.order;
import com.vti.form.createOrderForm;
import com.vti.form.updateOrderForm;
import com.vti.repository.ICustomerRepository;
import com.vti.repository.IorderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class orderService implements IorderService {
    @Autowired
    private IorderRepository iorderRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Autowired
    private ModelMapper mapper;


    @Override
    public Page<orderDto> getAllOrder(Pageable pageable) {
        // Lấy dữ liệu theo phân trang
        Page<order> orders = iorderRepository.findAll(pageable);
        Page<orderDto> orderDtos = orders.map(new Function<order, orderDto>() {
            @Override
            public orderDto apply(order order) {
                orderDto orderDto = mapper.map(order, orderDto.class);
                return orderDto;
            }
        });
        return orderDtos;
    }

    @Override
    public orderDto getOrderById(short id) {
        order entities = iorderRepository.getById(id);
        orderDto dto = mapper.map(entities, orderDto.class);
        return dto;
    }

    ;

    @Override
    public void deleteOrderById(short id) {
        iorderRepository.deleteById(id);
    }

    ;

    @Override
    public void updateOrderById(short id, updateOrderForm form) throws Exception {
        order order = iorderRepository.findById(id)
                .orElseThrow(() -> new Exception("Don hang khong ton tai"));

        if (form.getPaying_status() != null)
            order.setPaying_status(form.getPaying_status());

        if (form.getShip_status() != null)
            order.setShip_status(form.getShip_status());

        iorderRepository.save(order);
    }

    @Override
    public void createOrder(createOrderForm form) throws Exception {
        // Kiểm tra customer có tồn tại
        customer customer = iCustomerRepository.findById(form.getCustomer_id().getId()).orElseThrow(() -> new Exception("Khach hang khong ton tai"));
        order order = new order();
        order.setCustomer_id(customer); // Lưu entity customer
        order.setPaying_status(form.getPaying_status());
        order.setShip_status(form.getShip_status());

        iorderRepository.save(order);
    }

}
