package com.vti.service;

import com.vti.entity.orderDetail;
import com.vti.repository.IorderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderDetailService implements IorderDetailService{
    @Autowired
    private IorderDetailRepository iorderDetailRepository;

    @Override
    public List<orderDetail> getSupPro(){
        return iorderDetailRepository.findAll();
    };
}
