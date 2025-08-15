package com.vti.service;

import com.vti.dto.orderDto;
import com.vti.entity.order;
import com.vti.form.createOrderForm;
import com.vti.form.updateOrderForm;
import com.vti.repository.IOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.lang.reflect.AccessibleObject;
import java.util.List;
import java.util.function.Function;

@Service
public class orderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<orderDto> getAllOrder(Pageable pageable) {
        // Lấy dữ liệu theo phân trang
        Page<order> orders = orderRepository.findAll(pageable);
        Page<orderDto> orderDtos = orders.map(new Function<order,orderDto>() {
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
        order entities = orderRepository.getById(id);
        orderDto dto = mapper.map(entities, orderDto.class);
        return dto;
    }

    ;

    @Override
    public void deleteOrderById(short id) {
        orderRepository.deleteById(id);
    }

    ;

    @Override
    public void updateOrderById(short id, updateOrderForm form) {
        order order = orderRepository.getById(id);
        if (form.getName() != null) order.setName(form.getName());
        if (form.getPrice() != null) order.setPrice(form.getPrice());
        if (form.getStock_quantity() != null) order.setStockQuantity(form.getStock_quantity());
        if (form.getCapacity() != null) order.setCapacity(form.getCapacity());
        if (form.getColor() != null) order.setColor(form.getColor());
        orderRepository.save(order);
    }

    @Override
    public void createOrder(createOrderForm form){
        order order = new order();
        order.setName(form.getName());
        order.setPrice(form.getPrice());
        order.setStockQuantity(form.getStock_quantity());
        order.setCapacity(form.getCapacity());
        order.setColor(form.getColor());
        orderRepository.save(order);

    };
}
