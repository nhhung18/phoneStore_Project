package com.vti.service;

import com.vti.dto.orderdetailDto;
import com.vti.entity.orderdetail;
import com.vti.form.createOrderDetailForm;
import com.vti.form.updateOrderDetailForm;
import com.vti.repository.IOrderDetailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.lang.reflect.AccessibleObject;
import java.util.List;
import java.util.function.Function;

@Service
public class orderdetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderdetailRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<orderdetailDto> getAllOrderDetail(Pageable pageable) {
        // Lấy dữ liệu theo phân trang
        Page<orderdetail> orderdetails = orderdetailRepository.findAll(pageable);
        Page<orderdetailDto> orderdetailDtos = orderdetails.map(new Function<orderdetail,orderdetailDto>() {
            @Override
            public orderdetailDto apply(orderdetail orderdetail) {
                orderdetailDto orderdetailDto = mapper.map(orderdetail, orderdetailDto.class);
                return orderdetailDto;
            }
        });
        return orderdetailDtos;
    }

    @Override
    public orderdetailDto getOrderDetailById(short id) {
        orderdetail entities = orderdetailRepository.getById(id);
        orderdetailDto dto = mapper.map(entities, orderdetailDto.class);
        return dto;
    }

    ;

    @Override
    public void deleteOrderDetailById(short id) {
        orderdetailRepository.deleteById(id);
    }

    ;

    @Override
    public void updateOrderDetailById(short id, updateOrderDetailForm form) {
        orderdetail orderdetail = orderdetailRepository.getById(id);
        if (form.getName() != null) orderdetail.setName(form.getName());
        if (form.getPrice() != null) orderdetail.setPrice(form.getPrice());
        if (form.getStock_quantity() != null) orderdetail.setStockQuantity(form.getStock_quantity());
        if (form.getCapacity() != null) orderdetail.setCapacity(form.getCapacity());
        if (form.getColor() != null) orderdetail.setColor(form.getColor());
        orderdetailRepository.save(orderdetail);
    }

    @Override
    public void createOrderDetail(createOrderDetailForm form){
        orderdetail orderdetail = new orderdetail();
        orderdetail.setName(form.getName());
        orderdetail.setPrice(form.getPrice());
        orderdetail.setStockQuantity(form.getStock_quantity());
        orderdetail.setCapacity(form.getCapacity());
        orderdetail.setColor(form.getColor());
        orderdetailRepository.save(orderdetail);

    };
}
