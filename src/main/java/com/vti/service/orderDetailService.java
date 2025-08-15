package com.vti.service;

import com.vti.dto.orderDetailDto;
import com.vti.entity.order;
import com.vti.entity.orderDetail;
import com.vti.form.createOrderDetailForm;
import com.vti.form.updateOrderDetailForm;
import com.vti.repository.IProductRepository;
import com.vti.repository.IorderDetailRepository;
import com.vti.repository.IorderRepository;
import jakarta.persistence.criteria.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class orderDetailService implements IorderDetailService{
    @Autowired
    private IorderDetailRepository iorderDetailRepository;
    @Autowired
    private IorderRepository iorderRepository;
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<orderDetailDto> getAllOrderDetail(Pageable pageable) {
        // Lấy dữ liệu theo phân trang
        Page<orderDetail> orderdetails = iorderDetailRepository.findAll(pageable);
        Page<orderDetailDto> orderdetailDtos = orderdetails.map(new Function<orderDetail,orderDetailDto>() {
            @Override
            public orderDetailDto apply(orderDetail orderdetail) {
                orderDetailDto orderdetailDto = mapper.map(orderdetail, orderDetailDto.class);
                return orderdetailDto;
            }
        });
        return orderdetailDtos;
    }

    @Override
    public orderDetailDto getOrderDetailById(short id) {
        orderDetail entities = iorderDetailRepository.getById(id);
        orderDetailDto dto = mapper.map(entities, orderDetailDto.class);
        return dto;
    }

    ;

    @Override
    public void deleteOrderDetailById(short id) {
        iorderDetailRepository.deleteById(id);
    }

    ;

    @Override
    public void updateOrderDetailById(short id, updateOrderDetailForm form) throws Exception {
        orderDetail orderdetail = iorderDetailRepository.findById(id).orElseThrow(() -> new Exception("Don hang chi tiet khong ton tai"));
        if (form.getOrder_id() != null) orderdetail.setOrder_id(iorderRepository.findById(form.getOrder_id().getOrder_id()).orElseThrow(() -> new Exception("Don hang khong ton tai")));
        if (form.getProduct_id() != null) orderdetail.setProduct_id(iProductRepository.findById(form.getProduct_id().getId()).orElseThrow(() -> new Exception("San pham khong ton tai")));
        if (form.getQuantity() != null) orderdetail.setQuantity(form.getQuantity());
        iorderDetailRepository.save(orderdetail);
    }

    @Override
    public void createOrderDetail(createOrderDetailForm form) throws Exception {
        orderDetail orderDetail = mapper.map(form, orderDetail.class);
        orderDetail.setOrder_id(iorderRepository.findById(form.getOrder_id().getOrder_id()).orElseThrow(() -> new Exception("Don hang khong ton tai")));
        orderDetail.setProduct_id(iProductRepository.findById(form.getProduct_id().getId()).orElseThrow(() -> new Exception("San pham khong ton tai")));
        iorderDetailRepository.save(orderDetail);
    };
}
